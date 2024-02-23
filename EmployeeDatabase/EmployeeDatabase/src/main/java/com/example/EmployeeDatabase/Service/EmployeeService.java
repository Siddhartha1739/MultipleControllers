package com.example.EmployeeDatabase.Service;





import com.example.EmployeeDatabase.Entity.Employee;

import java.util.HashMap;

public interface EmployeeService {
    void addEmployee(Employee employee);

    void delEmployee(int empId);
    Employee getEmployeeById(int empId);

    HashMap<Integer, Employee> viewEmployees();
}

