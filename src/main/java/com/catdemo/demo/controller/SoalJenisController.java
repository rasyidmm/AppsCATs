package com.catdemo.demo.controller;

import com.catdemo.demo.entity.SoalJenisEntity;
import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.payload.request.SoalJenisRequest;
import com.catdemo.demo.util.constants.SoalJenisConstant;
import com.catdemo.demo.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/API/Soaljenis")
public class SoalJenisController {
    @Autowired
    ServiceFac service;

    @GetMapping(value = "/")
    public ResponseEntity SoalJenisGetAll(){
        RestResponse result = new RestResponse();
        try {
            List<SoalJenisEntity>data =service.getSoalJenisService().getAllSoalJenis();
            result.setDatas(data);
            result.setMessage(SoalJenisConstant.SOALJENISGETALL);
            result.setSuccess(true);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity SoalJenisAdd(@RequestBody SoalJenisRequest request) throws Exception{
        RestResponse result = new RestResponse();
        try{service.getSoalJenisService().SaveSoalJenis(request);
            result.setSuccess(true);
            result.setMessage(SoalJenisConstant.SOALJENISADDSUCCESS);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @PutMapping(value = "/update")
    public ResponseEntity SoalJenisUpdate(@RequestBody SoalJenisRequest request)throws Exception{
        RestResponse result = new RestResponse();
        try {
            service.getSoalJenisService().UpdateSoalJenis(request);
            result.setMessage(SoalJenisConstant.SOALJENISUPDATESUCCESS);
            result.setSuccess(true);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity GetSoalJenisById(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            SoalJenisEntity data= service.getSoalJenisService().getSoalJenisById(id);
            result.setMessage("Get Soal Jenis By Id Success");
            result.setSuccess(true);
            result.setDatas(data);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
