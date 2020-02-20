package com.catdemo.demo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Cacheable
public class SoalEntity extends Additional{
    private String soal;
    private String linkImage;
    private String flagSoal;
    @ManyToOne
    private SoalKelompokEntity soalKelompokEntity;
    @ManyToOne
    private SoalJenisEntity soalJenisEntity;


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

    public SoalKelompokEntity getSoalKelompokEntity() {
        return soalKelompokEntity;
    }

    public void setSoalKelompokEntity(SoalKelompokEntity soalKelompokEntity) {
        this.soalKelompokEntity = soalKelompokEntity;
    }

    public SoalJenisEntity getSoalJenisEntity() {
        return soalJenisEntity;
    }

    public void setSoalJenisEntity(SoalJenisEntity soalJenisEntity) {
        this.soalJenisEntity = soalJenisEntity;
    }
}
