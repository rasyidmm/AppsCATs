package com.catdemo.demo.controller;

import com.catdemo.demo.entity.UjianEntity;
import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.payload.request.UjianRequest;
import com.catdemo.demo.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/API/Ujian")
public class UjianController {
    @Autowired
    ServiceFac service;
    RestResponse result;
    @PostMapping(value = "/add")
    public ResponseEntity SetUpUjian(@RequestBody UjianRequest request){
        result = new RestResponse();
        UUID idc = UUID.randomUUID();
        try {
            String namaUjian =  service.getAktorService().getAktorById(request.getIdAktorEntity()).getNamaDepan().concat(idc.toString() );
            request.setNamaUjian(namaUjian);
            service.getUjianService().SaveUjian(request);
            result.setMessage("Create Ujian sukses");
            result.setSuccess(true);
            result.setDatas(service.getUjianService().getUjianByNameUjian(namaUjian));
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity GetUjianById(@PathVariable UUID id){
        result = new RestResponse();
        try {
            result.setMessage("Create Ujian sukses");
            result.setSuccess(true);
            result.setDatas(service.getUjianService().getUjianById(id));
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
