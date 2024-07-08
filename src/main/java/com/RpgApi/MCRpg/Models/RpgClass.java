package com.RpgApi.MCRpg.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "classes")
public class RpgClass {

    @Id
    private String name;

    private String function;

    @Column(name = "principal_stat")
    @JsonProperty(namespace = "principal_stat")
    private String principalStat;

    public RpgClass(){}

    public RpgClass(String name, String principalStat, String function) {
        this.name = name;
        this.principalStat = principalStat;
        this.function = function;
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
    public String toString() {
        return "RpgClass{" +
                "name='" + name + '\'' +
                ", function='" + function + '\'' +
                ", principalStat='" + principalStat + '\'' +
                '}';
    }
}
