package com.catdemo.demo.repository;

import com.catdemo.demo.entity.SoalEntity;
import jdk.jfr.Unsigned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface SoalRepository extends JpaRepository<SoalEntity, UUID> {
    SoalEntity findBySoal(String namaSoal);
    List<SoalEntity>findAllByStatus(String Status);
    SoalEntity findByIdAndStatus(UUID id,String Status);
    @Query(value = "select* from soal_entity se where se.soal_kelompok_entity_id =:idske and se.status = 'ACTIVE'",nativeQuery = true)
    List<SoalEntity>findAllByStatusAndSoalKelompokEntity(UUID idske);
    @Query(value = "select * from soal_entity se join ujian_soal_entity use on se.id = use.ujian_entity_id join ujian_entity ue on use.ujian_entity_id =ue.id where ue.nama_ujian =:namaUjian ",nativeQuery = true)
    List<SoalEntity>findAllByNamaUjian(String namaUjian);
    @Query(value = "select * from soal_entity se join ujian_soal_entity use ON se.id =use.soal_entity_id where use.ujian_entity_id =:idujin ",nativeQuery = true)
    List<SoalEntity>findAllByUjianId(UUID idujin);
    @Query(value = "select *,ue.nama_ujian ,ue.id AS idUjian from soal_entity se join ujian_soal_entity use on se.id=use.soal_entity_id join ujian_entity ue on ue.id =use.ujian_entity_id where ue.nama_ujian =:namaUjian",nativeQuery = true)
    List<SoalEntity>findAllSoalByNamaUjial(String namaUjian);


}
