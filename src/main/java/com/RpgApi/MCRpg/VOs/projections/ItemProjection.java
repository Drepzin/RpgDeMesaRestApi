package com.RpgApi.MCRpg.VOs.projections;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface ItemProjection {

    String getName();

    String getDescription();

    String getRarity();

    int getDamage();

    int getHealth();

    int getArcanePower();

    String getHability();

}
