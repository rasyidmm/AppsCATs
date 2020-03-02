package com.catdemo.demo.repository;

import com.catdemo.demo.entity.UjianSoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UjianSoalRepository extends JpaRepository<UjianSoalEntity, UUID> {
}
