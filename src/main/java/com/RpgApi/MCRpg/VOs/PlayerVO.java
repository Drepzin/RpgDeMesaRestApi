package com.RpgApi.MCRpg.VOs;

import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.Service.Impl.PlayerServiceImpl;

import java.util.Objects;


public class PlayerVO {

    private String name;

    private int level;

    private String rpgClass;

    public PlayerVO(){}

    public PlayerVO(RpgPlayer player){
        this.name = player.getName();
        this.level = player.getLevel();
        this.rpgClass = player.getRpgClass().getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRpgClass() {
        return rpgClass;
    }

    public void setRpgClass(String rpgClass) {
        this.rpgClass = rpgClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerVO playerVO = (PlayerVO) o;
        return level == playerVO.level && Objects.equals(name, playerVO.name) && Objects.equals(rpgClass, playerVO.rpgClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, rpgClass);
    }

    @Override
    public String toString() {
        return "PlayerVO{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", rpgClass='" + rpgClass + '\'' +
                '}';
    }
}
