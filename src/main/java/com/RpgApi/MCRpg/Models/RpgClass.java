package com.RpgApi.MCRpg.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classes")
public class RpgClass {

    @Id
    private String name;

    private String function;

    @Column(name = "principal_stat")
    private String principalStat;

    @OneToMany(mappedBy = "rpgClass")
    private List<RpgPlayer> rpgPlayer;

    public RpgClass(){}

    public RpgClass(String name, String principalStat, List<RpgPlayer> rpgPlayer, String function) {
        this.name = name;
        this.principalStat = principalStat;
        this.rpgPlayer = rpgPlayer;
        this.function = function;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RpgPlayer> getRpgPlayer() {
        return rpgPlayer;
    }

    public void setRpgPlayer(List<RpgPlayer> rpgPlayer) {
        this.rpgPlayer = rpgPlayer;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getPrincipalStat() {
        return principalStat;
    }

    public void setPrincipalStat(String principalStat) {
        this.principalStat = principalStat;
    }
}
