package com.RpgApi.MCRpg.Service;

import com.RpgApi.MCRpg.Models.PlayerBag;

import java.util.List;

public interface BagService {

    PlayerBag addABag(PlayerBag playerBag);

    PlayerBag findBagById(Long id);

    List<PlayerBag> findAllBags();

    PlayerBag updateBag(PlayerBag playerBag);

    void deleteBag(Long id);

}
