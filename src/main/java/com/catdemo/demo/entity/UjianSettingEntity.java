package com.catdemo.demo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

@Entity
@Cacheable
public class UjianSettingEntity extends Additional{
    private Long TWK;
    private Long TIU;
    private Long TKP;
    private Long DurasiUjian;

    public Long getTWK() {
        return TWK;
    }

    public void setTWK(Long TWK) {
        this.TWK = TWK;
    }

    public Long getTIU() {
        return TIU;
    }

    public void setTIU(Long TIU) {
        this.TIU = TIU;
    }

    public Long getTKP() {
        return TKP;
    }

    public void setTKP(Long TKP) {
        this.TKP = TKP;
    }

    public Long getDurasiUjian() {
        return DurasiUjian;
    }

    public void setDurasiUjian(Long durasiUjian) {
        DurasiUjian = durasiUjian;
    }
}
