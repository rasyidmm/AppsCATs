package com.catdemo.demo.controller;

import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.payload.request.AktorJawabanRequest;
import com.catdemo.demo.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/API/AktorJawaban")
public class AktorJawabanController {
    @Autowired
    ServiceFac service;
    RestResponse result;

    @PostMapping("/add")
    public ResponseEntity postAktorJawaban(@RequestBody AktorJawabanRequest request){
        RestResponse result = new RestResponse();
        try {
            service.getAktorJawabanService().SaveAktorJawaban(request);
            result.setSuccess(true);
            result.setMessage("A");
            result.setDatas(request);
            return ResponseEntity.ok(result);
        }catch (Exception e){
            result.setSuccess(false);
            result.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }
}
