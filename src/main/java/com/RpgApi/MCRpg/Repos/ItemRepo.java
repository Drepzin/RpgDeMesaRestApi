package com.RpgApi.MCRpg.Repos;

import com.RpgApi.MCRpg.Models.RpgItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<RpgItem, Long> {
}
