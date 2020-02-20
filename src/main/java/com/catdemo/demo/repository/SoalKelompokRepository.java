package com.catdemo.demo.repository;

import com.catdemo.demo.entity.SoalKelompokEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SoalKelompokRepository extends JpaRepository<SoalKelompokEntity, UUID> {
}
