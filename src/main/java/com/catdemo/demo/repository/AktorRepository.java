package com.catdemo.demo.repository;

import com.catdemo.demo.entity.AktorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AktorRepository extends JpaRepository<AktorEntity, UUID> {
    AktorEntity findByUsername(String username);
    AktorEntity findByEmailActor(String email);
    AktorEntity findByIdAndStatus(UUID id,String Status);
    List<AktorEntity>findAllByStatus(String Status);
}
