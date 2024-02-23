package com.example.EmployeeDatabase.Entity;


import com.example.EmployeeDatabase.Model.EmployeeModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "PROJECTS")
public class Project {
    @Id
    private int id;
    private String name;

    public Project() {
    }
    public Project(int id, String name) {
        this.id = id;
        this.name = name;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
