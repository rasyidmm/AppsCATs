package com.catdemo.demo.service;

import com.catdemo.demo.entity.AktorJawabanEntity;

import java.util.List;
import java.util.UUID;

public interface AktorJawabanService {
    public List<AktorJawabanEntity> getAllJawaban();
    public AktorJawabanEntity getAktorJabawanByid(UUID id);
}
