package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.SoalJenisEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.payload.request.SoalJenisRequest;
import com.catdemo.demo.service.SoalJenisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class SoalJenisServiceImpl implements SoalJenisService {
    @Autowired
    RepositoryFac repo;
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
        IsValidate(request);
        IsSameName(request);
        SoalJenisEntity sje = new SoalJenisEntity();
        sje.setNamaSoalJenis(request.getNamaSoalJenis());
        repo.getSoalJenisRepository().save(sje);
    }

    @Override
    public void UpdateSoalJenis(SoalJenisRequest request) throws Exception {
        IsValidate(request);
        SoalJenisEntity sje = getSoalJenisById(request.getId());
        sje.setId(request.getId());
        sje.setNamaSoalJenis(request.getNamaSoalJenis());
        repo.getSoalJenisRepository().save(sje);
    }

    @Override
    public void deleteSoalJenisById(UUID id) {
        repo.getSoalJenisRepository().deleteById(id);
    }
    //Checker
    private void IsValidate(SoalJenisRequest request) throws Exception {
       if(request.getNamaSoalJenis().isEmpty() || request.getNamaSoalJenis()==" "|| request.getNamaSoalJenis()== null){
           throw new Exception("Nama Soal Jenis Is Empty");
       }

    }

    private void IsSameName(SoalJenisRequest request) throws Exception {
        if(getSoalJenisByName(request.getNamaSoalJenis())!=null){
            throw  new Exception("Soal Jenis Sudah ada");
        }
    }
}
