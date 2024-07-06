package com.RpgApi.MCRpg.Controllers;

import com.RpgApi.MCRpg.Models.RpgClass;
import com.RpgApi.MCRpg.Service.RpgClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("rpg_class")
public class ClassController {

    @Autowired
    RpgClassService rcs;

    @PostMapping("/add_class")
    public ResponseEntity<RpgClass> addClass(@RequestBody RpgClass rpgClass){
        return new ResponseEntity<>(rcs.addRpgClass(rpgClass), HttpStatusCode.valueOf(201));
    }
}
