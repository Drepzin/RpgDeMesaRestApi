package com.RpgApi.MCRpg.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "classes")
public class RpgClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private String function;

    @Column(name = "principal_stat")
    @JsonProperty(namespace = "principal_stat")
    private String principalStat;

    @OneToMany(mappedBy = "rpgClass", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<RpgPlayer> rpgPlayers;

    public RpgClass(){}

    public RpgClass(String name, String principalStat, String function) {
        this.name = name;
        this.principalStat = principalStat;
        this.function = function;
    }

    public Long getId() {
        return id;
    }

    public List<RpgPlayer> getRpgPlayers() {
        return rpgPlayers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RpgClass rpgClass = (RpgClass) o;
        return Objects.equals(id, rpgClass.id) && Objects.equals(name, rpgClass.name) && Objects.equals(function, rpgClass.function) && Objects.equals(principalStat, rpgClass.principalStat) && Objects.equals(rpgPlayers, rpgClass.rpgPlayers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, function, principalStat, rpgPlayers);
    }

    @Override
    public String toString() {
        return "RpgClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", function='" + function + '\'' +
                ", principalStat='" + principalStat + '\'' +
                '}';
    }
}
