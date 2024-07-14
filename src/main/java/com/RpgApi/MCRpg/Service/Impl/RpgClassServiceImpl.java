package com.RpgApi.MCRpg.Service.Impl;

import com.RpgApi.MCRpg.CustomExceptions.RpgClassExistentException;
import com.RpgApi.MCRpg.Models.RpgClass;
import com.RpgApi.MCRpg.Repos.RpgClassRepo;
import com.RpgApi.MCRpg.Service.RpgClassService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RpgClassServiceImpl implements RpgClassService {

    @Autowired
    private RpgClassRepo rcp;

    @Autowired
    EntityManager em;

    @Override
    public RpgClass addRpgClass(RpgClass rpgClass) {
        return rcp.save(rpgClass);
    }

    @Override
    public RpgClass findById(Long id) {
        Optional<RpgClass> oprc = rcp.findById(id);
        return oprc.orElse(null);
    }

    @Override
    public List<RpgClass> findAll() {
        return rcp.findAll();
    }

    @Override
    public void deleteById(Long id) {
        rcp.deleteById(id);
    }

}
