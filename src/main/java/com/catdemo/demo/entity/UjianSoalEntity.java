package com.catdemo.demo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Entity
@Cacheable
public class UjianSoalEntity extends Additional {
    @ManyToOne
    private UjianEntity ujianEntity;
    @ManyToOne
    private SoalEntity soalEntity;

    public UjianEntity getUjianEntity() {
        return ujianEntity;
    }

    public void setUjianEntity(UjianEntity ujianEntity) {
        this.ujianEntity = ujianEntity;
    }

    public SoalEntity getSoalEntity() {
        return soalEntity;
    }

    public void setSoalEntity(SoalEntity soalEntity) {
        this.soalEntity = soalEntity;
    }
}