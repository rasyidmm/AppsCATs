package com.catdemo.demo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

@Entity
@Cacheable
public class AktorEntity extends Additional{
    private String namaDepan;
    private String namaBelakang;
    private String jenisKelamin;
    private String alamatRumah;
    private String noHandphone;
    private String username;
    private String emailActor;
    private String levelPrevilage;
    private String password;

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getAlamatRumah() {
        return alamatRumah;
    }

    public void setAlamatRumah(String alamatRumah) {
        this.alamatRumah = alamatRumah;
    }

    public String getNoHandphone() {
        return noHandphone;
    }

    public void setNoHandphone(String noHandphone) {
        this.noHandphone = noHandphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailActor() {
        return emailActor;
    }

    public void setEmailActor(String emailActor) {
        this.emailActor = emailActor;
    }

    public String getLevelPrevilage() {
        return levelPrevilage;
    }

    public void setLevelPrevilage(String levelPrevilage) {
        this.levelPrevilage = levelPrevilage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
