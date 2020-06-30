package com.catdemo.demo.controller;

import com.catdemo.demo.entity.UjianHasilEntity;
import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/API/Ujianhasil")
@RestController
public class UjianHasilController {
    @Autowired
    ServiceFac service;
    RestResponse result;

    @GetMapping("/gethasilujianbyidujian/{id}")
    public ResponseEntity getHasilUjianByIdSoal(@PathVariable UUID id){
        result = new RestResponse();

        try {
            UjianHasilEntity uje = service.getUjianHasilService().getHasilUjianByIdUjian(id);
            result.setMessage("get Hasil Ujian sukses");
            result.setSuccess(true);
            result.setDatas(uje);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage(e.getStackTrace().toString());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

}
