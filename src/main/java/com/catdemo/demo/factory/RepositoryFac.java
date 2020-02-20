package com.catdemo.demo.factory;
import com.catdemo.demo.repository.AktorJawabanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryFac {
    @Autowired
    AktorJawabanRepository aktorJawabanRepository;
    public  AktorJawabanRepository getAktorJawabanRepository(){
        return aktorJawabanRepository;
    }
}
