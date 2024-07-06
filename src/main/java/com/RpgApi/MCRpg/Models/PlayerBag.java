package com.RpgApi.MCRpg.Models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "players_bags")
public class PlayerBag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int gold;

    @OneToOne(mappedBy = "playerBag")
    private RpgPlayer rpgPlayer;

    public PlayerBag() {}

    public PlayerBag(int gold) {
        this.gold = gold;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerBag playerBag = (PlayerBag) o;
        return Objects.equals(id, playerBag.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "PlayerBag{" +
                "id=" + id +
                ", gold=" + gold +
                ", rpgPlayer=" + rpgPlayer +
                '}';
    }
}
