package com.catdemo.demo.repository;

import com.catdemo.demo.entity.UjianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UjianRepository extends JpaRepository<UjianEntity, UUID> {
    UjianEntity findByNamaUjian(String namaUjian);
}
