package com.catdemo.demo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Cacheable
public class UjianHasilEntity extends Additional{
    @OneToOne
    private UjianEntity ujianEntity;
    private Long Hasil;
    @OneToOne
    private AktorEntity aktorEntity;

    public AktorEntity getAktorEntity() {
        return aktorEntity;
    }

    public void setAktorEntity(AktorEntity aktorEntity) {
        this.aktorEntity = aktorEntity;
    }

    public UjianEntity getUjianEntity() {
        return ujianEntity;
    }

    public void setUjianEntity(UjianEntity ujianEntity) {
        this.ujianEntity = ujianEntity;
    }

    public Long getHasil() {
        return Hasil;
    }

    public void setHasil(Long hasil) {
        Hasil = hasil;
    }

}
