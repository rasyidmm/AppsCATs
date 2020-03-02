package com.catdemo.demo.repository;

import com.catdemo.demo.entity.UjianSettingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UjianSettingRepository extends JpaRepository<UjianSettingEntity, UUID> {
    List<UjianSettingEntity> findAllByStatus(String Status);
    UjianSettingEntity findByIdAndStatus(UUID id,String Status);
    UjianSettingEntity findByNamaSetting(String KelompokSoal);
}
