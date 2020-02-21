package com.catdemo.demo.payload.request;

import java.util.UUID;

public class SoalJenisRequest {
    private UUID id;
    private String namaSoalJenis;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNamaSoalJenis() {
        return namaSoalJenis;
    }

    public void setNamaSoalJenis(String namaSoalJenis) {
        this.namaSoalJenis = namaSoalJenis;
    }
}
