package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.SoalJenisEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.payload.request.SoalJenisRequest;
import com.catdemo.demo.service.SoalJenisService;
import com.catdemo.demo.util.constants.SoalJenisConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class SoalJenisServiceImpl implements SoalJenisService {
    @Autowired
    RepositoryFac repo;
    private SimpleDateFormat timeDo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    @Override
    public List<SoalJenisEntity> getAllSoalJenis(){
        List<SoalJenisEntity>sjel =  new ArrayList<>();
        repo.getSoalJenisRepository().findAll().forEach(sjel::add);
        return  sjel;
    }

    @Override
    public SoalJenisEntity getSoalJenisById(UUID id) {
        SoalJenisEntity sje =  repo.getSoalJenisRepository().findById(id).get();
        return sje;
    }

    @Override
    public SoalJenisEntity getSoalJenisByName(String nameSoalJenis) {
        SoalJenisEntity sjen = repo.getSoalJenisRepository().findByNamaSoalJenis(nameSoalJenis);
        return  sjen;
    }

    @Override
    public void SaveSoalJenis(SoalJenisRequest request) throws Exception{
        FieldChecker(request);
        IsExisting(request);
        SoalJenisEntity sje = new SoalJenisEntity();
        sje.setCreateDate(timeDo.format(new Date()));
        sje.setVersion((long) 1);
        sje.setNamaSoalJenis(request.getNamaSoalJenis());
        sje.setStatus(SoalJenisConstant.SOALJENISACTIVE);
        repo.getSoalJenisRepository().save(sje);
    }

    @Override
    public void UpdateSoalJenis(SoalJenisRequest request) throws Exception {
        FieldChecker(request);
        SoalJenisEntity sje = getSoalJenisById(request.getId());
        sje.setUpdateDate(timeDo.format(new Date()));
        sje.setVersion(sje.getVersion()+1);
        sje.setNamaSoalJenis(request.getNamaSoalJenis());
        repo.getSoalJenisRepository().save(sje);
    }

    @Override
    public void deleteSoalJenisById(UUID id) {
        repo.getSoalJenisRepository().deleteById(id);
    }

    @Override
    public void deleteSoalJenisStatById(UUID id) {
        SoalJenisEntity sje = getSoalJenisById(id);
        sje.setUpdateDate(timeDo.format(new Date()));
        sje.setStatus(SoalJenisConstant.SOALJENISDISABLE);
        repo.getSoalJenisRepository().save(sje);
    }

    @Override
    public List<SoalJenisEntity>  getSoaljenisStatActive(String Active) {
        List<SoalJenisEntity>sjels =  new ArrayList<>();
        repo.getSoalJenisRepository().findByStatus(SoalJenisConstant.SOALJENISACTIVE).forEach(sjels::add);
        return sjels;
    }

    @Override
    public List<SoalJenisEntity>  getSoaljenisStatDisable(String Disable) {
        List<SoalJenisEntity>sjels =  new ArrayList<>();
        repo.getSoalJenisRepository().findByStatus(SoalJenisConstant.SOALJENISDISABLE).forEach(sjels::add);
        return sjels;
    }

    @Override
    public void updateSoalJenisStatActive(UUID id, String Disable) throws Exception {
        if(repo.getSoalJenisRepository().findByIdAndStatus(id,SoalJenisConstant.SOALJENISDISABLE)!=null){
            SoalJenisEntity soalJenisEntity =repo.getSoalJenisRepository().findByIdAndStatus(id,SoalJenisConstant.SOALJENISDISABLE);
            soalJenisEntity.setStatus(SoalJenisConstant.SOALJENISACTIVE);
            repo.getSoalJenisRepository().save(soalJenisEntity);
        }else {
            throw new Exception(SoalJenisConstant.SOALJENISDISABLENOTABLE);
        }

    }

    //Checker
    private void FieldChecker(SoalJenisRequest request) throws Exception {
       if(request.getNamaSoalJenis().isEmpty() || request.getNamaSoalJenis()==" "|| request.getNamaSoalJenis()== null){
           throw new Exception(SoalJenisConstant.SOALJENISNAMENULL);
       }

    }

    private void IsExisting(SoalJenisRequest request) throws Exception {
        if(getSoalJenisByName(request.getNamaSoalJenis())!=null){
            throw  new Exception(SoalJenisConstant.SOALJENISNAMAEXISTING);
        }
    }
}
