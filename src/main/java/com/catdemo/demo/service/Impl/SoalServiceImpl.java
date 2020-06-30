package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.SoalEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.payload.request.SoalRequest;
import com.catdemo.demo.service.SoalService;
import com.catdemo.demo.util.constants.SoalConstant;
import com.catdemo.demo.util.constants.SoalJawabanConstant;
import com.catdemo.demo.util.constants.UjianSettingConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class SoalServiceImpl implements SoalService {
    @Autowired
    RepositoryFac repo;
    private SimpleDateFormat timeDo = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
    @Override
    public List<SoalEntity> getAllSoal() {
        List<SoalEntity> sel = new ArrayList<>();
        repo.getSoalRepository().findAll().forEach(sel::add);
        return sel;
    }

    @Override
    public SoalEntity getSoalById(UUID id) {
        SoalEntity se = repo.getSoalRepository().findById(id).get();
        return se;
    }

    @Override
    public void SaveSoal(SoalRequest request) throws Exception {
        FieldNullChecker(request);
        SameNameChacker(request);
        try {
            SoalEntity se = new SoalEntity();
            se.setSoalJenisEntity(repo.getSoalJenisRepository().findById(request.getIdSoalJenis()).get());
            se.setSoalKelompokEntity(repo.getSoalKelompokRepository().findById(request.getIdSoalKelompok()).get());
            se.setSoal(request.getSoal());
            se.setFlagSoal(request.getFlagSoal());
            se.setLinkImage("");
            se.setVersion((long) 1);
            se.setCreateDate(timeDo.format(new Date()));
            se.setStatus(SoalConstant.SOALSTATACTIVE);
            repo.getSoalRepository().save(se);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public void UpdateSoal(SoalRequest request) throws Exception {
        FieldNullChecker(request);
        SameNameChacker(request);
        try {
            SoalEntity se = getSoalById(request.getId());
            se.setSoalJenisEntity(repo.getSoalJenisRepository().findById(request.getIdSoalJenis()).get());
            se.setSoalKelompokEntity(repo.getSoalKelompokRepository().findById(request.getIdSoalKelompok()).get());
            se.setSoal(request.getSoal());
            se.setFlagSoal(request.getFlagSoal());
            se.setLinkImage("");
            se.setVersion(se.getVersion()+ 1);
            se.setUpdateDate(timeDo.format(new Date()));
            repo.getSoalRepository().save(se);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public void deleteSoalById(UUID id) {
        repo.getSoalRepository().deleteById(id);
    }

    @Override
    public void deleteSoalStatById(UUID id) throws Exception {
        try {
            SoalEntity se = getSoalById(id);
            se.setStatus(SoalConstant.SOALSTATDISABLE);
            se.setUpdateDate(timeDo.format(new Date()));
            repo.getSoalRepository().save(se);
        }catch (Exception e){
            throw new Exception(e);
        }
    }

    @Override
    public List<SoalEntity> getSoalStatActive() {
        List<SoalEntity> sel = new ArrayList<>();
        repo.getSoalRepository().findAllByStatus(SoalConstant.SOALSTATACTIVE).forEach(sel::add);
        return sel;
    }

    @Override
    public List<SoalEntity> getSoalStatDisable() {
        List<SoalEntity> sel = new ArrayList<>();
        repo.getSoalRepository().findAllByStatus(SoalConstant.SOALSTATDISABLE).forEach(sel::add);
        return sel;
    }

    @Override
    public void updateSoalStatActive(UUID id) throws Exception {
        if (repo.getSoalRepository().findByIdAndStatus(id,SoalConstant.SOALSTATDISABLE)!=null){
            try {
                SoalEntity se = getSoalById(id);
                se.setStatus(SoalConstant.SOALSTATACTIVE);
                se.setUpdateDate(timeDo.format(new Date()));
                repo.getSoalRepository().save(se);
            }catch (Exception e){
                throw new Exception(e);
            }
        }else {
            throw new Exception(SoalConstant.SOALSTATDISABLENOTEXISTING);
        }
    }

    @Override
    public SoalEntity getRandom() {
        List<SoalEntity>rrr =getAllSoal();
        Random dd =  new Random();

        SoalEntity jug = rrr.get(dd.nextInt(rrr.size()));
        return jug;

    }

    @Override
    public List<SoalEntity> getAllSoalTWKActive() {
        List<SoalEntity> sel = new ArrayList<>();
        repo.getSoalRepository().findAllByStatusAndSoalKelompokEntity
                (repo.getSoalKelompokRepository().findByNamaSoalKelompok(UjianSettingConstant.UJIANSETTINGTWK).
                getId()).forEach(sel::add);
        return sel;
    }

    @Override
    public List<SoalEntity> getAllSoalTIUActive() {
        List<SoalEntity> sel = new ArrayList<>();
        repo.getSoalRepository().findAllByStatusAndSoalKelompokEntity
                (repo.getSoalKelompokRepository().findByNamaSoalKelompok(UjianSettingConstant.UJIANSETTINGTIU).
                getId()).forEach(sel::add);
        return sel;
    }

    @Override
    public List<SoalEntity> getAllSoalTKPActive() {
        List<SoalEntity> sel = new ArrayList<>();
        repo.getSoalRepository().findAllByStatusAndSoalKelompokEntity
                (repo.getSoalKelompokRepository().findByNamaSoalKelompok(UjianSettingConstant.UJIANSETTINGTKP).
                getId()).forEach(sel::add);
        return sel;
    }

    @Override
    public List<SoalEntity> getAllSoalByNamaUjian(String namaUjian) {
        List<SoalEntity> sel = new ArrayList<>();
        repo.getSoalRepository().findAllSoalByNamaUjial(namaUjian).forEach(sel::add);
        return sel;
    }

    @Override
    public List<SoalEntity> getAllSoalByUjianId(UUID idUjian) {
        List<SoalEntity> sel = new ArrayList<>();
        repo.getSoalRepository().findAllByUjianId(idUjian).forEach(sel::add);
        return sel;
    }

    private void FieldNullChecker(SoalRequest request) throws Exception{
        if (request.getSoal().isEmpty()||request.getSoal()==null||request.getSoal()==" "){
            throw new Exception(SoalConstant.SOALFIELDSOALNULL);
        }else if (request.getIdSoalJenis() == null){
            throw new Exception(SoalConstant.SOALFIELDIDJENISSAOLNULL);
        }else if (request.getIdSoalKelompok() == null){
            throw new Exception(SoalConstant.SOALFIELDIDKELOMPOKSOALNULL);
        }
    }

    private void SameNameChacker(SoalRequest request)throws Exception{
        if(repo.getSoalRepository().findBySoal(request.getSoal())!=null){
            throw new Exception(SoalConstant.SOALSAMENAME);
        }
    }
}
