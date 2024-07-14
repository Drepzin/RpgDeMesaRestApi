package com.RpgApi.MCRpg.Service;

import com.RpgApi.MCRpg.Models.RpgItem;

import java.util.List;

public interface ItemService {

    RpgItem addItem(RpgItem rpgItem);

    RpgItem updateItemById(Long id, RpgItem rpgItem);

    RpgItem findById(Long id);

    List<RpgItem> findByName(String name);

    List<RpgItem> findAll();

    void deleteById(Long id);


}
