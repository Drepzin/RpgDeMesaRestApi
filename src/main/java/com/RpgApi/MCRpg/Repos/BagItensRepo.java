package com.RpgApi.MCRpg.Repos;

import com.RpgApi.MCRpg.Models.ItensOfBag;
import com.RpgApi.MCRpg.Models.RpgItem;
import com.RpgApi.MCRpg.VOs.ItemBagVO;
import com.RpgApi.MCRpg.VOs.projections.ItemProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface BagItensRepo extends JpaRepository<ItensOfBag, Long> {

    @Transactional
    @Query(value = "SELECT id, quantity, player_bag_id, item_id\n" +
            "\tFROM public.itens_of_bag WHERE player_bag_id = :#{#vo.bagId} AND item_id = :#{#vo.itemId}",
            nativeQuery = true)
    public Optional<ItensOfBag> foundSameItems(@Param("vo") ItemBagVO itemBagVO);


    @Modifying
    @Transactional
    @Query(value = "UPDATE itens_of_bag SET quantity = :#{#vo.quantity} WHERE" +
            " player_bag_id = :#{#vo.bagId} AND item_id = :#{#vo.itemId}",
            nativeQuery = true)
    public int updateQuantity(@Param("vo") ItemBagVO itemBagVO);


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM itens_of_bag WHERE player_bag_id = :#{#vo.bagId} AND item_id = :#{#vo.itemId}",
            nativeQuery = true)
    public void deleteIdByVo(@Param("vo") ItemBagVO vo);


    @Query(value ="SELECT rpg_itens.arcane_power, rpg_itens.damage," +
            " rpg_itens.description, rpg_itens.hability, rpg_itens.health," +
            " rpg_itens.name, rpg_itens.rarity from itens_of_bag ib" +
            " JOIN rpg_itens ON ib.item_id = rpg_itens.id" +
            " JOIN players ON ib.player_bag_id = :id", nativeQuery = true)
    public List<ItemProjection> findAllPlayerItems(@Param("id") int id);
}