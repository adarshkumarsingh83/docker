package com.espark.adarsh.respository;


import com.espark.adarsh.bean.Employee;
import org.springframework.data.solr.repository.SolrCrudRepository;


public interface EmployeeRepository extends SolrCrudRepository<Employee, String> {

    @org.springframework.data.solr.repository.Query("name:?0")
    java.util.List<com.espark.adarsh.bean.Employee> findByName(String name);


    @org.springframework.data.solr.repository.Query("name:?0")
    java.util.List<com.espark.adarsh.bean.Employee> findByNameLike(String name);

    @org.springframework.data.solr.repository.Query("age:?0")
    java.util.List<com.espark.adarsh.bean.Employee> findByAge(Integer age);
}