package com.springJDBC.service;

import com.springJDBC.Entity.Employee;
import com.springJDBC.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public String saveEmployee(Employee employee){

        int count = repository.save(employee);
        return "RECORD INSERTED! "+ count;
    }

    public List<Employee> getEmployees(){

        return repository.findAll();
    }

    public List<Employee> getEmployeesUsingBeanPropertyRowMapper(){
        return repository.getAllEmployees();
    }

    public Employee getEmployeeById(int id){

        return repository.findById(id);
    }

    public String getNameById(int id){

        return repository.getNameById(id);
    }
    public List<Employee> getEmployeesByNameAndDepartment(String name, String dept){

        return repository.findByNameAndDept(name,dept);
    }

    public String update(Employee employee){
        int count =  repository.update(employee);
        return count + "Record UPDATED";

    }

    public String deleteEmployee(int id){
        int count =  repository.delete(id);
        return count + "Record deleted";

    }
}
