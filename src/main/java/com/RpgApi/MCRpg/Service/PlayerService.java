package com.RpgApi.MCRpg.Service;

import com.RpgApi.MCRpg.Models.PlayerBag;
import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.List;

public interface PlayerService {

    RpgPlayer addPlayer(RpgPlayer rpgPlayer);

    void deletePlayerById(Long id);

    RpgPlayer finbById(Long id);

    List<RpgPlayer> findAll();

    RpgPlayer updateById(Long id, RpgPlayer rpgPlayer) throws JsonMappingException;
}
