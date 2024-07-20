package com.RpgApi.MCRpg.Service.Impl;

import com.RpgApi.MCRpg.CustomExceptions.NotFoundException;
import com.RpgApi.MCRpg.Mappers.ItemMapperImpl;
import com.RpgApi.MCRpg.Models.ItensOfBag;
import com.RpgApi.MCRpg.Models.PlayerBag;
import com.RpgApi.MCRpg.Models.RpgItem;
import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.Repos.BagItensRepo;
import com.RpgApi.MCRpg.Repos.ItemRepo;
import com.RpgApi.MCRpg.Repos.PlayerRepo;
import com.RpgApi.MCRpg.Service.ItensOfBagService;
import com.RpgApi.MCRpg.VOs.ItemBagVO;
import com.RpgApi.MCRpg.VOs.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItensBagServiceImpl implements ItensOfBagService {

    @Autowired
    BagItensRepo bir;

    @Autowired
    ItemRepo itr;

    @Autowired
    PlayerRepo plr;

    ItemMapperImpl imp = new ItemMapperImpl();

    @Override
    public String addItem(ItemBagVO itemBagVO) {
        Optional<RpgItem> optItem = itr.findById(itemBagVO.getItemId());
        Optional<RpgPlayer> optionalRpgPlayer = plr.findById(itemBagVO.getBagId());
        if(optionalRpgPlayer.isPresent() && optItem.isPresent()){
            PlayerBag playerBag = optionalRpgPlayer.get().getPlayerBag();
            RpgItem rpgItem = optItem.get();
            Optional<ItensOfBag> optIb = findSameItem(itemBagVO);
            if(optIb.isEmpty()){
                bir.save(
                        new ItensOfBag(playerBag, rpgItem, itemBagVO.getQuantity())
                );
                return "Item: " + rpgItem.getName() + " add in the bag of: " +
                        optionalRpgPlayer.get().getName();
            }
            bir.updateQuantity(itemBagVO);
            return "Quantity: " + itemBagVO.getQuantity() + " add to player: " + optionalRpgPlayer.get().getName();
        }
        else{
            throw new NotFoundException("items or players not found");
        }
    }

    @Override
    public void deleteItemFromBag(ItemBagVO itemBagVO) {
        bir.deleteIdByVo(itemBagVO);
    }

    @Override
    public ItemVo findById(Long item, Long bag) {
        return null;
    }

    @Override
    public List<ItemVo> findAllByBag(Long id) {
        return List.of();
    }

    public Optional<ItensOfBag> findSameItem(ItemBagVO itemBagVO){
        return bir.foundSameItems(itemBagVO);
    }

}
