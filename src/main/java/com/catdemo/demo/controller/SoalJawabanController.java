package com.catdemo.demo.controller;

import com.catdemo.demo.entity.SoalJawabanEntity;
import com.catdemo.demo.entity.SoalKelompokEntity;
import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.payload.request.SoalJawabanRequest;
import com.catdemo.demo.util.RestResponse;
import com.catdemo.demo.util.constants.SoalJawabanConstant;
import com.catdemo.demo.util.constants.SoalKelompokConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/API/SoalJawaban")
public class SoalJawabanController {
    @Autowired
    ServiceFac service;
    RestResponse result;
    @GetMapping(value = "/")
    public ResponseEntity SoalJawabanGelAll(){
        result =new RestResponse();
        try {
            List<SoalJawabanEntity> data =  service.getSoalJawabanService().getAllSoalJawaban();
            result.setMessage(SoalJawabanConstant.SOALJAWABANGETALLSUCCESS);
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
    public ResponseEntity SoalJawabanGetAllActive(){
        result =new RestResponse();
        try {
            List<SoalJawabanEntity> data = service.getSoalJawabanService().getSoalJawabanStatActive();
            result.setMessage(SoalJawabanConstant.SOALJAWABANGETALLSTATACTIVESUCCESS);
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
    public ResponseEntity SoalJawabanGetAllDisable(){
        result =new RestResponse();
        try {
            List<SoalJawabanEntity> data = service.getSoalJawabanService().getSoalJawabanStatDisable();
            result.setMessage(SoalJawabanConstant.SOALJAWABANGETALLSTATDISABLESUCCESS);
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
    public ResponseEntity SoalJawabanGetByid(@PathVariable UUID id){
        result = new RestResponse();
        try {
            SoalJawabanEntity data = service.getSoalJawabanService().getSoalJawabanById(id);
            result.setMessage(SoalJawabanConstant.SOALJAWABANGETBYIDSUCCESS);
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
    public ResponseEntity SoalJawabanToActiveById(@PathVariable UUID id){
        result = new RestResponse();
        try {
            service.getSoalJawabanService().updateSoalJawabanStatActive(id);
            result.setMessage(SoalJawabanConstant.SOALJAWABANTOACTIVESUCCESS);
            result.setSuccess(true);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            result.setSuccess(true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity SoalJawabanDeleteByid(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            service.getSoalJawabanService().deleteSoalJawabanById(id);
            result.setMessage(SoalJawabanConstant.SOALJAWABANDELETEBYIDSUCCESS);
            result.setSuccess(true);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @DeleteMapping(value = "/deletestat/{id}")
    public ResponseEntity SoalJawabanStatDeleteBy(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            service.getSoalJawabanService().deleteSoalJawabanStatById(id);
            result.setSuccess(true);
            result.setMessage(SoalJawabanConstant.SOALJAWABANSTATDELETEBYIDSUCCESS);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity SoalJawabanAdd(@RequestBody SoalJawabanRequest request) throws Exception{
        RestResponse result = new RestResponse();
        try {
            service.getSoalJawabanService().SaveSoalJawaban(request);
            result.setMessage(SoalJawabanConstant.SOALJAWABANADDSUCCESS);
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
    public ResponseEntity SoalJawabanUpdate(@RequestBody SoalJawabanRequest request) throws Exception{
        RestResponse result = new RestResponse();
        try {
            service.getSoalJawabanService().UpdateSoalJawaban(request);
            result.setMessage(SoalJawabanConstant.SOALJAWABANUPDATESUCCESS);
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
