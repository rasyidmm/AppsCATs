package com.catdemo.demo.payload.request;

import java.util.UUID;

public class UjianRequest {
    private UUID id;
    private String namaUjian;
    private Long durasiUjian;
    private UUID idSoalEntity;
    private UUID idAktorEntity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNamaUjian() {
        return namaUjian;
    }

    public void setNamaUjian(String namaUjian) {
        this.namaUjian = namaUjian;
    }

    public Long getDurasiUjian() {
        return durasiUjian;
    }

    public void setDurasiUjian(Long durasiUjian) {
        this.durasiUjian = durasiUjian;
    }

    public UUID getIdSoalEntity() {
        return idSoalEntity;
    }

    public void setIdSoalEntity(UUID idSoalEntity) {
        this.idSoalEntity = idSoalEntity;
    }

    public UUID getIdAktorEntity() {
        return idAktorEntity;
    }

    public void setIdAktorEntity(UUID idAktorEntity) {
        this.idAktorEntity = idAktorEntity;
    }
}
