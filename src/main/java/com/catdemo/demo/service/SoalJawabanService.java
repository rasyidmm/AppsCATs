package com.catdemo.demo.service;

import com.catdemo.demo.entity.SoalJawabanEntity;
import com.catdemo.demo.payload.request.SoalJawabanRequest;

import java.util.List;
import java.util.UUID;

public interface SoalJawabanService {
    public List<SoalJawabanEntity> getAllSoalJawaban() ;
    public SoalJawabanEntity getSoalJawabanById(UUID id) ;
    public void SaveSoalJawaban(SoalJawabanRequest request) throws Exception;
    public void UpdateSoalJawaban(SoalJawabanRequest request)throws Exception;
    public void deleteSoalJawabanById(UUID id);
    public void deleteSoalJawabanStatById(UUID id) throws Exception;
    public List<SoalJawabanEntity>  getSoalJawabanStatActive();
    public List<SoalJawabanEntity>  getSoalJawabanStatDisable();
    public void updateSoalJawabanStatActive(UUID id)throws Exception ;
}
