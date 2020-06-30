package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.SoalEntity;
import com.catdemo.demo.entity.UjianEntity;
import com.catdemo.demo.entity.UjianSoalEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.payload.request.UjianRequest;
import com.catdemo.demo.service.UjianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class UjianServiceImpl implements UjianService {
    @Autowired
    RepositoryFac repo;
    @Autowired
    ServiceFac service;
    @Override
    public List<UjianEntity> getAllUjian() {
        return null;
    }

    @Override
    public List<UjianEntity> getUjianById(UUID id) {
        List<UjianEntity> ael = new ArrayList<>();
        repo.getUjianRepository().findByIdJoin(id).forEach(ael::add);;
        return ael;
    }

    @Override
    public void SaveUjian(UjianRequest request) throws Exception {

        try {
            long duration = 0;
            if(request.getTiu()){
                duration =+40;
            }
            if (request.getTkp()){
                duration =+40;
            }
            if (request.getTwk()){
                duration =+40;
            }
            UjianEntity ujians = new UjianEntity();
            ujians.setNamaUjian(request.getNamaUjian());
            ujians.setAktorEntity(service.getAktorService().getAktorById(request.getIdAktorEntity()));

            ujians.setDurasiUjian(duration);
            repo.getUjianRepository().save(ujians);
            if(request.getTiu()){
                GetSoalTIURandom(request.getNamaUjian());
            }
            if (request.getTkp()){
                GetSoalTKPRandom(request.getNamaUjian());
            }

            if (request.getTwk()){
                GetSoalTwkRandom(request.getNamaUjian());
            }

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void UpdateUjian(UjianRequest request) throws Exception {

    }

    @Override
    public void deleteUjianById(UUID id) {

    }

    @Override
    public void deleteUjianStatById(UUID id) throws Exception {

    }

    @Override
    public List<UjianEntity> getUjianStatActive() {
        return null;
    }

    @Override
    public List<UjianEntity> getUjianStatDisable() {
        return null;
    }

    @Override
    public void updateUjianStatActive(UUID id) throws Exception {

    }

    @Override
    public UjianEntity getUjianByNameUjian(String namaUjian) {
       UjianEntity dd =  repo.getUjianRepository().findByNamaUjian(namaUjian);
       return dd;
    }

    @Override
    public List<UjianEntity> findAllByUjianAndSoal(String namaUjian, UUID idSoal) {
        List<UjianEntity> sel = new ArrayList<>();
        repo.getUjianRepository().findAllByUjianAndSoal(namaUjian,idSoal).forEach(sel::add);
        return sel;
    }


    public void GetSoalTwkRandom(String namaUjian){

//        int twk = service.getUjianSettingService().getValueTwk().getValueSetting();
        int twk = 5;
        List<SoalEntity>soalListTwk =service.getSoalService().getAllSoalTWKActive();
        Random random =  new Random();

        int z=0;
        while ( z<twk){
            SoalEntity soalrandom = soalListTwk.get(random.nextInt(soalListTwk.size()));
            List<UjianEntity> nulable = findAllByUjianAndSoal(namaUjian,soalrandom.getId());
            if(nulable.size()==0){
                UjianSoalEntity use = new UjianSoalEntity();
                use.setUjianEntity(service.getUjianService().getUjianByNameUjian(namaUjian));
                use.setSoalEntity(soalrandom);
                repo.getUjianSoalRepository().save(use);
                z++;
            }
        }
    }
    private void GetSoalTIURandom(String namaUjian){

        int tiu = service.getUjianSettingService().getValueTIU().getValueSetting();
        List<SoalEntity>soalListTIU =service.getSoalService().getAllSoalTIUActive();
        Random random =  new Random();
        int z=0;
        while ( z<tiu){
            SoalEntity soalrandom = soalListTIU.get(random.nextInt(soalListTIU.size()));
            List<UjianEntity> nulable = findAllByUjianAndSoal(namaUjian,soalrandom.getId());
            if(nulable.size()==0){
                UjianSoalEntity use = new UjianSoalEntity();
                use.setUjianEntity(service.getUjianService().getUjianByNameUjian(namaUjian));
                use.setSoalEntity(soalrandom);
                repo.getUjianSoalRepository().save(use);
                z++;
            }
        }
    }
    private void GetSoalTKPRandom(String namaUjian){

        int tkp = service.getUjianSettingService().getValueTKP().getValueSetting();
        List<SoalEntity>soalListTkp =service.getSoalService().getAllSoalTKPActive();
        Random random =  new Random();
        int z=0;
        while ( z<tkp){
            SoalEntity soalrandom = soalListTkp.get(random.nextInt(soalListTkp.size()));
            List<UjianEntity> nulable = findAllByUjianAndSoal(namaUjian,soalrandom.getId());
            if(nulable.size()==0){
                UjianSoalEntity use = new UjianSoalEntity();
                use.setUjianEntity(service.getUjianService().getUjianByNameUjian(namaUjian));
                use.setSoalEntity(soalrandom);
                repo.getUjianSoalRepository().save(use);
                z++;
            }
        }
    }
}
