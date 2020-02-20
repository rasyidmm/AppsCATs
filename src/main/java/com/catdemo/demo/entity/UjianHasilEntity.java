package com.catdemo.demo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@Cacheable
public class UjianHasilEntity extends Additional{
    @OneToOne
    private UjianPenilaianEntity ujianPenilaianEntity;
    private Long Hasil;

    public UjianPenilaianEntity getUjianPenilaianEntity() {
        return ujianPenilaianEntity;
    }

    public void setUjianPenilaianEntity(UjianPenilaianEntity ujianPenilaianEntity) {
        this.ujianPenilaianEntity = ujianPenilaianEntity;
    }

    public Long getHasil() {
        return Hasil;
    }

    public void setHasil(Long hasil) {
        Hasil = hasil;
    }
}
