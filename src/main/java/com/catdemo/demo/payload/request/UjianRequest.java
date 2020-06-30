package com.catdemo.demo.payload.request;

import java.util.UUID;

public class UjianRequest {
    private UUID id;
    String namaUjian;
    private UUID idAktorEntity;
    private Boolean twk;
    private Boolean tiu;
    private Boolean tkp;

    public String getNamaUjian() {
        return namaUjian;
    }

    public void setNamaUjian(String namaUjian) {
        this.namaUjian = namaUjian;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    public UUID getIdAktorEntity() {
        return idAktorEntity;
    }

    public void setIdAktorEntity(UUID idAktorEntity) {
        this.idAktorEntity = idAktorEntity;
    }

    public Boolean getTwk() {
        return twk;
    }

    public void setTwk(Boolean twk) {
        this.twk = twk;
    }

    public Boolean getTiu() {
        return tiu;
    }

    public void setTiu(Boolean tiu) {
        this.tiu = tiu;
    }

    public Boolean getTkp() {
        return tkp;
    }

    public void setTkp(Boolean tkp) {
        this.tkp = tkp;
    }
}
