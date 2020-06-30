package com.catdemo.demo.entity;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Cacheable
public class AktorJawabanEntity extends Additional{
    @ManyToOne
    private AktorEntity aktorEntity;
    @ManyToOne
    private SoalEntity soalEntity;
    @ManyToOne
    private SoalJawabanEntity soalJawabanEntity;
    @ManyToOne
    private UjianEntity ujianEntity;
    Long Skor;

    public Long getSkor() {
        return Skor;
    }

    public void setSkor(Long skor) {
        Skor = skor;
    }

    public AktorEntity getAktorEntity() {
        return aktorEntity;
    }

    public void setAktorEntity(AktorEntity aktorEntity) {
        this.aktorEntity = aktorEntity;
    }

    public SoalEntity getSoalEntity() {
        return soalEntity;
    }

    public void setSoalEntity(SoalEntity soalEntity) {
        this.soalEntity = soalEntity;
    }

    public SoalJawabanEntity getSoalJawabanEntity() {
        return soalJawabanEntity;
    }

    public void setSoalJawabanEntity(SoalJawabanEntity soalJawabanEntity) {
        this.soalJawabanEntity = soalJawabanEntity;
    }

    public UjianEntity getUjianEntity() {
        return ujianEntity;
    }

    public void setUjianEntity(UjianEntity ujianEntity) {
        this.ujianEntity = ujianEntity;
    }
}
