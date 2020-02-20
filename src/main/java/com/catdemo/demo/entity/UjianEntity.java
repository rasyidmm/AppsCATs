package com.catdemo.demo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Cacheable
public class UjianEntity extends Additional{
    private String namaUjian;
    private Long durasiUjian;
    @ManyToOne
    private SoalEntity soalEntity;

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

    public SoalEntity getSoalEntity() {
        return soalEntity;
    }

    public void setSoalEntity(SoalEntity soalEntity) {
        this.soalEntity = soalEntity;
    }
}
