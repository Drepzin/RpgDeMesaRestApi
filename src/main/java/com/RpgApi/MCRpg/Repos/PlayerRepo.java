package com.RpgApi.MCRpg.Repos;

import com.RpgApi.MCRpg.Models.RpgPlayer;
import com.RpgApi.MCRpg.VOs.ItemBagVO;
import com.RpgApi.MCRpg.VOs.ItemVo;
import com.RpgApi.MCRpg.VOs.PlayerVO;
import com.RpgApi.MCRpg.VOs.projections.PlayerProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PlayerRepo extends JpaRepository<RpgPlayer, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO itens_of_bag (quantity, player_bag_id, item_id) VALUES(:#{#vo.quantity}," +
            " :#{#vo.bagId}, :#{#vo.itemId})",
    nativeQuery = true)
    public void insertItem(@Param("vo") ItemBagVO vo);


    @Query(value = "SELECT agility, hp, intelligence,level, j.name, race, strength, bag_id,\n" +
            "c.name FROM players j \n" +
            "JOIN classes c ON j.player_class = c.id\n" +
            "WHERE j.name LIKE %:name%", nativeQuery = true)
    public List<PlayerProjection> foundPlayers(@Param("name") String name);

}
