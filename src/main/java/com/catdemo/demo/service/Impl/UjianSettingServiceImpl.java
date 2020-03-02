package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.UjianSettingEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.payload.request.UjianSettingRequest;
import com.catdemo.demo.service.UjianSettingService;
import com.catdemo.demo.util.constants.UjianConstant;
import com.catdemo.demo.util.constants.UjianSettingConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UjianSettingServiceImpl implements UjianSettingService {
    @Autowired
    RepositoryFac repo;
    private SimpleDateFormat timeDo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    @Override
    public List<UjianSettingEntity> getAllUjianSetting() {
        List<UjianSettingEntity> sel = new ArrayList<>();
        repo.getUjianSettingRepository().findAll().forEach(sel::add);
        return sel;
    }

    @Override
    public UjianSettingEntity getUjianSettingById(UUID id) {
        UjianSettingEntity uje = repo.getUjianSettingRepository().findById(id).get();
        return uje;
    }

    @Override
    public void SaveUjianSetting(UjianSettingRequest request) throws Exception {
        try {
            UjianSettingEntity uje =  new UjianSettingEntity();
            uje.setNamaSetting(request.getNamaSetting());
            uje.setValueSetting(request.getValueSetting());
            uje.setCreateDate(timeDo.format(new Date()));
            uje.setStatus(UjianSettingConstant.UJIANSETTINGACTIVE);
            uje.setVersion((long)1);
            repo.getUjianSettingRepository().save(uje);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void UpdateUjianSetting(UjianSettingRequest request) throws Exception {
        try {
            UjianSettingEntity uje =  getUjianSettingById(request.getId());
            uje.setNamaSetting(request.getNamaSetting());
            uje.setValueSetting(request.getValueSetting());
            uje.setUpdateDate(timeDo.format(new Date()));
            uje.setVersion(uje.getVersion()+1);
            repo.getUjianSettingRepository().save(uje);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void deleteUjianSettingById(UUID id) {
        repo.getUjianSettingRepository().deleteById(id);
    }

    @Override
    public void deleteUjianSettingStatById(UUID id) throws Exception {
        try {
            UjianSettingEntity uje =  getUjianSettingById(id);
            uje.setUpdateDate(timeDo.format(new Date()));
            uje.setVersion(uje.getVersion()+1);
            uje.setStatus(UjianSettingConstant.UJIANSETTINGDISABLE);
            repo.getUjianSettingRepository().save(uje);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<UjianSettingEntity> getUjianSettingStatActive() {
        List<UjianSettingEntity> sel = new ArrayList<>();
        repo.getUjianSettingRepository().findAllByStatus(UjianSettingConstant.UJIANSETTINGACTIVE).forEach(sel::add);
        return sel;
    }

    @Override
    public List<UjianSettingEntity> getUjianSettingStatDisable() {
        List<UjianSettingEntity> sel = new ArrayList<>();
        repo.getUjianSettingRepository().findAllByStatus(UjianSettingConstant.UJIANSETTINGDISABLE).forEach(sel::add);
        return sel;
    }

    @Override
    public void updateUjianSettingStatActive(UUID id) throws Exception {
        if (repo.getUjianSettingRepository().findByIdAndStatus(id,UjianSettingConstant.UJIANSETTINGDISABLE)!=null){
            try {
                UjianSettingEntity uje =  getUjianSettingById(id);
                uje.setUpdateDate(timeDo.format(new Date()));
                uje.setVersion(uje.getVersion()+1);
                uje.setStatus(UjianSettingConstant.UJIANSETTINGACTIVE);
                repo.getUjianSettingRepository().save(uje);
            }catch (Exception e){
                throw new Exception(e.getMessage());
            }
        }else {
            throw new Exception(UjianSettingConstant.UJIANSETTINGDISABLENOTFOUND);
        }

    }

    @Override
    public UjianSettingEntity getValueTwk() {
        UjianSettingEntity uje = repo.getUjianSettingRepository().findByNamaSetting(UjianSettingConstant.UJIANSETTINGTWK);
        return uje;
    }

    @Override
    public UjianSettingEntity getValueTIU() {
        UjianSettingEntity uje = repo.getUjianSettingRepository().findByNamaSetting(UjianSettingConstant.UJIANSETTINGTIU);
        return uje;
    }

    @Override
    public UjianSettingEntity getValueTKP() {
        UjianSettingEntity uje = repo.getUjianSettingRepository().findByNamaSetting(UjianSettingConstant.UJIANSETTINGTKP);
        return uje;
    }

    @Override
    public UjianSettingEntity getValueDurasi() {
        return null;
    }


}
