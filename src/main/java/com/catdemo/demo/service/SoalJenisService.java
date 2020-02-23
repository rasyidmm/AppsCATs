package com.catdemo.demo.service;

import com.catdemo.demo.entity.SoalJenisEntity;
import com.catdemo.demo.payload.request.SoalJenisRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface SoalJenisService {
    public List<SoalJenisEntity> getAllSoalJenis() ;
    public SoalJenisEntity getSoalJenisById(UUID id) ;
    public SoalJenisEntity getSoalJenisByName(String nameSoalJenis);
    public void SaveSoalJenis(SoalJenisRequest request) throws Exception;
    public void UpdateSoalJenis(SoalJenisRequest request)throws Exception;
    public void deleteSoalJenisById(UUID id);
    public void deleteSoalJenisStatById(UUID id);
    public List<SoalJenisEntity>  getSoaljenisStatActive();
    public List<SoalJenisEntity>  getSoaljenisStatDisable();
    public void updateSoalJenisStatActive(UUID id)throws Exception ;


}
