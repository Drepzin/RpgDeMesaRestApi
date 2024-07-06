package com.RpgApi.MCRpg.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "Rpg_itens")
public class RpgItem {

    @Id
    private String name;

    private String description;

    private String rarity;

    private int damage;

    private int health;

    private int arcanePower;

    private String hability;

    public RpgItem(){}

    public RpgItem(String name, String hability, int health, String description,
                   int damage, String rarity, int arcanePower) {
        this.name = name;
        this.hability = hability;
        this.health = health;
        this.description = description;
        this.damage = damage;
        this.rarity = rarity;
        this.arcanePower = arcanePower;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHability() {
        return hability;
    }

    public void setHability(String hability) {
        this.hability = hability;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getArcanePower() {
        return arcanePower;
    }

    public void setArcanePower(int arcanePower) {
        this.arcanePower = arcanePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RpgItem rpgItem = (RpgItem) o;
        return damage == rpgItem.damage && health == rpgItem.health && arcanePower == rpgItem.arcanePower && Objects.equals(name, rpgItem.name) && Objects.equals(description, rpgItem.description) && Objects.equals(rarity, rpgItem.rarity) && Objects.equals(hability, rpgItem.hability);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, rarity, damage, health, arcanePower, hability);
    }

    @Override
    public String toString() {
        return "RpgItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rarity='" + rarity + '\'' +
                ", damage=" + damage +
                ", health=" + health +
                ", arcanePower=" + arcanePower +
                ", hability='" + hability + '\'' +
                '}';
    }
}
