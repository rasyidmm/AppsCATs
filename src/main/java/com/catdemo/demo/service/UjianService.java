package com.catdemo.demo.service;

import com.catdemo.demo.entity.UjianEntity;
import com.catdemo.demo.payload.request.UjianRequest;

import java.util.List;
import java.util.UUID;

public interface UjianService {
    public List<UjianEntity> getAllUjian() ;
    public UjianEntity getUjianById(UUID id) ;
    public void SaveUjian(UjianRequest request) throws Exception;
    public void UpdateUjian(UjianRequest request)throws Exception;
    public void deleteUjianById(UUID id);
    public void deleteUjianStatById(UUID id) throws Exception;
    public List<UjianEntity>  getUjianStatActive();
    public List<UjianEntity>  getUjianStatDisable();
    public void updateUjianStatActive(UUID id)throws Exception ;
    public UjianEntity getUjianByNameUjian(String namaUjian);

}
