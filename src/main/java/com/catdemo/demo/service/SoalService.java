package com.catdemo.demo.service;

import com.catdemo.demo.entity.SoalEntity;
import com.catdemo.demo.payload.request.SoalRequest;

import java.util.List;
import java.util.UUID;

public interface SoalService {
    public List<SoalEntity> getAllSoal() ;
    public SoalEntity getSoalById(UUID id) ;
    public void SaveSoal(SoalRequest request) throws Exception;
    public void UpdateSoal(SoalRequest request)throws Exception;
    public void deleteSoalById(UUID id);
    public void deleteSoalStatById(UUID id) throws Exception;
    public List<SoalEntity>  getSoalStatActive();
    public List<SoalEntity>  getSoalStatDisable();
    public void updateSoalStatActive(UUID id)throws Exception ;
    public SoalEntity getRandom();
    public List<SoalEntity> getAllSoalTWKActive() ;
    public List<SoalEntity> getAllSoalTIUActive() ;
    public List<SoalEntity> getAllSoalTKPActive() ;
}
