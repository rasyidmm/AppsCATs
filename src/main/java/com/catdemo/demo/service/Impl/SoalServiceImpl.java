package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.SoalEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.payload.request.SoalRequest;
import com.catdemo.demo.service.SoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SoalServiceImpl implements SoalService {
    @Autowired
    RepositoryFac repo;
    private SimpleDateFormat timeDo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    @Override
    public List<SoalEntity> getAllSoal() {
        List<SoalEntity> sel = new ArrayList<>();
        repo.getSoalRepository().findAll().forEach(sel::add);
        return sel;
    }

    @Override
    public SoalEntity getSoalById(UUID id) {
        SoalEntity se = repo.getSoalRepository().findById(id).get();
        return se;
    }

    @Override
    public void SaveSoal(SoalRequest request) throws Exception {
        FieldNullChecker(request);
        SameNameChacker(request);
        try {
            SoalEntity se = new SoalEntity();
            se.setSoalJenisEntity(repo.getSoalJenisRepository().findById(request.getIdSoalJenis()).get());
            se.setSoalKelompokEntity(repo.getSoalKelompokRepository().findById(request.getIdSoalKelompok()).get());
            se.setSoal(request.getSoal());
            se.setFlagSoal(request.getFlagSoal());
            se.setLinkImage("");
            se.setVersion((long) 1);
            se.setCreateDate(timeDo.format(new Date()));
            se.setStatus("");
            repo.getSoalRepository().save(se);
        }catch (Exception e){
            throw new Exception("");
        }
    }

    @Override
    public void UpdateSoal(SoalRequest request) throws Exception {
        FieldNullChecker(request);
        SameNameChacker(request);
        try {
            SoalEntity se = getSoalById(request.getId());
            se.setSoalJenisEntity(repo.getSoalJenisRepository().findById(request.getIdSoalJenis()).get());
            se.setSoalKelompokEntity(repo.getSoalKelompokRepository().findById(request.getIdSoalKelompok()).get());
            se.setSoal(request.getSoal());
            se.setFlagSoal(request.getFlagSoal());
            se.setLinkImage("");
            se.setVersion(se.getVersion()+ 1);
            se.setUpdateDate(timeDo.format(new Date()));
            repo.getSoalRepository().save(se);
        }catch (Exception e){
            throw new Exception("");
        }
    }

    @Override
    public void deleteSoalById(UUID id) {

    }

    @Override
    public void deleteSoalStatById(UUID id) throws Exception {

    }

    @Override
    public List<SoalEntity> getSoalStatActive() {
        return null;
    }

    @Override
    public List<SoalEntity> getSoalStatDisable() {
        return null;
    }

    @Override
    public void updateSoalStatActive(UUID id) throws Exception {

    }

    private void FieldNullChecker(SoalRequest request) throws Exception{
        if (request.getSoal().isEmpty()||request.getSoal()==null||request.getSoal()==" "){
            throw new Exception("");
        }else if (request.getIdSoalJenis() == null){
            throw new Exception("");
        }else if (request.getIdSoalKelompok() == null){
            throw new Exception("");
        }
    }

    private void SameNameChacker(SoalRequest request)throws Exception{
        if(repo.getSoalRepository().findBySoal(request.getSoal())!=null){
            throw new Exception("");
        }
    }
}
