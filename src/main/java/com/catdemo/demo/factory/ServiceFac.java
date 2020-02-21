package com.catdemo.demo.factory;

import com.catdemo.demo.service.SoalJenisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFac {
    @Autowired
    SoalJenisService soalJenisService;
    public SoalJenisService getSoalJenisService(){
        return soalJenisService;
    }
}
