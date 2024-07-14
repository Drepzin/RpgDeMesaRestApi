package com.RpgApi.MCRpg.Repos;

import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.VOs.PlayerVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepo extends JpaRepository<RpgPlayer, Long> {

}
