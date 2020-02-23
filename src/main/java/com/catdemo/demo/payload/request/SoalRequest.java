package com.catdemo.demo.payload.request;

import java.util.UUID;

public class SoalRequest {
    private UUID id;
    private String soal;
    private String linkImage;
    private String flagSoal;
    private UUID idSoalJenis;
    private UUID idSoalKelompok;


    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getLinkImage() {
        return linkImage;
    }

    public void setLinkImage(String linkImage) {
        this.linkImage = linkImage;
    }

    public String getFlagSoal() {
        return flagSoal;
    }

    public void setFlagSoal(String flagSoal) {
        this.flagSoal = flagSoal;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getIdSoalJenis() {
        return idSoalJenis;
    }

    public void setIdSoalJenis(UUID idSoalJenis) {
        this.idSoalJenis = idSoalJenis;
    }

    public UUID getIdSoalKelompok() {
        return idSoalKelompok;
    }

    public void setIdSoalKelompok(UUID idSoalKelompok) {
        this.idSoalKelompok = idSoalKelompok;
    }
}
