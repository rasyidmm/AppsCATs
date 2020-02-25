package com.catdemo.demo.factory;
import com.catdemo.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryFac {
    @Autowired
    AktorJawabanRepository aktorJawabanRepository;
    public  AktorJawabanRepository getAktorJawabanRepository(){
        return aktorJawabanRepository;
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
}
