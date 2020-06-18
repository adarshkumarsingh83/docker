package com.espark.adarsh.entity;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Data
@Table("employee")
public class Employee {

    @PrimaryKey
    private Long id;

    private String name;
}
