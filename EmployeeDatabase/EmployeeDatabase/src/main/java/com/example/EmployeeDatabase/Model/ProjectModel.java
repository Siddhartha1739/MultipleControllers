package com.example.EmployeeDatabase.Model;

import lombok.*;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectModel {
    private int id;
    private String name;
    private List<EmployeeModel> empList;
}
