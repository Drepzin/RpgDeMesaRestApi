package com.RpgApi.MCRpg.Mappers;

import com.RpgApi.MCRpg.Models.RpgClass;
import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.VOs.PlayerVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PlayerMapper {

    @Mapping(source = "rpgClass.name", target = "rpgClass")
    public PlayerVO playerToVo(RpgPlayer rpgPlayer);
}
