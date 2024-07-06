package com.RpgApi.MCRpg.Controllers;

import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.Service.Impl.PlayerServiceImpl;
import com.RpgApi.MCRpg.VOs.PlayerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Players")
public class PlayerController {

    @Autowired
    PlayerServiceImpl playerService;

    @PostMapping("/createAPlayer")
    public ResponseEntity<PlayerVO> createPlayer(@RequestBody RpgPlayer rpgPlayer){
        RpgPlayer player = playerService.addPlayer(rpgPlayer);
        return new ResponseEntity<>(new PlayerVO(player), HttpStatusCode.valueOf(201));
    }

    @GetMapping("/find_Player/{id}")
    public ResponseEntity<PlayerVO> findPlayer(@PathVariable(name = "id") Long id){
        RpgPlayer player = playerService.finbById(id);
        return new ResponseEntity<>(new PlayerVO(player), HttpStatusCode.valueOf(200));
    }

   /* @PatchMapping("/atualizar/{id}")
    public ResponseEntity<>*/
}
