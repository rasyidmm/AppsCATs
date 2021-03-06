package com.catdemo.demo.repository;

import com.catdemo.demo.entity.SoalJenisEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SoalJenisRepository extends JpaRepository<SoalJenisEntity, UUID> {
    SoalJenisEntity findByNamaSoalJenis(String NamaSoalJenis);
    List<SoalJenisEntity>findAllByStatus(String Status);
    SoalJenisEntity findByIdAndStatus(UUID id,String Status);
}
