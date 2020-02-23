package com.catdemo.demo.payload.request;

import java.util.UUID;

public class SoalKelompokRequest {
    private UUID id;
    private String namaSoalKelompok;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNamaSoalKelompok() {
        return namaSoalKelompok;
    }

    public void setNamaSoalKelompok(String namaSoalKelompok) {
        this.namaSoalKelompok = namaSoalKelompok;
    }
}
