package com.espark.adarsh.bean;

import com.espark.adarsh.config.ApplicationConfigProps;
import lombok.Data;

import java.io.Serializable;

@Data
public class DataBean implements Serializable {

    private String name;
    private String message;
    private String profile;

    public DataBean() {

    }

    public DataBean(ApplicationConfigProps props) {
        this.name = props.getName();
        this.message = props.getMessage();
        this.profile = props.getProfile();
    }

}
