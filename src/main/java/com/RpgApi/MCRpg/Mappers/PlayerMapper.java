package com.RpgApi.MCRpg.Mappers;

import com.RpgApi.MCRpg.Models.RpgClass;
import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.VOs.PlayerVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlayerMapper {

    @Mapping(source = "rpgClass.name", target = "rpgClass")
    @Mapping(source = "playerBag.gold", target = "gold")
    public PlayerVO playerToVo(RpgPlayer rpgPlayer);

    @Mapping(source = "rpgClass", target = "rpgClass.name")
    public RpgPlayer voToPlayer(PlayerVO playerVO);
}
