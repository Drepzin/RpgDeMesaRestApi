package com.RpgApi.MCRpg.Controllers;

import com.RpgApi.MCRpg.Models.PlayerBag;
import com.RpgApi.MCRpg.Service.Impl.BagServiceImpl;
import com.RpgApi.MCRpg.Service.Impl.PlayerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player_bag")
public class PlayerBagController {

    @Autowired
    private BagServiceImpl bsi;


    @PostMapping("/add_bag")
    public ResponseEntity<PlayerBag> addBag(@RequestBody PlayerBag playerBag){
        return new ResponseEntity<>(bsi.addABag(playerBag), HttpStatusCode.valueOf(201));
    }
}
