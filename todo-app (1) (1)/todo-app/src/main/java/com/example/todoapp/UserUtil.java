package com.example.todoapp;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.sql.*;
import java.time.Instant;

public class UserUtil {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    Statement statement = null;

    public boolean create(User user, DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
        String sql = "INSERT INTO USERS (username, password, email, created_on) VALUES (?, ?, ?, ?)";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setString(1, user.getUsername());
        this.preparedStatement.setString(2, user.getPassword());
        this.preparedStatement.setString(3, user.getEmail());
        this.preparedStatement.setTimestamp(4, Timestamp.from(Instant.now()));
        boolean result = this.preparedStatement.execute();
        this.close();
        return result;
    }

    public boolean isValidUser(String username, String password, DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
        String sql = "SELECT username, password FROM USERS where username = ? and password = ?";
        this.preparedStatement = connection.prepareStatement(sql);
        this.preparedStatement.setString(1, username);
        this.preparedStatement.setString(2, password);
        ResultSet result = this.preparedStatement.executeQuery();
        boolean response = false;
        if (result.next()) {
            if (username.equals(result.getString(1)) && password.equals(result.getString(2))) {
                response = true;
            }
        }
        this.close();
        return response;
    }

    private void close() throws SQLException {
        if (this.connection != null)
            this.connection.close();
        if (this.preparedStatement != null)
            this.preparedStatement.close();
        if (this.statement != null)
            this.statement.close();
    }
}
