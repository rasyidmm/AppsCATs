package com.catdemo.demo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

@Entity
@Cacheable
public class SoalKelompokEntity extends Additional{
    private String namaSoalKelompok;

    public String getNamaSoalKelompok() {
        return namaSoalKelompok;
    }

    public void setNamaSoalKelompok(String namaSoalKelompok) {
        this.namaSoalKelompok = namaSoalKelompok;
    }
}
