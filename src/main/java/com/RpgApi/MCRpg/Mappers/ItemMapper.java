package com.RpgApi.MCRpg.Mappers;

import com.RpgApi.MCRpg.Models.RpgItem;
import com.RpgApi.MCRpg.VOs.ItemVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ItemMapper {

    ItemVo itemToVo(RpgItem rpgItem);

    RpgItem voConverter(ItemVo itemVo, @MappingTarget RpgItem rpgItem);
}