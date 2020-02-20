package com.catdemo.demo.repository;

import com.catdemo.demo.entity.SoalJawabanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface SoalJawabanRepository extends JpaRepository<SoalJawabanEntity,UUID> {
}
