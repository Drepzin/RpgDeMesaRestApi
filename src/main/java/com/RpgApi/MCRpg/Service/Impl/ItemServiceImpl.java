package com.RpgApi.MCRpg.Service.Impl;

import com.RpgApi.MCRpg.CustomExceptions.InvalidItemException;
import com.RpgApi.MCRpg.CustomExceptions.NotFoundException;
import com.RpgApi.MCRpg.Mappers.ItemMapperImpl;
import com.RpgApi.MCRpg.Models.RpgItem;
import com.RpgApi.MCRpg.Repos.ItemRepo;
import com.RpgApi.MCRpg.Service.ItemService;
import com.RpgApi.MCRpg.VOs.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepo itensRepo;

    ItemMapperImpl imp = new ItemMapperImpl();

    @Override
    public ItemVo addItem(RpgItem rpgItem) {
        if(rpgItem != null){
            return imp.itemToVo(
                    itensRepo.save(rpgItem)
            );
        }
        throw new InvalidItemException("invalid parameters null item");
    }

    @Override
    public ItemVo updateItemById(Long id, ItemVo itemVo){
        Optional<RpgItem> oldItem = itensRepo.findById(id);
        if(oldItem.isEmpty()){
            throw new NotFoundException("Item not found");
        }
        return imp.itemToVo(imp.voConverter(itemVo, oldItem.get()));
    }

    @Override
    public ItemVo findById(Long id) {
        Optional<RpgItem> optRpgItem = itensRepo.findById(id);
        if (optRpgItem.isEmpty()){
            throw new NotFoundException("Item not found");
        }
        return imp.itemToVo(optRpgItem.get());
    }

    @Override
    public List<ItemVo> findByName(String name) {
        return itensRepo.findAll().stream().map(RpgItem -> imp.itemToVo(RpgItem)).toList();
    }

    @Override
    public List<ItemVo> findAll() {
        return itensRepo.findAll().stream().map(imp::itemToVo).toList();
    }

    @Override
    public void deleteById(Long id) {
        RpgItem rpgItem = itensRepo.findById(id).orElseThrow(()->new NotFoundException("Item não encotrado"));
    }
}
