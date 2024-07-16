package com.RpgApi.MCRpg.Service;

import com.RpgApi.MCRpg.Models.RpgItem;
import com.RpgApi.MCRpg.VOs.ItemVo;

import java.util.List;

public interface ItemService {

    ItemVo addItem(RpgItem rpgItem);

    ItemVo updateItemById(Long id, ItemVo itemVo);

    ItemVo findById(Long id);

    List<ItemVo> findByName(String name);

    List<ItemVo> findAll();

    void deleteById(Long id);


}
