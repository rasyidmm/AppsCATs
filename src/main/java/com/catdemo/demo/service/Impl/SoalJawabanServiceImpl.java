package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.SoalJawabanEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.payload.request.SoalJawabanRequest;
import com.catdemo.demo.service.SoalJawabanService;
import com.catdemo.demo.util.constants.SoalJawabanConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SoalJawabanServiceImpl implements SoalJawabanService {

    @Autowired
    RepositoryFac repo;
    private SimpleDateFormat timeDo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @Override
    public List<SoalJawabanEntity> getAllSoalJawaban() {
        List<SoalJawabanEntity> sjel = new ArrayList<>();
        repo.getSoalJawabanRepository().findAll().forEach(sjel::add);
        return sjel;
    }

    public List<SoalJawabanEntity> getAllSoalJawabanByIdSoal(UUID id ) {
        List<SoalJawabanEntity> sjesl = new ArrayList<>();
        repo.getSoalJawabanRepository().findAllBySoalEntityId(id).forEach(sjesl::add);
        return sjesl;
    }

    @Override
    public SoalJawabanEntity getSoalJawabanById(UUID id) {
        SoalJawabanEntity sje = repo.getSoalJawabanRepository().findById(id).get();
        return sje;
    }

    @Override
    public void SaveSoalJawaban(SoalJawabanRequest request) throws Exception {
        try {
            FieldNullChecker(request);
            SoalJawabanEntity sje =  new SoalJawabanEntity();
            sje.setLinkimageJawaban(request.getLinkimageJawaban());
            sje.setSkor(request.getSkor());
            sje.setSoalJawaban(request.getSoalJawaban());
            sje.setCreateDate(timeDo.format(new Date()));
            sje.setVersion((long) 1);
            sje.setStatus(SoalJawabanConstant.SOALJAWABANACTIVE);
            sje.setSoalEntity(repo.getSoalRepository().findById(request.getIdSoalEntity()).get());
            repo.getSoalJawabanRepository().save(sje);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public void UpdateSoalJawaban(SoalJawabanRequest request) throws Exception {
        try {
            FieldNullChecker(request);
            SoalJawabanEntity sje =  getSoalJawabanById(request.getId());
            sje.setLinkimageJawaban(request.getLinkimageJawaban());
            sje.setSkor(request.getSkor());
            sje.setSoalJawaban(request.getSoalJawaban());
            sje.setUpdateDate(timeDo.format(new Date()));
            sje.setVersion(sje.getVersion()+1);
            sje.setSoalEntity(repo.getSoalRepository().findById(request.getIdSoalEntity()).get());
            repo.getSoalJawabanRepository().save(sje);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }

    }

    @Override
    public void deleteSoalJawabanById(UUID id) {
        repo.getSoalJawabanRepository().deleteById(id);
    }

    @Override
    public void deleteSoalJawabanStatById(UUID id) throws Exception {
        try {
            SoalJawabanEntity sje =  getSoalJawabanById(id);
            sje.setUpdateDate(timeDo.format(new Date()));
            sje.setStatus(SoalJawabanConstant.SOALJAWABANDISABLE);
            repo.getSoalJawabanRepository().save(sje);
        }catch (Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    public List<SoalJawabanEntity> getSoalJawabanStatActive() {
        List<SoalJawabanEntity> sjel = new ArrayList<>();
        repo.getSoalJawabanRepository().findAllByStatus(SoalJawabanConstant.SOALJAWABANACTIVE).forEach(sjel::add);
        return sjel;
    }

    @Override
    public List<SoalJawabanEntity> getSoalJawabanStatDisable() {
        List<SoalJawabanEntity> sjel = new ArrayList<>();
        repo.getSoalJawabanRepository().findAllByStatus(SoalJawabanConstant.SOALJAWABANDISABLE).forEach(sjel::add);
        return sjel;
    }

    @Override
    public void updateSoalJawabanStatActive(UUID id) throws Exception {
        if(repo.getSoalJawabanRepository().findByIdAndStatus(id,SoalJawabanConstant.SOALJAWABANDISABLE)!=null) {
            try {
                SoalJawabanEntity sje = repo.getSoalJawabanRepository().findByIdAndStatus(id, SoalJawabanConstant.SOALJAWABANDISABLE);
                sje.setUpdateDate(timeDo.format(new Date()));
                sje.setStatus(SoalJawabanConstant.SOALJAWABANACTIVE);
                repo.getSoalJawabanRepository().save(sje);
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        }else {
            throw new Exception(SoalJawabanConstant.SOALJAWABANSTATDISABLENOTEXIT);
        }
    }
    //Checker
    private void FieldNullChecker(SoalJawabanRequest request) throws Exception{
        if (request.getIdSoalEntity() ==null){
            throw new Exception(SoalJawabanConstant.SOALJAWABANIDSOALNULL);
        }else if(request.getSoalJawaban().isEmpty()){
            if (request.getLinkimageJawaban().isEmpty()) {
                throw new Exception(SoalJawabanConstant.SOALJAWABANANDIMAGENULL);
            }
        }else if(request.getSkor() == null){
            throw new Exception(SoalJawabanConstant.SOALJAWABANSKORNULL);
        }
    }


}
