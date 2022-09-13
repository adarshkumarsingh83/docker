package com.espark.adarsh.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {

    private String empName;
    private String empId;

    @Override
    public String toString() {
        return "Employee [empName=" + empName + ", empID=" + empId + "]";
    }

}
