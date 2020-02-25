package com.catdemo.demo.factory;

import com.catdemo.demo.service.SoalJawabanService;
import com.catdemo.demo.service.SoalJenisService;
import com.catdemo.demo.service.SoalKelompokService;
import com.catdemo.demo.service.SoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFac {
    @Autowired
    SoalJenisService soalJenisService;
    public SoalJenisService getSoalJenisService(){
        return soalJenisService;
    }
    @Autowired
    SoalKelompokService soalKelompokService;
    public SoalKelompokService getSoalKelompokService(){ return soalKelompokService;}
    @Autowired
    SoalService soalService;
    public SoalService getSoalService(){return soalService;}
    @Autowired
    SoalJawabanService soalJawabanService;
    public SoalJawabanService getSoalJawabanService(){return soalJawabanService;}
}
