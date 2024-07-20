package com.RpgApi.MCRpg.Controllers;

import com.RpgApi.MCRpg.Mappers.PlayerMapperImpl;
import com.RpgApi.MCRpg.Models.ItensOfBag;
import com.RpgApi.MCRpg.Models.RpgItem;
import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.Repos.BagItensRepo;
import com.RpgApi.MCRpg.Service.Impl.ItensBagServiceImpl;
import com.RpgApi.MCRpg.Service.Impl.PlayerServiceImpl;
import com.RpgApi.MCRpg.VOs.ItemBagVO;
import com.RpgApi.MCRpg.VOs.ItemVo;
import com.RpgApi.MCRpg.VOs.PlayerVO;
import com.RpgApi.MCRpg.VOs.projections.ItemProjection;
import com.RpgApi.MCRpg.VOs.projections.PlayerProjection;
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

    @Autowired
    BagItensRepo bir;

    @Autowired
    ItensBagServiceImpl ibs;

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

    @PatchMapping("/update/{id}")
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

    @PostMapping("/add_item")
    public ResponseEntity<String> addItem(@RequestBody ItemBagVO itemBagVO){
        return new ResponseEntity<>(ibs.addItem(itemBagVO),HttpStatusCode.valueOf(201));
    }

    @DeleteMapping("/delete_item")
    public ResponseEntity<String> deleteItem(@RequestBody ItemBagVO itemBagVO){
        ibs.deleteItemFromBag(itemBagVO);
        return new ResponseEntity<>("Deleted", HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find_player_items/{id}")
    public ResponseEntity<List<ItemProjection>> findPlayerItems(@PathVariable(name = "id") int id){
        return new ResponseEntity<>(bir.findAllPlayerItems(id), HttpStatusCode.valueOf(200));
    }

    @GetMapping("/find_player_name/{name}")
    public ResponseEntity<List<PlayerProjection>> findPlayerName(@PathVariable(name = "name") String name){
        return new ResponseEntity<>(playerService.findPlayersName(name), HttpStatusCode.valueOf(200));
    }

}
