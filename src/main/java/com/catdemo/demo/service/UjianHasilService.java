package com.catdemo.demo.service;

import com.catdemo.demo.entity.UjianHasilEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface UjianHasilService {
    public UjianHasilEntity getHasilUjianByIdUjian(UUID id);
}
