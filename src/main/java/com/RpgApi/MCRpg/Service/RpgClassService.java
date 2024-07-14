package com.RpgApi.MCRpg.Service;

import com.RpgApi.MCRpg.Models.RpgClass;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface RpgClassService {

    RpgClass addRpgClass(RpgClass rpgClass);

    RpgClass findById(Long id);

    List<RpgClass> findAll();

    void deleteById(Long id);

}
