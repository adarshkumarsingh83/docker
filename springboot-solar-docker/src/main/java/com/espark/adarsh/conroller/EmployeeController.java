package com.espark.adarsh.conroller;

import com.espark.adarsh.bean.Employee;
import com.espark.adarsh.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/employee")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return this.employeeService.saveEmployee(employee);
    }

    @GetMapping(value = "/employee/{id}")
    public Employee getEmployee(@org.springframework.web.bind.annotation.PathVariable("id") String id) {
        Optional<Employee> optionalEmployee = this.employeeService.getEmployee(id);
        return optionalEmployee.isPresent() ? optionalEmployee.get() : null;
    }

    @GetMapping(value = "/employee/name/{name}")
    public  java.util.List<com.espark.adarsh.bean.Employee> getEmployeeByName(@org.springframework.web.bind.annotation.PathVariable("name") String name) {
        java.util.List<com.espark.adarsh.bean.Employee> employee = this.employeeService.getEmployeeByName(name);
        return employee;
    }

    @GetMapping(value = "/employee/name-like/{name}")
    public  java.util.List<com.espark.adarsh.bean.Employee> getEmployeeByLikeName(@org.springframework.web.bind.annotation.PathVariable("name") String name) {
        java.util.List<com.espark.adarsh.bean.Employee> employee = this.employeeService.getEmployeeLikeByName(name);
        return employee;
    }

    @GetMapping(value = "/employee/age/{age}")
    public java.util.List<com.espark.adarsh.bean.Employee> getEmployeeByName(@org.springframework.web.bind.annotation.PathVariable("age") Integer age) {
        java.util.List<com.espark.adarsh.bean.Employee> employee = this.employeeService.getEmployeeByAge(age);
        return employee;
    }


}
