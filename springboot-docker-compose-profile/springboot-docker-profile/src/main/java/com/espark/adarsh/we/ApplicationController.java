package com.espark.adarsh.we;

import com.espark.adarsh.bean.DataBean;
import com.espark.adarsh.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicationController {

    @Autowired
    DataService dataService;

    @GetMapping("/data")
    public DataBean getData() {
        return this.dataService.getData();
    }
}
