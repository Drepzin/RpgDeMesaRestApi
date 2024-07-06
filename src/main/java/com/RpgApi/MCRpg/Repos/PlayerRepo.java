package com.RpgApi.MCRpg.Repos;

import com.RpgApi.MCRpg.Models.RpgPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<RpgPlayer, Long> {
}
