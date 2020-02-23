package com.catdemo.demo.service;

import com.catdemo.demo.entity.SoalKelompokEntity;
import com.catdemo.demo.payload.request.SoalKelompokRequest;

import java.util.List;
import java.util.UUID;

public interface SoalKelompokService {
    public List<SoalKelompokEntity> getAllSoalKelompok() ;
    public SoalKelompokEntity getSoalKelompokById(UUID id) ;
    public SoalKelompokEntity getSoalKelompokByName(String nameSoalKelompok);
    public void SaveSoalKelompok(SoalKelompokRequest request) throws Exception;
    public void UpdateSoalKelompok(SoalKelompokRequest request)throws Exception;
    public void deleteSoalKelompokById(UUID id);
    public void deleteSoalKelompokStatById(UUID id) throws Exception;
    public List<SoalKelompokEntity>  getSoalKelompokStatActive();
    public List<SoalKelompokEntity>  getSoalKelompokStatDisable();
    public void updateSoalKelompokStatActive(UUID id)throws Exception ;
}
