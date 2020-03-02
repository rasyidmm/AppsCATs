package com.catdemo.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Cacheable
public class UjianEntity extends Additional{
    private String namaUjian;
    private Long durasiUjian;
    @ManyToOne
    private AktorEntity aktorEntity;

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

    public AktorEntity getAktorEntity() {
        return aktorEntity;
    }

    public void setAktorEntity(AktorEntity aktorEntity) {
        this.aktorEntity = aktorEntity;
    }

}
