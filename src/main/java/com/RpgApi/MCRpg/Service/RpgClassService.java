package com.RpgApi.MCRpg.Service;

import com.RpgApi.MCRpg.Models.RpgClass;

import java.util.List;

public interface RpgClassService {

    RpgClass addRpgClass(RpgClass rpgClass);

    RpgClass findById(String id);

    List<RpgClass> findAll();

    void deleteById(String id);


}
