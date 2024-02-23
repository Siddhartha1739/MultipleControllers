package com.example.EmployeeDatabase.Service;

import com.example.EmployeeDatabase.Entity.Employee;
import com.example.EmployeeDatabase.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class EmployeeServiceImp {
    @Autowired
    private EmployeeRepository employeeRepository;


    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void delEmployee(int empId){
        employeeRepository.deleteById(empId);
    }

    public void updateEmployee(int empId,String firstName,String lastName,String role,int sal){
        Employee employee=employeeRepository.getReferenceById(empId);
        String fName=employee.getFirstName();
        String lName=employee.getLastName();
        String emprole= employee.getRole();
        int salary=employee.getSalary();
        fName=firstName;
        lName=lastName;
        emprole=role;
        salary=sal;
        employeeRepository.save(new Employee(empId,fName,lName,emprole,salary));
    }
   public HashMap<Integer, Employee> viewEmployees() {
        HashMap<Integer,Employee> map=new HashMap<>();
        List<Employee> employeeList=employeeRepository.findAll();
        for(Employee emp: employeeList){
            map.put(emp.getEmpId(),emp);
        }
       return map;
    }

    public Employee getEmployeeById(int empId) {
        return employeeRepository.getReferenceById(empId);
    }

    public boolean existEmp(int empId){
       return employeeRepository.existsById(empId);
    }
}
