package com.example.EmployeeDatabase.Controller;

import com.example.EmployeeDatabase.Entity.Employee;

import com.example.EmployeeDatabase.Service.EmployeeServiceImp;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class EmployeeController {
    @Autowired
    private EmployeeServiceImp employeeService;

    @RequestMapping("/first")
    public String firstpage(){
        System.out.println("THIS IS MY FIRST PAGE");
        return "first";
    }
    @RequestMapping("/addEmp")
    public String  addEmploye(){
        System.out.println("Employee Details:");
        return "addEmp";
    }

    @RequestMapping("/addedEmployee")
    public String addedEmployee(Employee employee,ModelMap map,int empId){
       if( employeeService.viewEmployees().containsKey(empId)){return "DataExist";}
        System.out.println("added Employee");
        employeeService.addEmployee(employee);
        map.addAttribute("employee",employee);
        String name=employee.getFirstName()+" "+employee.getLastName();
        map.put("name",name);
        return "emp";
    }

    @RequestMapping("/viewEmp")
    public String viewEmploys(ModelMap model){
        Map<Integer, Employee> employeeMap=employeeService.viewEmployees();
        System.out.println("view Employees");
        model.addAttribute("EmployeeMap",employeeMap);
        return "viewEmp";
    }

    @RequestMapping("/search")
    public String  search(){
        System.out.println("Employee Details searching:");
        return "searchEmp";
    }

    @RequestMapping("/searchEmployee")
    public String searchEmployee(int employeeId,ModelMap model){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if(!employeeService.existEmp(employeeId)){ return "DataNotFound";}
        System.out.println("Employee Details searched!!!!!" + employeeId);
        String name = employee.getFirstName() + " " + employee.getLastName();
        int empId = employee.getEmpId();
        String role = employee.getRole();
        model.addAttribute("name", name);
        model.addAttribute("empId", empId);
        model.addAttribute("role", role);
        return "searchedEmp";
    }

    @RequestMapping("/delete")
    public String  delete(){
        System.out.println("Employee Details deleting:");
        return "delEmp";
    }
    @RequestMapping("/deleteEmployee")

    public String deleteEmployee(int employeeId,ModelMap model){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if(!employeeService.existEmp(employeeId)){ return "DataNotFound";}
        employeeService.delEmployee(employeeId);
        System.out.println("Employee details deleted...");
        Map<Integer, Employee> employeeMap=employeeService.viewEmployees();
        System.out.println("view after delete Employee");
        model.addAttribute("EmployeeMap",employeeMap);
        return "viewEmp";
    }
    @RequestMapping("/update")
    public String  update(){
        System.out.println("Employee Details updating:");
        return "update";
    }
    @RequestMapping("/updateEmployee")
    public String updateEmployee(int employeeId,ModelMap model){
        Employee employee = employeeService.getEmployeeById(employeeId);
        if(!employeeService.existEmp(employeeId)){ return "DataNotFound";}
        System.out.println("Employee Details updated!!!!!"+employeeId);
        String firstName=employee.getFirstName();
        String lastName=employee.getLastName();
        int empId=employee.getEmpId();
        String role=employee.getRole();
        int salary=employee.getSalary();
        model.addAttribute("firstName",firstName);
        model.addAttribute("lastName",lastName);
        model.addAttribute("empId",empId);
        model.addAttribute("role",role);
        model.addAttribute("salary",salary);
        return "updating";
    }
    @RequestMapping("/updated")
    public String updated(int empId,String firstName,String lastName,String role,int sal,ModelMap model){
        employeeService.updateEmployee(empId,firstName, lastName, role,sal);
        Map<Integer, Employee> employeeMap=employeeService.viewEmployees();
        System.out.println("view Employees");
        model.addAttribute("EmployeeMap",employeeMap);
        return "viewEmp";
    }

    @RequestMapping("/DataNotFound")
    public String DataNotFound(){
        return "DataNotFound";
    }
}
