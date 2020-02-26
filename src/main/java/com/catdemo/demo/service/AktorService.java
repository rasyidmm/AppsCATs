package com.catdemo.demo.service;

import com.catdemo.demo.entity.AktorEntity;
import com.catdemo.demo.payload.request.AktorRequest;

import java.util.List;
import java.util.UUID;

public interface AktorService {
    public List<AktorEntity> getAllAktor() ;
    public AktorEntity getAktorById(UUID id) ;
    public void SaveAktor(AktorRequest request) throws Exception;
    public void UpdateAktor(AktorRequest request)throws Exception;
    public void deleteAktorById(UUID id);
    public void deleteAktorStatById(UUID id) throws Exception;
    public List<AktorEntity>  getAktorStatActive();
    public List<AktorEntity>  getAktorStatDisable();
    public void updateAktorStatActive(UUID id)throws Exception ;
}
