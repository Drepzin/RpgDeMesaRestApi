package com.RpgApi.MCRpg.VOs;

public class ItemBagVO {

    private Long bagId;

    private Long itemId;

    private int quantity;

    public ItemBagVO(){}

    public ItemBagVO(Long bagId, Long itemId, int quantity) {
        this.bagId = bagId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Long getBagId() {
        return bagId;
    }

    public void setBagId(Long bagId) {
        this.bagId = bagId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ItemBagVO{" +
                "bagId=" + bagId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                '}';
    }
}
