package com.catdemo.demo.repository;

import com.catdemo.demo.entity.SoalEntity;
import com.catdemo.demo.entity.SoalJawabanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SoalJawabanRepository extends JpaRepository<SoalJawabanEntity,UUID> {
    SoalJawabanEntity findBysoalJawaban(String NamaSoalJenis);
    List<SoalJawabanEntity>findAllByStatus(String Status);
    SoalJawabanEntity findByIdAndStatus(UUID id,String Status);
    List<SoalJawabanEntity>findAllBySoalEntityId(UUID id);
}
