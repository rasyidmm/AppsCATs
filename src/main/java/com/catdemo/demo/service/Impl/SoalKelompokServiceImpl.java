package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.SoalKelompokEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.payload.request.SoalKelompokRequest;
import com.catdemo.demo.service.SoalKelompokService;
import com.catdemo.demo.util.constants.SoalJenisConstant;
import com.catdemo.demo.util.constants.SoalKelompokConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SoalKelompokServiceImpl implements SoalKelompokService {
    @Autowired
    RepositoryFac repo;
    private SimpleDateFormat timeDo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    @Override
    public List<SoalKelompokEntity> getAllSoalKelompok() {
        List<SoalKelompokEntity>sjel =  new ArrayList<>();
        repo.getSoalKelompokRepository().findAll().forEach(sjel::add);
        return  sjel;
    }

    @Override
    public SoalKelompokEntity getSoalKelompokById(UUID id) {
        SoalKelompokEntity sje = repo.getSoalKelompokRepository().findById(id).get();
        return sje;
    }

    @Override
    public SoalKelompokEntity getSoalKelompokByName(String nameSoalKelompok) {
        SoalKelompokEntity sje = repo.getSoalKelompokRepository().findByNamaSoalKelompok(nameSoalKelompok);
        return sje;
    }

    @Override
    public void SaveSoalKelompok(SoalKelompokRequest request) throws Exception {
        FieldNullChecker(request);
        SameName(request);
        try {
            SoalKelompokEntity ske = new SoalKelompokEntity();
            ske.setNamaSoalKelompok(request.getNamaSoalKelompok());
            ske.setCreateDate(timeDo.format(new Date()));
            ske.setStatus(SoalKelompokConstant.SOALKELOMPOKSTATACTIVE);
            ske.setVersion((long) 1);
            repo.getSoalKelompokRepository().save(ske);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void UpdateSoalKelompok(SoalKelompokRequest request) throws Exception {
        FieldNullChecker(request);
        try {
            SoalKelompokEntity ske = getSoalKelompokById(request.getId());
            ske.setNamaSoalKelompok(request.getNamaSoalKelompok());
            ske.setUpdateDate(timeDo.format(new Date()));
            ske.setVersion(ske.getVersion()+1);
            repo.getSoalKelompokRepository().save(ske);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void deleteSoalKelompokById(UUID id) {
        repo.getSoalKelompokRepository().deleteById(id);

    }

    @Override
    public void deleteSoalKelompokStatById(UUID id) throws Exception{
        try {
            SoalKelompokEntity ske = getSoalKelompokById(id);
            ske.setUpdateDate(timeDo.format(new Date()));
            ske.setStatus(SoalKelompokConstant.SOALKELOMPOKSTATDISABLE);
            repo.getSoalKelompokRepository().save(ske);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }


    }

    @Override
    public List<SoalKelompokEntity> getSoalKelompokStatActive() {
        List<SoalKelompokEntity>sjel =  new ArrayList<>();
        repo.getSoalKelompokRepository().findAllByStatus(SoalKelompokConstant.SOALKELOMPOKSTATACTIVE).forEach(sjel::add);
        return  sjel;
    }

    @Override
    public List<SoalKelompokEntity> getSoalKelompokStatDisable() {
        List<SoalKelompokEntity>sjel =  new ArrayList<>();
        repo.getSoalKelompokRepository().findAllByStatus(SoalKelompokConstant.SOALKELOMPOKSTATDISABLE).forEach(sjel::add);
        return  sjel;

    }

    @Override
    public void updateSoalKelompokStatActive(UUID id) throws Exception {
        if (repo.getSoalKelompokRepository().findByIdAndStatus(id, SoalKelompokConstant.SOALKELOMPOKSTATDISABLE )!=null) {
            try {
                SoalKelompokEntity ske = repo.getSoalKelompokRepository().findByIdAndStatus(id, SoalKelompokConstant.SOALKELOMPOKSTATDISABLE);
                ske.setUpdateDate(timeDo.format(new Date()));
                ske.setStatus(SoalKelompokConstant.SOALKELOMPOKSTATACTIVE);
                repo.getSoalKelompokRepository().save(ske);
            }catch (Exception e){
                throw new Exception(e.getMessage());
            }
        }else {
            throw new Exception(SoalKelompokConstant.SOALKELOMPOKNAMEDISABLENOTABLE);
        }
    }

    //Checker

    private void FieldNullChecker(SoalKelompokRequest request) throws Exception{
        if(request.getNamaSoalKelompok()!=null || request.getNamaSoalKelompok().isEmpty() || request.getNamaSoalKelompok()== "" ){
            throw new Exception(SoalKelompokConstant.SOALKELOMPOKNULL);
        }
    }
    private void SameName(SoalKelompokRequest request) throws Exception{
        if(getSoalKelompokByName(request.getNamaSoalKelompok())!=null){
            throw new Exception(SoalKelompokConstant.SOALKELOMPOKEXISTING);
        }
    }
}
