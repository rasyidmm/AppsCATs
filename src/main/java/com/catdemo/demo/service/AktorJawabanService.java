package com.catdemo.demo.service;

import com.catdemo.demo.entity.AktorJawabanEntity;
import com.catdemo.demo.payload.request.AktorJawabanRequest;

import java.util.List;
import java.util.UUID;

public interface AktorJawabanService {
    public AktorJawabanEntity getAktorJawabanById(UUID id) ;
    public void SaveAktorJawaban(AktorJawabanRequest request) throws Exception;
    public void UpdateAktorJawaban(AktorJawabanRequest request)throws Exception;
    public void deleteAktorJawabanById(UUID id);
    public void deleteAktorJawabanStatById(UUID id) throws Exception;
    public List<AktorJawabanEntity>  getAktorJawabanStatActive();
    public List<AktorJawabanEntity>  getAktorJawabanStatDisable();
    public void updateAktorJawabanStatActive(UUID id)throws Exception ;
}
