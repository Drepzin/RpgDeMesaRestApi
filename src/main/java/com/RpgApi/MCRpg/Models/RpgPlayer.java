package com.RpgApi.MCRpg.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "jogadores")
public class RpgPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int level;

    @ManyToOne
    @JoinColumn(name = "player_class")
    private RpgClass rpgClass;

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
}
