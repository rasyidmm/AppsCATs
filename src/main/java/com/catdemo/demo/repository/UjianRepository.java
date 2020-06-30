package com.catdemo.demo.repository;

import com.catdemo.demo.entity.UjianEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface UjianRepository extends JpaRepository<UjianEntity, UUID> {
    @Query(value = "select * from ujian_entity ue where ue.nama_ujian =:namaUjian",nativeQuery = true)
    UjianEntity findByNamaUjian(String namaUjian);
    @Query(value = "select * from ujian_entity ue join ujian_soal_entity use on ue.id = use.ujian_entity_id where ue.nama_ujian =:namaUjian and use.soal_entity_id =:idSoal ", nativeQuery = true)
    List<UjianEntity> findAllByUjianAndSoal(String namaUjian, UUID idSoal);
    @Query(value = "select * from ujian_entity ue join ujian_soal_entity use on ue.id =use.ujian_entity_id where ue.id =:idUjian ",nativeQuery = true)
    List<UjianEntity> findByIdJoin(UUID idUjian);
}
