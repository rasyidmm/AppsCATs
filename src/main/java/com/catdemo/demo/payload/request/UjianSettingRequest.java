package com.catdemo.demo.payload.request;

import java.util.UUID;

public class UjianSettingRequest {
    private UUID id;
    private String namaSetting;
    private int valueSetting;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
