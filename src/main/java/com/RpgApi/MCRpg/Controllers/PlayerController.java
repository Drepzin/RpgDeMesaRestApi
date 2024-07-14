package com.RpgApi.MCRpg.Controllers;

import com.RpgApi.MCRpg.Mappers.PlayerMapperImpl;
import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.Service.Impl.PlayerServiceImpl;
import com.RpgApi.MCRpg.VOs.PlayerVO;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Players")
public class PlayerController {

    @Autowired
    PlayerServiceImpl playerService;

    PlayerMapperImpl pmi = new PlayerMapperImpl();

    @PostMapping("/createAPlayer")
    public ResponseEntity<PlayerVO> createPlayer(@RequestBody RpgPlayer rpgPlayer){
        RpgPlayer player = playerService.addPlayer(rpgPlayer);
        return new ResponseEntity<>(pmi.playerToVo(rpgPlayer) , HttpStatusCode.valueOf(201));
    }

   @GetMapping("/find_player/{id}")
    public ResponseEntity<PlayerVO> findPlayer(@PathVariable(name = "id") Long id){
        RpgPlayer player = playerService.findById(id);
        return new ResponseEntity<>(pmi.playerToVo(player), HttpStatusCode.valueOf(200));
    }

    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<PlayerVO> attPlayer(@PathVariable(name = "id") Long id,
                                              @RequestBody PlayerVO playerVO) throws JsonMappingException {
        RpgPlayer player = playerService.updateById(id, playerVO);
        return new ResponseEntity<>(pmi.playerToVo(player), HttpStatusCode.valueOf(201));
    }

    @DeleteMapping("/delete_player/{id}")
    public void deletePlayer(@PathVariable(name = "id") Long id){
        playerService.deletePlayerById(id);
    }

    @GetMapping("/find_all_players")
    public ResponseEntity<List<PlayerVO>> findAllPlayers(){
        return new ResponseEntity<>(playerService.findAllPlayerVo(), HttpStatusCode.valueOf(200));
    }

}
