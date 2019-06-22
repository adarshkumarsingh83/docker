package com.espark.adarsh.service;

import com.espark.adarsh.bean.Employee;
import com.espark.adarsh.respository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public Optional<Employee> getEmployee(String id){
        return this.employeeRepository.findById(id);
    }

    public  java.util.List<com.espark.adarsh.bean.Employee> getEmployeeByName(String name){
        return this.employeeRepository.findByName(name);
    }

    public  java.util.List<com.espark.adarsh.bean.Employee> getEmployeeLikeByName(String name){
        return this.employeeRepository.findByNameLike(name);
    }

    public java.util.List<Employee> getEmployeeByAge(Integer age){
        return this.employeeRepository.findByAge(age);
    }
}
