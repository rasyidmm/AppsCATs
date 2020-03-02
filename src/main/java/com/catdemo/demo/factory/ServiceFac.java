package com.catdemo.demo.factory;

import com.catdemo.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServiceFac {
    @Autowired
    AktorService aktorService;
    public AktorService getAktorService(){return  aktorService;}
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
    @Autowired
    UjianService ujianService;
    public UjianService getUjianService(){return ujianService;}
    @Autowired
    UjianSettingService ujianSettingService;
    public UjianSettingService getUjianSettingService(){return ujianSettingService;}
}
