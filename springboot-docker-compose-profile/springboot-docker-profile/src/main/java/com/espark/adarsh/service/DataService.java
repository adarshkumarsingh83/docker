package com.espark.adarsh.service;

import com.espark.adarsh.bean.DataBean;
import com.espark.adarsh.config.ApplicationConfigProps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    @Autowired
    ApplicationConfigProps applicationConfigProps;

    public DataBean getData() {
        return new DataBean(applicationConfigProps);
    }
}
