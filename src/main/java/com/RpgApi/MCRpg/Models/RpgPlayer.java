package com.RpgApi.MCRpg.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@JsonInclude(content = JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "jogadores")
public class RpgPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int level;

    @JsonProperty(value = "rpgClass")
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "player_class", referencedColumnName = "name")
    private RpgClass rpgClass;

    @OneToOne
    @JoinColumn(name = "bag_id", referencedColumnName = "id")
    private PlayerBag playerBag;

    public RpgPlayer() {
    }

    public RpgPlayer(RpgClass rpgClass, int level, String name) {
        this.rpgClass = rpgClass;
        this.level = level;
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RpgClass getRpgClass() {
        return rpgClass;
    }

    public void setRpgClass(RpgClass rpgClass) {
        this.rpgClass = rpgClass;
    }

    @Override
    public String toString() {
        return "RpgPlayer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", rpgClass=" + rpgClass +
                ", playerBag=" + playerBag +
                '}';
    }
}
