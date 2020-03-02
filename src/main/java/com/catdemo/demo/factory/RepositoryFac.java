package com.catdemo.demo.factory;
import com.catdemo.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryFac {
    @Autowired
    AktorRepository aktorRepository;
    public  AktorRepository getAktorRepository(){
        return aktorRepository;
    }
    @Autowired
    SoalJenisRepository soalJenisRepository;
    public SoalJenisRepository getSoalJenisRepository(){ return soalJenisRepository; }
    @Autowired
    SoalKelompokRepository soalKelompokRepository;
    public SoalKelompokRepository getSoalKelompokRepository(){ return soalKelompokRepository;}
    @Autowired
    SoalRepository soalRepository;
    public SoalRepository getSoalRepository(){return soalRepository;}
    @Autowired
    SoalJawabanRepository soalJawabanRepository;
    public SoalJawabanRepository getSoalJawabanRepository(){return soalJawabanRepository;}
    @Autowired
    UjianRepository ujianRepository;
    public UjianRepository getUjianRepository(){return ujianRepository;}
    @Autowired
    AktorJawabanRepository aktorJawabanRepository;
    public AktorJawabanRepository getAktorJawabanRepository(){return aktorJawabanRepository;}
    @Autowired
    UjianSettingRepository ujianSettingRepository;
    public UjianSettingRepository getUjianSettingRepository(){return ujianSettingRepository;}












    //
    @Autowired
    UjianSoalRepository ujianSoalRepository;

    public UjianSoalRepository getUjianSoalRepository() {
        return ujianSoalRepository;
    }
}
