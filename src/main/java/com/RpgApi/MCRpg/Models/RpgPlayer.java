package com.RpgApi.MCRpg.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "players")
public class RpgPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int level;

    private String race;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_class", referencedColumnName = "id")
    private RpgClass rpgClass;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bag_id", referencedColumnName = "id")
    private PlayerBag playerBag;

    private int hp;

    private int strength;

    private int agility;

    private int intelligence;

    public RpgPlayer() {
    }

    public RpgPlayer(Long id, int intelligence, int strength, int hp,
                     RpgClass rpgClass, String race, int level,
                     String name, PlayerBag playerBag, int agility) {
        this.id = id;
        this.intelligence = intelligence;
        this.strength = strength;
        this.hp = hp;
        this.rpgClass = rpgClass;
        this.race = race;
        this.level = level;
        this.name = name;
        this.playerBag = playerBag;
        this.agility = agility;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public PlayerBag getPlayerBag() {
        return playerBag;
    }

    public void setPlayerBag(PlayerBag playerBag) {
        this.playerBag = playerBag;
    }

    public RpgClass getRpgClass() {
        return rpgClass;
    }

    public void setRpgClass(RpgClass rpgClass) {
        this.rpgClass = rpgClass;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RpgPlayer rpgPlayer = (RpgPlayer) o;
        return level == rpgPlayer.level && hp == rpgPlayer.hp && strength ==
                rpgPlayer.strength && agility == rpgPlayer.agility && intelligence ==
                rpgPlayer.intelligence && Objects.equals(id, rpgPlayer.id)
                && Objects.equals(name, rpgPlayer.name) && Objects.equals(race, rpgPlayer.race)
                && Objects.equals(rpgClass, rpgPlayer.rpgClass) && Objects.equals(playerBag, rpgPlayer.playerBag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, level, race, rpgClass, playerBag, hp, strength, agility, intelligence);
    }

    @Override
    public String toString() {
        return "RpgPlayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", race='" + race + '\'' +
                ", rpgClass=" + rpgClass +
                ", playerBag=" + playerBag +
                ", hp=" + hp +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                '}';
    }
}
