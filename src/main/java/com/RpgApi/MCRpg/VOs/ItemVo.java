package com.RpgApi.MCRpg.VOs;

public class ItemVo {

    private String name;

    private String description;

    private String rarity;

    private Integer damage;

    private Integer health;

    private Integer arcanePower;

    private String hability;

    public ItemVo(){}

    public ItemVo(String name, String hability, Integer arcanePower,
                  Integer health, Integer damage, String rarity, String description) {
        this.name = name;
        this.hability = hability;
        this.arcanePower = arcanePower;
        this.health = health;
        this.damage = damage;
        this.rarity = rarity;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArcanePower() {
        return arcanePower;
    }

    public void setArcanePower(Integer arcanePower) {
        this.arcanePower = arcanePower;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHability() {
        return hability;
    }

    public void setHability(String hability) {
        this.hability = hability;
    }

    @Override
    public String toString() {
        return "ItemVo{" +
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
