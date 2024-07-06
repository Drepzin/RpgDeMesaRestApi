package com.RpgApi.MCRpg.Service.Impl;

import com.RpgApi.MCRpg.Models.RpgClass;
import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.Repos.PlayerRepo;
import com.RpgApi.MCRpg.Repos.RpgClassRepo;
import com.RpgApi.MCRpg.Service.PlayerService;
import com.RpgApi.MCRpg.Service.RpgClassService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    RpgClassRepo rcp;

    @Autowired
    ObjectMapper objm;

    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public RpgPlayer addPlayer(RpgPlayer rpgPlayer) {
        RpgClass rpgClass = rpgPlayer.getRpgClass();
        Optional<RpgClass> optClass = rcp.findById(rpgClass.getName());
        if(optClass.isPresent()){
            rpgPlayer.setRpgClass(optClass.get());
            return playerRepo.save(rpgPlayer);
        }
        return null;
    }

   /* RpgClass rpgClass = rpgPlayer.getRpgClass();
    Optional<RpgClass> optClass = rcp.findById(rpgClass.getName());
        if(optClass.isPresent()){
        return playerRepo.save(rpgPlayer);
    }
        else{
        if(rpgClass.getPrincipalStat() != null && rpgClass.getFunction() != null){
            rcp.save(rpgClass);
            return playerRepo.save(rpgPlayer);
        }
    }
        return null; */


    @Override
    public void deletePlayerById(Long id) {
        RpgPlayer rpgPlayer = finbById(id);
        playerRepo.delete(rpgPlayer);
    }

    @Override
    public RpgPlayer finbById(Long id) {
       Optional<RpgPlayer> optPlayer = playerRepo.findById(id);
       return optPlayer.orElseGet(() -> null);
    }

    @Override
    public List<RpgPlayer> findAll() {
        return playerRepo.findAll();
    }

    @Override
    public RpgPlayer updateById(Long id, RpgPlayer newRpgPlayer) throws JsonMappingException {
        RpgPlayer oldPlayer = finbById(id);
        return objm.updateValue(oldPlayer, newRpgPlayer);
    }
}
