package com.RpgApi.MCRpg.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "players_bags")
public class PlayerBag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int gold;
    
}
