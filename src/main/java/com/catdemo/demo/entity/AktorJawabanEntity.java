package com.catdemo.demo.entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Cacheable
public class AktorJawabanEntity extends Additional{
    @ManyToOne
    private AktorEntity aktorEntity;
    @ManyToMany
    private Set<SoalEntity> soalEntity;
    @ManyToMany
    private Set<SoalJawabanEntity> soalJawabanEntity;
    @OneToMany
    private Set <UjianEntity> ujianEntity;

    public AktorEntity getAktorEntity() {
        return aktorEntity;
    }

    public void setAktorEntity(AktorEntity aktorEntity) {
        this.aktorEntity = aktorEntity;
    }

    public Set<SoalEntity> getSoalEntity() {
        return soalEntity;
    }

    public void setSoalEntity(Set<SoalEntity> soalEntity) {
        this.soalEntity = soalEntity;
    }

    public Set<SoalJawabanEntity> getSoalJawabanEntity() {
        return soalJawabanEntity;
    }

    public void setSoalJawabanEntity(Set<SoalJawabanEntity> soalJawabanEntity) {
        this.soalJawabanEntity = soalJawabanEntity;
    }

    public Set<UjianEntity> getUjianEntity() {
        return ujianEntity;
    }

    public void setUjianEntity(Set<UjianEntity> ujianEntity) {
        this.ujianEntity = ujianEntity;
    }
}
