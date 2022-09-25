package com.springJDBC.Controller;

import com.springJDBC.Entity.Employee;
import com.springJDBC.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public String saveEmployee(@RequestBody Employee employee){

        return service.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getEmployees(){

        return service.getEmployees();
    }
    @GetMapping("/second")
    public List<Employee> getEmployeesSecond(){
        return service.getEmployeesUsingBeanPropertyRowMapper();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){

        return service.getEmployeeById(id);
    }

    @GetMapping("/name/{id}")
    public String getNameById(@PathVariable int id){

        return service.getNameById(id);
    }
    @GetMapping("/{name}/{dept}")
    public List<Employee> getEmployeesByNameAndDepartment(@PathVariable String name, @PathVariable String dept){

        return service.getEmployeesByNameAndDepartment(name,dept);
    }
    @PutMapping
    public String update(@RequestBody Employee employee){
       return  service.update(employee);

    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        return   service.deleteEmployee(id);
    }
}
