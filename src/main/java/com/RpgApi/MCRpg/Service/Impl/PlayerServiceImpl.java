package com.RpgApi.MCRpg.Service.Impl;

import com.RpgApi.MCRpg.CustomExceptions.NotFoundException;
import com.RpgApi.MCRpg.Mappers.PlayerMapperImpl;
import com.RpgApi.MCRpg.Models.RpgClass;
import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.Repos.PlayerRepo;
import com.RpgApi.MCRpg.Repos.RpgClassRepo;
import com.RpgApi.MCRpg.Service.PlayerService;
import com.RpgApi.MCRpg.VOs.PlayerVO;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    RpgClassRepo rcp;

    PlayerMapperImpl pmi = new PlayerMapperImpl();

    @Autowired
    private PlayerRepo playerRepo;

    @Override
    public RpgPlayer addPlayer(RpgPlayer rpgPlayer) {
        RpgClass rpgClass = rpgPlayer.getRpgClass();
        Optional<RpgClass> optClass = rcp.findById(rpgClass.getId());
        if(optClass.isPresent()){
            rpgPlayer.setRpgClass(optClass.get());
            return playerRepo.save(rpgPlayer);
        }
        else {
            throw new NotFoundException("Classe não encontrada!");
        }
    }

    @Override
    public void deletePlayerById(Long id) {
        RpgPlayer rpgPlayer = playerRepo.findById(id).orElseThrow(() -> new NotFoundException("Id invalido"));
        playerRepo.deleteById(rpgPlayer.getId());
    }

    @Override
    public RpgPlayer findById(Long id) {
       Optional<RpgPlayer> optionalRpgPlayer = playerRepo.findById(id);
       if(optionalRpgPlayer.isPresent()){
           return optionalRpgPlayer.get();
       }
       else {
           throw new NotFoundException("Id invalido!, jogador não encontrado");
       }
    }

    @Override
    public List<RpgPlayer> findAll() {
        return playerRepo.findAll();
    }

    @Override
    public List<PlayerVO> findAllPlayerVo() {
        List<RpgPlayer> players = findAll();
        return players.stream().map(player -> pmi.playerToVo(player)).toList();
    }

    @Override
    public RpgPlayer updateById(Long id, PlayerVO playerVO) throws JsonMappingException {
        RpgPlayer oldPlayer = findById(id);
        if(playerVO.getRace() != null){
            oldPlayer.setRace(playerVO.getRace());
        }
        if(playerVO.getName() != null){
            oldPlayer.setName(playerVO.getName());
        }
        if(playerVO.getAgility() != null){
            oldPlayer.setAgility(playerVO.getAgility());
        }
        if(playerVO.getHp() != null){
            oldPlayer.setHp(playerVO.getHp());
        }
        if(playerVO.getIntelligence() != null){
            oldPlayer.setIntelligence(playerVO.getIntelligence());
        }
        if(playerVO.getStrength() != null){
            oldPlayer.setStrength(playerVO.getStrength());
        }
        if(playerVO.getLevel() != null){
            oldPlayer.setLevel(oldPlayer.getLevel());
        }
        return oldPlayer;
    }
}
