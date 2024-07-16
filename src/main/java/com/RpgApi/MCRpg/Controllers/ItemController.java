package com.RpgApi.MCRpg.Controllers;

import com.RpgApi.MCRpg.Mappers.ItemMapperImpl;
import com.RpgApi.MCRpg.Models.RpgItem;
import com.RpgApi.MCRpg.Service.Impl.ItemServiceImpl;
import com.RpgApi.MCRpg.VOs.ItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Item")
public class ItemController {

    @Autowired
    ItemServiceImpl itemService;

    ItemMapperImpl itemMapper = new ItemMapperImpl();

    @PostMapping("/create_item")
    public ResponseEntity<ItemVo> addItem(@RequestBody RpgItem rpgItem){
        return new ResponseEntity<>(itemService.addItem(rpgItem),
                HttpStatusCode.valueOf(201));
    }

    @PatchMapping("/update_item/{id}")
    public ResponseEntity<ItemVo> updateItem(@PathVariable(name = "id") Long id,
                                             @RequestBody ItemVo itemVo){
        return new ResponseEntity<>(itemService.updateItemById(id, itemVo),
                HttpStatusCode.valueOf(202));
    }

    @GetMapping("/find_all")
    public ResponseEntity<List<ItemVo>> findAllItem(){
        return new ResponseEntity<>(itemService.findAll(), HttpStatusCode.valueOf(200));
    }
}
