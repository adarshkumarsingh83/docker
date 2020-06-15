package com.espark.adarsh.entity;


import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@Table("employee")
public class Employee {

    @PrimaryKey
    private UUID id;

    private String name;
}
