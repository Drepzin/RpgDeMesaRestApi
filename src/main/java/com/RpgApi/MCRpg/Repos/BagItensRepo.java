package com.RpgApi.MCRpg.Repos;

import com.RpgApi.MCRpg.Models.ItensOfBag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BagItensRepo extends JpaRepository<ItensOfBag, Long> {
}
