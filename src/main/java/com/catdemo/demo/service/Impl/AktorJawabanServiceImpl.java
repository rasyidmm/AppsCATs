package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.AktorJawabanEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.payload.request.AktorJawabanRequest;
import com.catdemo.demo.service.AktorJawabanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AktorJawabanServiceImpl implements AktorJawabanService {
    @Autowired
    RepositoryFac repo;
    private SimpleDateFormat timeDo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    @Override
    public AktorJawabanEntity getAktorJawabanById(UUID id) {
        return null;
    }

    @Override
    public void SaveAktorJawaban(AktorJawabanRequest request) throws Exception {

    }

    @Override
    public void UpdateAktorJawaban(AktorJawabanRequest request) throws Exception {

    }

    @Override
    public void deleteAktorJawabanById(UUID id) {

    }

    @Override
    public void deleteAktorJawabanStatById(UUID id) throws Exception {

    }

    @Override
    public List<AktorJawabanEntity> getAktorJawabanStatActive() {
        return null;
    }

    @Override
    public List<AktorJawabanEntity> getAktorJawabanStatDisable() {
        return null;
    }

    @Override
    public void updateAktorJawabanStatActive(UUID id) throws Exception {

    }
}
