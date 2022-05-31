package com.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull(message = "name cannot be empty")
    @Column(name = "cname")
    private String cname;

    public Courses(){};

    public Courses(int id, String cname){
        this.id = id;
        this.cname = cname;
    };

    public String getCname() {
        return cname;
    }


    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
