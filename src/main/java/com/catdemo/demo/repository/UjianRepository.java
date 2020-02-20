package com.catdemo.demo.repository;

import com.catdemo.demo.entity.UjianEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UjianRepository extends JpaRepository<UjianEntity, UUID> {
}
