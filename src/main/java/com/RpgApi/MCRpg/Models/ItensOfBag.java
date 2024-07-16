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
    @JoinColumn(name = "player_bag_id")
    private PlayerBag playerBag;

    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private RpgItem rpgItem;

    private int quantity;

    public ItensOfBag(){}

    public ItensOfBag(PlayerBag playerBag, RpgItem rpgItem, int quantity) {
        this.playerBag = playerBag;
        this.rpgItem = rpgItem;
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

    public RpgItem getRpgItens() {
        return rpgItem;
    }

    public void setRpgItens(RpgItem rpgItem) {
        this.rpgItem = rpgItem;
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
                Objects.equals(rpgItem, that.rpgItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, playerBag, rpgItem, quantity);
    }

    @Override
    public String toString() {
        return "ItensOfBag{" +
                "id=" + id +
                ", playerBag=" + playerBag +
                ", rpgItem=" + rpgItem +
                ", quantity=" + quantity +
                '}';
    }
}
