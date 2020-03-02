package com.catdemo.demo.service;

import com.catdemo.demo.entity.UjianSettingEntity;
import com.catdemo.demo.payload.request.UjianSettingRequest;

import java.util.List;
import java.util.UUID;

public interface UjianSettingService {
    public List<UjianSettingEntity> getAllUjianSetting() ;
    public UjianSettingEntity getUjianSettingById(UUID id) ;
    public void SaveUjianSetting(UjianSettingRequest request) throws Exception;
    public void UpdateUjianSetting(UjianSettingRequest request)throws Exception;
    public void deleteUjianSettingById(UUID id);
    public void deleteUjianSettingStatById(UUID id) throws Exception;
    public List<UjianSettingEntity>  getUjianSettingStatActive();
    public List<UjianSettingEntity>  getUjianSettingStatDisable();
    public void updateUjianSettingStatActive(UUID id)throws Exception ;
    public UjianSettingEntity getValueTwk();
    public UjianSettingEntity getValueTIU();
    public UjianSettingEntity getValueTKP();
    public UjianSettingEntity getValueDurasi();

}
