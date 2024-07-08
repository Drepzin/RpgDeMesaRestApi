package com.RpgApi.MCRpg.Service.Impl;

import com.RpgApi.MCRpg.CustomExceptions.RpgClassInvalidException;
import com.RpgApi.MCRpg.Models.RpgClass;
import com.RpgApi.MCRpg.Repos.RpgClassRepo;
import com.RpgApi.MCRpg.Service.RpgClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RpgClassServiceImpl implements RpgClassService {

    @Autowired
    private RpgClassRepo rcp;

    @Override
    public RpgClass addRpgClass(RpgClass rpgClass) {
        if (rpgClass.getPrincipalStat() == null |
                rpgClass.getFunction() == null |
                rpgClass.getName() == null){

            throw new RpgClassInvalidException("Classe invalida, cheque os parametros!");
        }
        return rcp.save(rpgClass);
    }

    @Override
    public RpgClass findById(String id) {
        Optional<RpgClass> oprc = rcp.findById(id);
        return oprc.orElse(null);
    }

    @Override
    public List<RpgClass> findAll() {
        return rcp.findAll();
    }

    @Override
    public void deleteById(String id) {
        rcp.deleteById(id);
    }
}
