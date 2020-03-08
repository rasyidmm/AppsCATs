package com.catdemo.demo.controller;

import com.catdemo.demo.entity.UjianEntity;
import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.payload.request.UjianRequest;
import com.catdemo.demo.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/API/Ujian")
public class UjianController {
    @Autowired
    ServiceFac service;
    RestResponse result;
    @PostMapping(value = "/")
    public ResponseEntity SetUpUjian(@RequestBody UjianRequest request){
        result = new RestResponse();
        UUID idc = UUID.randomUUID();
        try {
            String namaUian =  service.getAktorService().getAktorById(request.getIdAktorEntity()).getNamaDepan().concat(idc.toString() );
            request.setNamaUjian(namaUian);
            service.getUjianService().SaveUjian(request);
            result.setDatas();
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
