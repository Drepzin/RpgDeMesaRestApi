package com.RpgApi.MCRpg.VOs.projections;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface PlayerProjection {

    String getName();

    Integer getLevel();

    String getRpgClass();

    String getRace();

    Integer getHp();

    Integer getStrength();

    Integer getAgility();

    Integer getIntelligence();

    Integer getGold();
}
