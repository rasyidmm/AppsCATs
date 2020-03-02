package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.AktorJawabanEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.service.AktorJawabanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AktorJawabanServiceImpl implements AktorJawabanService {
    @Autowired
    RepositoryFac repo;
    @Override
    public List<AktorJawabanEntity> getAllJawaban() {
        List<AktorJawabanEntity> ajl = new ArrayList<>();
        repo.getAktorJawabanRepository().findAll().forEach(ajl::add);
        return  ajl;
    }

    @Override
    public AktorJawabanEntity getAktorJabawanByid(UUID id) {
        AktorJawabanEntity aj = repo.getAktorJawabanRepository().findById(id).get();
        return aj;
    }
}
