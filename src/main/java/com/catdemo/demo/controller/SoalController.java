package com.catdemo.demo.controller;

import com.catdemo.demo.entity.SoalEntity;
import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.payload.request.SoalRequest;
import com.catdemo.demo.util.RestResponse;
import com.catdemo.demo.util.constants.SoalConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/API/Soal")
public class SoalController {
    @Autowired
    ServiceFac service;
    RestResponse result;
    @GetMapping(value = "/")
    public ResponseEntity SoalGelAll(){
        result =new RestResponse();
        try {
            List<SoalEntity> data =  service.getSoalService().getAllSoal();
            result.setMessage(SoalConstant.SOALGETALLSUCCESS);
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
    public ResponseEntity SoalGetAllActive(){
        result =new RestResponse();
        try {
            List<SoalEntity> data = service.getSoalService().getSoalStatActive();
            result.setMessage(SoalConstant.SOALGETLLSTATACTIVESUCCESS);
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
    public ResponseEntity SoalGetAllDisable(){
        result =new RestResponse();
        try {
            List<SoalEntity> data = service.getSoalService().getSoalStatDisable();
            result.setMessage(SoalConstant.SOALGETLLSTATDISBALESUCCESS);
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
    public ResponseEntity SoalGetByid(@PathVariable UUID id){
        result = new RestResponse();
        try {
            SoalEntity data = service.getSoalService().getSoalById(id);
            result.setMessage(SoalConstant.SOALGETBYIDSUCCESS);
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
    public ResponseEntity SoalToActiveById(@PathVariable UUID id){
        result = new RestResponse();
        try {
            service.getSoalService().updateSoalStatActive(id);
            result.setMessage(SoalConstant.SOALTOACTIVEBYIDSUCCESS);
            result.setSuccess(true);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setMessage(e.getMessage());
            result.setSuccess(true);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity SoalDeleteByid(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            service.getSoalService().deleteSoalById(id);
            result.setDatas(SoalConstant.SOALDELETEBYIDSUCCESS);
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
    public ResponseEntity SoalStatDeleteBy(@PathVariable UUID id){
        RestResponse result = new RestResponse();
        try {
            service.getSoalService().deleteSoalStatById(id);
            result.setSuccess(true);
            result.setMessage(SoalConstant.SOALDELETESTATBYIDSUCCESS);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity SoalAdd(@RequestBody SoalRequest request) throws Exception{
        RestResponse result = new RestResponse();
        try {
            service.getSoalService().SaveSoal(request);
            result.setMessage(SoalConstant.SOALADDSUCCESS);
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
    public ResponseEntity SoalUpdate(@RequestBody SoalRequest request) throws Exception{
        RestResponse result = new RestResponse();
        try {
            service.getSoalService().UpdateSoal(request);
            result.setMessage(SoalConstant.SOALUPDATESUCCESS);
            result.setSuccess(true);
            result.setDatas("");
            return ResponseEntity.ok(request);
        }catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @GetMapping(value = "/random")
    public ResponseEntity SoalRandom(){
        RestResponse result = new RestResponse();
        result.setMessage("berhasil");
        result.setDatas(service.getSoalService().getRandom());
        return ResponseEntity.ok(result);
    }
}
