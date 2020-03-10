package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.SoalEntity;
import com.catdemo.demo.entity.UjianEntity;
import com.catdemo.demo.entity.UjianSoalEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.factory.ServiceFac;
import com.catdemo.demo.payload.request.UjianRequest;
import com.catdemo.demo.payload.request.UjianSettingRequest;
import com.catdemo.demo.service.UjianService;
import com.catdemo.demo.util.constants.UjianConstant;
import com.catdemo.demo.util.constants.UjianSettingConstant;
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
    public UjianEntity getUjianById(UUID id) {
        return null;
    }

    @Override
    public void SaveUjian(UjianRequest request) throws Exception {

        try {

            UjianEntity ujians = new UjianEntity();
            ujians.setNamaUjian(request.getNamaUjian());
            ujians.setAktorEntity(service.getAktorService().getAktorById(request.getIdAktorEntity()));
            GetSoalTwkRandom(request.getNamaUjian());
//            GetSoalTKPRandom(request.getNamaUjian());
//            GetSoalTIURandom(request.getNamaUjian());
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


    private void GetSoalTwkRandom(String namaUjian){

        int twk = 5;
        List<UUID> uuidtampung =new ArrayList<>();
        List<SoalEntity>soalListTwk =service.getSoalService().getAllSoalTWKActive();
        int temp = 0;
        Random random =  new Random();
        for(int z = 0; twk ==uuidtampung.size();z++ ){
            SoalEntity soalrandom = soalListTwk.get(random.nextInt(soalListTwk.size()));

                for (int l =0;l== uuidtampung.size();l++){
                    if(soalrandom.getId().equals(uuidtampung.get(l))){
                        temp=+1;
                    }
                }
                if (temp==0){
                    uuidtampung.add(soalrandom.getId());
                    UjianSoalEntity use = new UjianSoalEntity();
                    use.setUjianEntity(service.getUjianService().getUjianByNameUjian(namaUjian));
                    use.setSoalEntity(soalrandom);
                    repo.getUjianSoalRepository().save(use);
                }
                temp = 0;
        }
    }
    private void GetSoalTIURandom(String namaUjian){

        int twk = service.getUjianSettingService().getValueTIU().getValueSetting();
        List<UUID> uuidtampung =new ArrayList<>();
        List<SoalEntity>soalListTIU =service.getSoalService().getAllSoalTIUActive();
        int temp = 0;
        Random random =  new Random();
        for(int z = 0; twk ==uuidtampung.size();z++ ){
            SoalEntity soalrandom = soalListTIU.get(random.nextInt(soalListTIU.size()));

            for (int l =0;l== uuidtampung.size();l++){
                if(soalrandom.getId().equals(uuidtampung.get(l))){
                    temp=+1;
                }
            }
            if (temp==0){
                uuidtampung.add(soalrandom.getId());
                UjianSoalEntity use = new UjianSoalEntity();
                use.setUjianEntity(service.getUjianService().getUjianByNameUjian(namaUjian));
                use.setSoalEntity(soalrandom);
                repo.getUjianSoalRepository().save(use);
            }
            temp = 0;
        }
    }
    private void GetSoalTKPRandom(String namaUjian){

        int twk = service.getUjianSettingService().getValueTKP().getValueSetting();
        List<UUID> uuidtampung =new ArrayList<>();
        List<SoalEntity>soalListTkp =service.getSoalService().getAllSoalTKPActive();
        int temp = 0;
        Random random =  new Random();
        for(int z = 0; twk ==uuidtampung.size();z++ ){
            SoalEntity soalrandom = soalListTkp.get(random.nextInt(soalListTkp.size()));

            for (int l =0;l== uuidtampung.size();l++){
                if(soalrandom.getId().equals(uuidtampung.get(l))){
                    temp=+1;
                }
            }
            if (temp==0){
                uuidtampung.add(soalrandom.getId());
                UjianSoalEntity use = new UjianSoalEntity();
                use.setUjianEntity(service.getUjianService().getUjianByNameUjian(namaUjian));
                use.setSoalEntity(soalrandom);
                repo.getUjianSoalRepository().save(use);
            }
            temp = 0;
        }
    }
}
