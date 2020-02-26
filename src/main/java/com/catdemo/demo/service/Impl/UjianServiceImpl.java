package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.UjianEntity;
import com.catdemo.demo.payload.request.UjianRequest;
import com.catdemo.demo.service.UjianService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UjianServiceImpl implements UjianService {
    @Override
    public List<UjianEntity> getAllUjian() {
        return null;
    }

    @Override
    public UjianEntity getUjianById(UUID id) {
        return null;
    }

    @Override
    public void SaveUjian(UjianRequest request) throws Exception {

    }

    @Override
    public void UpdateUjian(UjianRequest request) throws Exception {

    }

    @Override
    public void deleteUjianById(UUID id) {

    }

    @Override
    public void deleteUjianStatById(UUID id) throws Exception {

    }

    @Override
    public List<UjianEntity> getUjianStatActive() {
        return null;
    }

    @Override
    public List<UjianEntity> getUjianStatDisable() {
        return null;
    }

    @Override
    public void updateUjianStatActive(UUID id) throws Exception {

    }
}
