package com.RpgApi.MCRpg.Service.Impl;

import com.RpgApi.MCRpg.CustomExceptions.InvalidItemException;
import com.RpgApi.MCRpg.Models.RpgItem;
import com.RpgApi.MCRpg.Repos.ItensRepo;
import com.RpgApi.MCRpg.Service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemServiceImpl implements ItemService {

    @Autowired
    ItensRepo itensRepo;

    @Override
    public RpgItem addItem(RpgItem rpgItem) {
        if(rpgItem != null) {
            return itensRepo.save(rpgItem);
        }
        throw new InvalidItemException("Parametros invalidos!");
    }

    @Override
    public RpgItem updateItemById(Long id, RpgItem rpgItem) {
        return null;
    }

    @Override
    public RpgItem findById(Long id) {
        return null;
    }

    @Override
    public List<RpgItem> findByName(String name) {
        return List.of();
    }

    @Override
    public List<RpgItem> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(Long id) {

    }
}
