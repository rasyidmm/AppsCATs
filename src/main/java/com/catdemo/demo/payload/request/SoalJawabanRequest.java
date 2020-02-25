package com.catdemo.demo.payload.request;

import java.util.UUID;

public class SoalJawabanRequest {
    private UUID id;
    private String soalJawaban;
    private String linkimageJawaban;
    private Long skor;
    private UUID idSoalEntity;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSoalJawaban() {
        return soalJawaban;
    }

    public void setSoalJawaban(String soalJawaban) {
        this.soalJawaban = soalJawaban;
    }

    public String getLinkimageJawaban() {
        return linkimageJawaban;
    }

    public void setLinkimageJawaban(String linkimageJawaban) {
        this.linkimageJawaban = linkimageJawaban;
    }

    public Long getSkor() {
        return skor;
    }

    public void setSkor(Long skor) {
        this.skor = skor;
    }

    public UUID getIdSoalEntity() {
        return idSoalEntity;
    }

    public void setIdSoalEntity(UUID idSoalEntity) {
        this.idSoalEntity = idSoalEntity;
    }
}
