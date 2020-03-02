package com.catdemo.demo.controller;

import com.catdemo.demo.entity.AktorEntity;
import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.payload.request.AktorRequest;
import com.catdemo.demo.util.RestResponse;
import com.catdemo.demo.util.constants.AktorConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/API/Aktor")
public class AktorController {
    @Autowired
    ServiceFac service;
    RestResponse result;
    @GetMapping(value = "/")
    public ResponseEntity AktorGelAll(){
        result =new RestResponse();
        try {
            List<AktorEntity> data = service.getAktorService().getAllAktor();
            result.setMessage(AktorConstant.AKTORGETALLSUCCESS);
            result.setSuccess(true);
            result.setDatas(data);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            result.setSuccess(true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @GetMapping(value = "/statactive/")
    public ResponseEntity AktorGetAllActive(){
        result =new RestResponse();
        try {
            List<AktorEntity> data = service.getAktorService().getAktorStatActive();
            result.setMessage(AktorConstant.AKTORGETALLSTATACTICESUCCESS);
            result.setSuccess(true);
            result.setDatas(data);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            result.setSuccess(true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @GetMapping(value = "/statdisable/")
    public ResponseEntity AktorGetAllDisable(){
        result =new RestResponse();
        try {
            List<AktorEntity> data = service.getAktorService().getAktorStatDisable();
            result.setMessage(AktorConstant.AKTORGETALLSTATDISABLESUCCESS);
            result.setSuccess(true);
            result.setDatas(data);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            result.setSuccess(true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @GetMapping(value ="/{id}")
    public ResponseEntity AktorGetByid(@PathVariable UUID id){
        result = new RestResponse();
        try {
            AktorEntity data = service.getAktorService().getAktorById(id);
            result.setMessage(AktorConstant.AKTORGETBYIDSUCCESS);
            result.setSuccess(true);
            result.setDatas(data);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            result.setSuccess(true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @GetMapping(value ="/toactive/{id}")
    public ResponseEntity AktorToActiveById(@PathVariable UUID id){
        result = new RestResponse();
        try {
            service.getAktorService().updateAktorStatActive(id);
            result.setMessage(AktorConstant.AKTORSTATTOACTIVESUCCESS);
            result.setSuccess(true);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            result.setSuccess(true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity AktorDeleteByid(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            service.getAktorService().deleteAktorById(id);
            result.setDatas(AktorConstant.AKTORDELETEBYIDSUCCESS);
            result.setSuccess(true);
            result.setMessage("");
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @DeleteMapping(value = "/deletestat/{id}")
    public ResponseEntity AktorStatDeleteBy(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            service.getAktorService().deleteAktorStatById(id);
            result.setSuccess(true);
            result.setMessage(AktorConstant.AKTORDELETESTATBYIDSUCCESS);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity AktorAdd(AktorRequest request) throws Exception{
        RestResponse result = new RestResponse();
        try {
            service.getAktorService().SaveAktor(request);
            result.setMessage(AktorConstant.AKTORADDSECCESS);
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
    public ResponseEntity AktorUpdate(AktorRequest request) throws Exception{
        RestResponse result = new RestResponse();
        try {
            service.getAktorService().UpdateAktor(request);
            result.setMessage(AktorConstant.AKTORUPDATESUCCESS);
            result.setSuccess(true);
            result.setDatas(request);
            return ResponseEntity.ok(request);
        }catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
