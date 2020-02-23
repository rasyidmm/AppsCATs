package com.catdemo.demo.controller;

import com.catdemo.demo.entity.SoalKelompokEntity;
import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.payload.request.SoalKelompokRequest;
import com.catdemo.demo.util.RestResponse;
import com.catdemo.demo.util.constants.SoalKelompokConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/API/Soalkelompok")
public class SoalKelompokController {
    @Autowired
    ServiceFac service;
    @GetMapping(value = "/")
    public ResponseEntity SoalKelompokGetAll(){
        RestResponse result = new RestResponse();
        try {
            List<SoalKelompokEntity> data = service.getSoalKelompokService().getAllSoalKelompok();
            result.setDatas(data);
            result.setSuccess(true);
            result.setMessage(SoalKelompokConstant.SOALKELOMPOKGETALLSUCCESS);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @GetMapping(value = "/active/")
    public ResponseEntity SoalKelompolGetAllActive(){
        RestResponse result =  new RestResponse();
        try {
            List<SoalKelompokEntity> data = service.getSoalKelompokService().getSoalKelompokStatActive();
            result.setDatas(data);
            result.setSuccess(true);
            result.setMessage(SoalKelompokConstant.SOALKELOMPOKGETALLACTIVESUCCESS);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @GetMapping(value = "/disable/")
    public ResponseEntity SoalKelompolGetAllDisable(){
        RestResponse result =  new RestResponse();
        try {
            List<SoalKelompokEntity> data = service.getSoalKelompokService().getSoalKelompokStatDisable();
            result.setDatas(data);
            result.setSuccess(true);
            result.setMessage(SoalKelompokConstant.SOALKELOMPOKGETALLDISABLESUCCESS);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity SoalKelompokGetById(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            SoalKelompokEntity Data = service.getSoalKelompokService().getSoalKelompokById(id);
            result.setMessage(SoalKelompokConstant.SOALKELOMPOKGETBYIDSUCCESS);
            result.setSuccess(true);
            result.setDatas(Data);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @PostMapping(value = "/add")
    public ResponseEntity SoalKelompokAdd(SoalKelompokRequest request) throws Exception{
        RestResponse result = new RestResponse();
        try {
            service.getSoalKelompokService().SaveSoalKelompok(request);
            result.setMessage(SoalKelompokConstant.SOALKELOMPOKADDSUCCESS);
            result.setSuccess(true);
            result.setDatas(request);
            return ResponseEntity.ok(request);
        }catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @PutMapping(value = "/update")
    public ResponseEntity SoalKelompokUpdate(SoalKelompokRequest request) throws Exception{
        RestResponse result = new RestResponse();
        try {
            service.getSoalKelompokService().UpdateSoalKelompok(request);
            result.setMessage(SoalKelompokConstant.SOALKELOMPOKUPDATESUCCESS);
            result.setSuccess(true);
            result.setDatas(request);
            return ResponseEntity.ok(request);
        }catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity SoalKelompokDelete(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            service.getSoalKelompokService().deleteSoalKelompokById(id);
            result.setDatas("");
            result.setSuccess(true);
            result.setMessage(SoalKelompokConstant.SOALKELOMPOKDELETEBYID);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @DeleteMapping(value = "/deletestat/{id}")
    public ResponseEntity SoalKelompokStatDelete(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            service.getSoalKelompokService().deleteSoalKelompokStatById(id);
            result.setDatas("");
            result.setSuccess(true);
            result.setMessage(SoalKelompokConstant.SOALKELOMPOKDELETESTATBYID);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @PostMapping(value = "/toactive/{id}")
    public ResponseEntity SoalKelompokToActiveById(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            service.getSoalKelompokService().updateSoalKelompokStatActive(id);
            result.setDatas("");
            result.setSuccess(true);
            result.setMessage(SoalKelompokConstant.SOALKELOMPOKTOACTIVESUCCESS);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
