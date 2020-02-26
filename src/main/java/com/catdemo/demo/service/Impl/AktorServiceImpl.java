package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.AktorEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.payload.request.AktorRequest;
import com.catdemo.demo.service.AktorService;
import com.catdemo.demo.util.constants.AktorConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class AktorServiceImpl implements AktorService {
    @Autowired
    RepositoryFac repo;
    private SimpleDateFormat timeDo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    @Override
    public List<AktorEntity> getAllAktor() {
        List<AktorEntity> ael = new ArrayList<>();
        repo.getAktorRepository().findAll().forEach(ael::add);
        return ael;
    }

    @Override
    public AktorEntity getAktorById(UUID id) {
        AktorEntity ae = repo.getAktorRepository().findById(id).get();
        return ae;
    }

    @Override
    public void SaveAktor(AktorRequest request) throws Exception {
        isExisting(request);
        FieldNullChecker(request);
        try {
            AktorEntity aktorEntity = new AktorEntity();
            aktorEntity.setAlamatRumah(request.getAlamatRumah());
            aktorEntity.setEmailActor(request.getEmailActor());
            aktorEntity.setJenisKelamin(request.getJenisKelamin());
            aktorEntity.setNamaDepan(request.getNamaDepan());
            aktorEntity.setNamaBelakang(request.getNamaBelakang());
            aktorEntity.setUsername(request.getUsername());
            aktorEntity.setPassword(request.getPassword());
            aktorEntity.setNoHandphone(request.getNoHandphone());
            aktorEntity.setLevelPrevilage(request.getLevelPrevilage());
            aktorEntity.setCreateDate(timeDo.format(new Date()));
            aktorEntity.setVersion((long)1);
            aktorEntity.setStatus(AktorConstant.AKTORACTIVE);
            repo.getAktorRepository().save(aktorEntity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void UpdateAktor(AktorRequest request) throws Exception {
        FieldNullChecker(request);
        try {
            AktorEntity aktorEntity = getAktorById(request.getId());
            aktorEntity.setAlamatRumah(request.getAlamatRumah());
            aktorEntity.setEmailActor(request.getEmailActor());
            aktorEntity.setJenisKelamin(request.getJenisKelamin());
            aktorEntity.setNamaDepan(request.getNamaDepan());
            aktorEntity.setNamaBelakang(request.getNamaBelakang());
            aktorEntity.setUsername(request.getUsername());
            aktorEntity.setPassword(request.getPassword());
            aktorEntity.setNoHandphone(request.getNoHandphone());
            aktorEntity.setLevelPrevilage(request.getLevelPrevilage());
            aktorEntity.setUpdateDate(timeDo.format(new Date()));
            aktorEntity.setVersion(aktorEntity.getVersion()+1);
            repo.getAktorRepository().save(aktorEntity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void deleteAktorById(UUID id) {
        repo.getAktorRepository().deleteById(id);
    }

    @Override
    public void deleteAktorStatById(UUID id) throws Exception {
        try {
            AktorEntity aktorEntity = getAktorById(id);
            aktorEntity.setUpdateDate(timeDo.format(new Date()));
            aktorEntity.setVersion(aktorEntity.getVersion()+1);
            aktorEntity.setStatus(AktorConstant.AKTORDISABLE);
            repo.getAktorRepository().save(aktorEntity);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<AktorEntity> getAktorStatActive() {
        List<AktorEntity> ael = new ArrayList<>();
        repo.getAktorRepository().findAllByStatus(AktorConstant.AKTORACTIVE).forEach(ael::add);
        return ael;
    }

    @Override
    public List<AktorEntity> getAktorStatDisable() {
        List<AktorEntity> ael = new ArrayList<>();
        repo.getAktorRepository().findAllByStatus(AktorConstant.AKTORDISABLE).forEach(ael::add);
        return ael;
    }

    @Override
    public void updateAktorStatActive(UUID id) throws Exception {
        if(repo.getAktorRepository().findByIdAndStatus(id,AktorConstant.AKTORDISABLE)!=null){
            try {
                AktorEntity aktorEntity = getAktorById(id);
                aktorEntity.setUpdateDate(timeDo.format(new Date()));
                aktorEntity.setVersion(aktorEntity.getVersion()+1);
                aktorEntity.setStatus(AktorConstant.AKTORACTIVE);
                repo.getAktorRepository().save(aktorEntity);
            }catch (Exception e){
                throw new Exception(e.getMessage());
            }
        }else {
            throw new Exception("");
        }
    }

    private void FieldNullChecker(AktorRequest request) throws Exception{
        if (request.getAlamatRumah().isEmpty()|| request.getAlamatRumah()==null){

        }else if(request.getEmailActor().isEmpty()||request.getEmailActor()==null){

        }else if (request.getJenisKelamin().isEmpty()||request.getJenisKelamin()==null){

        }else if (request.getNamaDepan().isEmpty()||request.getNamaDepan()==null){

        }else if(request.getNamaBelakang().isEmpty()||request.getNamaBelakang()==null){

        }else if(request.getNoHandphone().isEmpty()||request.getNoHandphone()==null){

        }else if (request.getUsername().isEmpty()||request.getUsername()==null){

        }else if (request.getPassword().isEmpty()||request.getPassword()==null){

        }

    }
    private void isExisting(AktorRequest request)throws Exception{
        if(repo.getAktorRepository().findByUsername(request.getUsername())!=null){

        }else if(repo.getAktorRepository().findByEmailActor(request.getEmailActor())!=null){

        }
    }
}
