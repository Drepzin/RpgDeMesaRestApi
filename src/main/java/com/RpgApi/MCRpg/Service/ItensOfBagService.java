package com.RpgApi.MCRpg.Service;

import com.RpgApi.MCRpg.Models.ItensOfBag;
import com.RpgApi.MCRpg.Models.RpgItem;
import com.RpgApi.MCRpg.VOs.ItemBagVO;
import com.RpgApi.MCRpg.VOs.ItemVo;

import java.util.List;

public interface ItensOfBagService {

    String addItem(ItemBagVO itemBagVO);

    void deleteItemFromBag(ItemBagVO itemBagVO);

    ItemVo findById(Long item, Long bag);

    List<ItemVo> findAllByBag(Long id);
}
