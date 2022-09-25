package com.springJDBC.repository.impl;

import com.springJDBC.Entity.Employee;
import com.springJDBC.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Employee employee) {

        return jdbcTemplate.update("INSERT INTO employee( name,dept,email,doj) values(?, ?, ?, ?)",

                employee.getName(),employee.getDept(),employee.getEmail(),employee.getDoj());

    }

    @Override
    public List<Employee> findAll() {

        return jdbcTemplate.query("SELECT * FROM employee",new EmployeeRowMapper());

    }

    @Override
    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query("SELECT * FROM employee",
                new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public Employee findById(int id) {
        return jdbcTemplate.queryForObject("select * from employee where id=?",
                new BeanPropertyRowMapper<>(Employee.class),id);
    }

    @Override
    public String getNameById(int id) {
        return jdbcTemplate.queryForObject("select name from where id =? ",String.class,id);
    }

    @Override
    public List<Employee> findByNameAndDept(String name, String dept) {
        return jdbcTemplate.query("select * from employee where name=? and dept=?",
                new BeanPropertyRowMapper<>(Employee.class), name, dept);

    }

    @Override
    public int update(Employee employee) {
        return jdbcTemplate.update("update employee set name=?, dept=?, email=?, doj=? where id=?",
                employee.getName(),employee.getDept(),employee.getEmail(),employee.getDoj(),employee.getId());
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from employee where id=?",id);
    }
}
