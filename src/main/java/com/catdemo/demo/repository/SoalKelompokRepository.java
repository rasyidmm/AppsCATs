package com.catdemo.demo.repository;

import com.catdemo.demo.entity.SoalKelompokEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SoalKelompokRepository extends JpaRepository<SoalKelompokEntity, UUID> {
    SoalKelompokEntity findByNamaSoalKelompok(String NamaSoalKelompok);
    List<SoalKelompokEntity>findAllByStatus(String Status);
    SoalKelompokEntity findByIdAndStatus(UUID id,String Status);
}
