package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.AktorJawabanEntity;
import com.catdemo.demo.entity.SoalJawabanEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.payload.request.AktorJawabanRequest;
import com.catdemo.demo.service.AktorJawabanService;
import com.catdemo.demo.util.constants.AktorJawabanConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        isNullFieldChajer(request);
        try {
            AktorJawabanEntity aje = new AktorJawabanEntity();
            aje.setAktorEntity(repo.getAktorRepository().findById(request.getIdAktorEntity()).get());
            aje.setUjianEntity(repo.getUjianRepository().findById(request.getIdUjianEntity()).get());
            aje.setSoalEntity(repo.getSoalRepository().findById(request.getIdSoalEntity()).get());
            SoalJawabanEntity sfe = repo.getSoalJawabanRepository().findById(request.getIdSoalJawabanEntity()).get();
            aje.setSoalJawabanEntity(repo.getSoalJawabanRepository().findById(request.getIdSoalJawabanEntity()).get());
            aje.setCreateDate(timeDo.format(new Date()));
            aje.setVersion((long)1);
            aje.setStatus(AktorJawabanConstant.AKTORJAWABANACTVE);
            aje.setSkor(sfe.getSkor());
            repo.getAktorJawabanRepository().save(aje);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
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

    private void isNullFieldChajer(AktorJawabanRequest request)throws Exception{
        if (request.getIdAktorEntity()==null){
            throw new Exception(AktorJawabanConstant.IDACTORNULL);
        }else if(request.getIdSoalEntity()==null){
            throw new Exception(AktorJawabanConstant.IDSOALNULL);
        }else if(request.getIdUjianEntity()==null){
            throw new Exception(AktorJawabanConstant.IDUJIANNULL);
        }else if (request.getIdSoalJawabanEntity()==null){
            throw new Exception(AktorJawabanConstant.IDSOALJAWABANNULL);
        }
    }
}
