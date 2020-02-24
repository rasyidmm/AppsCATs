package com.catdemo.demo.repository;

import com.catdemo.demo.entity.SoalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SoalRepository extends JpaRepository<SoalEntity, UUID> {
    SoalEntity findBySoal(String namaSoal);
    List<SoalEntity>findAllByStatus(String Status);
    SoalEntity findByIdAndStatus(UUID id,String Status);

}
