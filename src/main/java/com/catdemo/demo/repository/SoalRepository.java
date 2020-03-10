package com.catdemo.demo.repository;

import com.catdemo.demo.entity.SoalEntity;
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
    List<SoalEntity>findAllByStatusAndSoalKelompokEntity(String status,UUID idske);

    @Query(value = "select * from soal_entity se join ujian_soal_entity use on se.id = use.ujian_entity_id join ujian_entity ue on use.ujian_entity_id =ue.id where ue.nama_ujian =:namaUjian ",nativeQuery = true)
    List<SoalEntity>findAllByNamaUjian(String namaUjian);
    //untuk mendapkan Soal dengan


}
