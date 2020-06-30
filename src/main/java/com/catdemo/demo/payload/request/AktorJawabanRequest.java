package com.catdemo.demo.payload.request;

import java.util.UUID;

public class AktorJawabanRequest {
    private UUID id;
    private UUID idAktorEntity;
    private UUID idSoalEntity;
    private UUID idSoalJawabanEntity;
    private UUID idUjianEntity;

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

    public UUID getIdSoalEntity() {
        return idSoalEntity;
    }

    public void setIdSoalEntity(UUID idSoalEntity) {
        this.idSoalEntity = idSoalEntity;
    }

    public UUID getIdSoalJawabanEntity() {
        return idSoalJawabanEntity;
    }

    public void setIdSoalJawabanEntity(UUID idSoalJawabanEntity) {
        this.idSoalJawabanEntity = idSoalJawabanEntity;
    }

    public UUID getIdUjianEntity() {
        return idUjianEntity;
    }

    public void setIdUjianEntity(UUID idUjianEntity) {
        this.idUjianEntity = idUjianEntity;
    }
}
