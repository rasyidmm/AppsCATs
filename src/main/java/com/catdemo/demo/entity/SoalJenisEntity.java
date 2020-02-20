package com.catdemo.demo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

@Entity
@Cacheable
public class SoalJenisEntity extends Additional{
    private String namaSoalJenis;

    public String getNamaSoalJenis() {
        return namaSoalJenis;
    }

    public void setNamaSoalJenis(String namaSoalJenis) {
        this.namaSoalJenis = namaSoalJenis;
    }
}
