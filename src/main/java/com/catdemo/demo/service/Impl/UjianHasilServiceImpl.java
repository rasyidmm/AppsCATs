package com.catdemo.demo.service.Impl;

import com.catdemo.demo.entity.AktorJawabanEntity;
import com.catdemo.demo.entity.UjianHasilEntity;
import com.catdemo.demo.factory.RepositoryFac;
import com.catdemo.demo.service.UjianHasilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UjianHasilServiceImpl implements UjianHasilService {
    @Autowired
    RepositoryFac repo;
    @Override
    public UjianHasilEntity getHasilUjianByIdUjian(UUID idUjian) {
       UjianHasilEntity aek = repo.getUjianHasilRepository().findAllByUjianEntityId(idUjian);
        if(aek==null){
            try {
                Long NilaiTolal=0L;
                UjianHasilEntity uhe=new UjianHasilEntity();
                List<AktorJawabanEntity> aje = repo.getAktorJawabanRepository().findAllByUjianEntityId(idUjian);
                for(AktorJawabanEntity item : aje){
                    NilaiTolal=NilaiTolal+item.getSkor();
                    uhe.setAktorEntity(item.getAktorEntity());
                    uhe.setUjianEntity(item.getUjianEntity());
                }
                uhe.setHasil(NilaiTolal);
                repo.getUjianHasilRepository().save(uhe);
            }catch (Exception e){
                e.getMessage();
            }
        }
        UjianHasilEntity ae = repo.getUjianHasilRepository().findAllByUjianEntityId(idUjian);
        return ae;
    }
}
