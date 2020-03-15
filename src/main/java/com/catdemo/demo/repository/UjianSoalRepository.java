package com.catdemo.demo.repository;

import com.catdemo.demo.entity.UjianSoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UjianSoalRepository extends JpaRepository<UjianSoalEntity, UUID> {

}
