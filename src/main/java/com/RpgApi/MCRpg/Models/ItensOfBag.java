package com.RpgApi.MCRpg.Models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "itens_of_bag")
public class ItensOfBag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PlayerBag playerBag;

    @ManyToOne
    private RpgItens rpgItens;

    private int quantity;

    public ItensOfBag(){}

    public ItensOfBag(PlayerBag playerBag, RpgItens rpgItens, int quantity) {
        this.playerBag = playerBag;
        this.rpgItens = rpgItens;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerBag getPlayerBag() {
        return playerBag;
    }

    public void setPlayerBag(PlayerBag playerBag) {
        this.playerBag = playerBag;
    }

    public RpgItens getRpgItens() {
        return rpgItens;
    }

    public void setRpgItens(RpgItens rpgItens) {
        this.rpgItens = rpgItens;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItensOfBag that = (ItensOfBag) o;
        return quantity == that.quantity && Objects.equals(id, that.id) && Objects.equals(playerBag, that.playerBag) &&
                Objects.equals(rpgItens, that.rpgItens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerBag, rpgItens, quantity);
    }
}
