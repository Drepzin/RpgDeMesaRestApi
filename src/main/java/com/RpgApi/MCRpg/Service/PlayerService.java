package com.RpgApi.MCRpg.Service;

import com.RpgApi.MCRpg.Models.PlayerBag;
import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.VOs.PlayerVO;
import com.fasterxml.jackson.databind.JsonMappingException;

import java.util.List;

public interface PlayerService {

    RpgPlayer addPlayer(RpgPlayer rpgPlayer);

    void deletePlayerById(Long id);

    RpgPlayer findById(Long id);

    List<RpgPlayer> findAll();

    List<PlayerVO> findAllPlayerVo();

    RpgPlayer updateById(Long id, PlayerVO playerVO) throws JsonMappingException;
}
