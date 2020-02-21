package com.catdemo.demo.controller;

import com.catdemo.demo.entity.SoalJenisEntity;
import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.payload.request.SoalJenisRequest;
import com.catdemo.demo.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/API/Soaljenis")
public class SoalJenisController {
    @Autowired
    ServiceFac service;

    @GetMapping(value = "/")
    public ResponseEntity SoalJenisGetAll(){
        RestResponse result = new RestResponse();
        List<SoalJenisEntity>data =service.getSoalJenisService().getAllSoalJenis();
        result.setDatas(data);
        result.setMessage("");
        result.setSuccess(true);
        return ResponseEntity.ok(result);
    }

    @PostMapping(value = "/add")
    public ResponseEntity SoalJenisAdd(@RequestBody SoalJenisRequest request) throws Exception{
        RestResponse result = new RestResponse();
        try{service.getSoalJenisService().SaveSoalJenis(request);
            result.setSuccess(true);
            result.setMessage("Add Soal Jenis Success");
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
