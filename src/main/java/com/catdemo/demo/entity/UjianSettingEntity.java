package com.catdemo.demo.entity;

import javax.persistence.Cacheable;
import javax.persistence.Entity;

@Entity
@Cacheable
public class UjianSettingEntity extends Additional{
    private String namaSetting;
    private int valueSetting;

    public String getNamaSetting() {
        return namaSetting;
    }

    public void setNamaSetting(String namaSetting) {
        this.namaSetting = namaSetting;
    }

    public int getValueSetting() {
        return valueSetting;
    }

    public void setValueSetting(int valueSetting) {
        this.valueSetting = valueSetting;
    }
}
