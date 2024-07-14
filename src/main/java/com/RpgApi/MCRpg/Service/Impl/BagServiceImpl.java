package com.RpgApi.MCRpg.Service.Impl;

import com.RpgApi.MCRpg.CustomExceptions.NotFoundException;
import com.RpgApi.MCRpg.Models.PlayerBag;
import com.RpgApi.MCRpg.Repos.PlayerBagRepo;
import com.RpgApi.MCRpg.Service.BagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BagServiceImpl implements BagService {

    @Autowired
    private PlayerBagRepo pbr;

    @Override
    public PlayerBag addABag(PlayerBag playerBag) {
        return pbr.save(playerBag);
    }

    @Override
    public PlayerBag findBagById(Long id) {
        Optional<PlayerBag> optPlayerBag = pbr.findById(id);
        if(optPlayerBag.isPresent()){
            return optPlayerBag.get();
        }
        else {
            throw new NotFoundException("Player bag not found, pls check the id");
        }
    }

    @Override
    public List<PlayerBag> findAllBags() {
        return List.of();
    }

    @Override
    public PlayerBag updateBag(PlayerBag playerBag) {
        return null;
    }

    @Override
    public void deleteBag(Long id) {

    }
}
