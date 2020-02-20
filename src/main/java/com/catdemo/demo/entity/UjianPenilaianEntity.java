package com.catdemo.demo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
@Cacheable
public class UjianPenilaianEntity extends Additional{
    private Long skorJawabUser;
    @ManyToMany
    private Set<AktorJawabanEntity> aktorJawabanEntities;
    @ManyToOne
    private UjianEntity ujianEntity;

    public Long getSkorJawabUser() {
        return skorJawabUser;
    }

    public void setSkorJawabUser(Long skorJawabUser) {
        this.skorJawabUser = skorJawabUser;
    }

    public Set<AktorJawabanEntity> getAktorJawabanEntities() {
        return aktorJawabanEntities;
    }

    public void setAktorJawabanEntities(Set<AktorJawabanEntity> aktorJawabanEntities) {
        this.aktorJawabanEntities = aktorJawabanEntities;
    }

    public UjianEntity getUjianEntity() {
        return ujianEntity;
    }

    public void setUjianEntity(UjianEntity ujianEntity) {
        this.ujianEntity = ujianEntity;
    }
}
