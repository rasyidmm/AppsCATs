package com.catdemo.demo.controller;

import com.catdemo.demo.entity.UjianSettingEntity;
import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.payload.request.UjianSettingRequest;
import com.catdemo.demo.util.RestResponse;
import com.catdemo.demo.util.constants.UjianSettingConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/API/Ujiansetting")
public class UjianSettingController {
    @Autowired
    ServiceFac service;
    RestResponse result;
    @GetMapping(value = "/")
    public ResponseEntity UjianSettingGelAll(){
        result =new RestResponse();
        try {
            List<UjianSettingEntity> data = service.getUjianSettingService().getAllUjianSetting();
            result.setMessage(UjianSettingConstant.UJIANSETTINGGETALLSUCCESS);
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
    public ResponseEntity UjianSettingGetAllActive(){
        result =new RestResponse();
        try {
            List<UjianSettingEntity> data = service.getUjianSettingService().getUjianSettingStatActive();
            result.setMessage(UjianSettingConstant.UJIANSETTINGGETALLSTATACTIVE);
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
    public ResponseEntity UjianSettingGetAllDisable(){
        result =new RestResponse();
        try {
            List<UjianSettingEntity> data = service.getUjianSettingService().getUjianSettingStatDisable();
            result.setMessage(UjianSettingConstant.UJIANSETTINGGETALLSTATDISABLE);
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
    public ResponseEntity UjianSettingGetByid(@PathVariable UUID id){
        result = new RestResponse();
        try {
            UjianSettingEntity data = service.getUjianSettingService().getUjianSettingById(id);
            result.setMessage(UjianSettingConstant.UJIANSETTINGGETBYIDSUCCESS);
            result.setSuccess(true);
            result.setDatas(data);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            result.setSuccess(true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @PostMapping(value ="/toactive/{id}")
    public ResponseEntity UjianSettingToActiveById(@PathVariable UUID id){
        result = new RestResponse();
        try {
            service.getUjianSettingService().updateUjianSettingStatActive(id);
            result.setMessage(UjianSettingConstant.UJIANSETTINGSTATTOACTIVESUCCESS);
            result.setSuccess(true);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            result.setSuccess(true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity UjianSettingDeleteByid(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            service.getUjianSettingService().deleteUjianSettingById(id);
            result.setDatas(UjianSettingConstant.UJIANSETTINGDELETEBYIDSUCCESS);
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
    public ResponseEntity UjianSettingStatDeleteBy(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            service.getUjianSettingService().deleteUjianSettingStatById(id);
            result.setSuccess(true);
            result.setMessage(UjianSettingConstant.UJIANSETTINGDELETESTATBYIDSUCCESS);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity UjianSettingAdd(@RequestBody UjianSettingRequest request) throws Exception{
        RestResponse result = new RestResponse();
        try {
            service.getUjianSettingService().SaveUjianSetting(request);
            result.setMessage(UjianSettingConstant.UJIANSETTINGADDSUCCESS);
            result.setSuccess(true);
            result.setDatas("");
            return ResponseEntity.ok(result);
        }catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @PutMapping(value = "/update")
    public ResponseEntity UjianSettingUpdate(@RequestBody UjianSettingRequest request) throws Exception{
        RestResponse result = new RestResponse();
        try {
            service.getUjianSettingService().UpdateUjianSetting(request);
            result.setMessage(UjianSettingConstant.UJIANSETTINGUPDATESUCCESS);
            result.setSuccess(true);
            result.setDatas(request);
            return ResponseEntity.ok(result);
        }catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
