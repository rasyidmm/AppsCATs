package com.catdemo.demo.repository;

import com.catdemo.demo.entity.AktorJawabanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AktorJawabanRepository extends JpaRepository<AktorJawabanEntity,UUID> {
    List<AktorJawabanEntity> findAllByUjianEntityId(UUID id);
}
