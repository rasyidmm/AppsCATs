package com.catdemo.demo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Cacheable
public class SoalJawabanEntity extends Additional{
    private String soalJawaban;
    private String linkimageJawaban;
    private Long Skor;
    @ManyToOne
    private SoalEntity soalEntity;

    public String getSoalJawaban() {
        return soalJawaban;
    }

    public void setSoalJawaban(String soalJawaban) {
        this.soalJawaban = soalJawaban;
    }

    public String getLinkimageJawaban() {
        return linkimageJawaban;
    }

    public void setLinkimageJawaban(String linkimageJawaban) {
        this.linkimageJawaban = linkimageJawaban;
    }

    public Long getSkor() {
        return Skor;
    }

    public void setSkor(Long skor) {
        Skor = skor;
    }

    public SoalEntity getSoalEntity() {
        return soalEntity;
    }

    public void setSoalEntity(SoalEntity soalEntity) {
        this.soalEntity = soalEntity;
    }
}
