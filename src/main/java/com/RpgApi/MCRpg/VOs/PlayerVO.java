package com.RpgApi.MCRpg.VOs;

import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.Service.Impl.PlayerServiceImpl;

import java.util.Objects;


public class PlayerVO {

    private String name;

    private Integer level;

    private String rpgClass;

    private String race;

    private Integer hp;

    private Integer strength;

    private Integer agility;

    private Integer intelligence;

    private Integer gold;

    public PlayerVO(){}

    public PlayerVO(String name, Integer level, String race, Integer hp,
                    String rpgClass, Integer strength,
                    Integer agility, Integer intelligence, Integer gold) {
        this.name = name;
        this.level = level;
        this.race = race;
        this.hp = hp;
        this.rpgClass = rpgClass;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.gold = gold;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRpgClass() {
        return rpgClass;
    }

    public void setRpgClass(String rpgClass) {
        this.rpgClass = rpgClass;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public Integer getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerVO playerVO = (PlayerVO) o;
        return Objects.equals(name, playerVO.name) && Objects.equals(level, playerVO.level) && Objects.equals(rpgClass, playerVO.rpgClass) && Objects.equals(race, playerVO.race) && Objects.equals(hp, playerVO.hp) && Objects.equals(strength, playerVO.strength) && Objects.equals(agility, playerVO.agility) && Objects.equals(intelligence, playerVO.intelligence) && Objects.equals(gold, playerVO.gold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, rpgClass, race, hp, strength, agility, intelligence, gold);
    }

    @Override
    public String toString() {
        return "PlayerVO{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", rpgClass='" + rpgClass + '\'' +
                ", race='" + race + '\'' +
                ", hp=" + hp +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                '}';
    }
}
