package com.qms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "shop")
public class ShopEntity {

    @Id
    @Column(name="shop_id")
    private String shopId;

    @Column(name="shop_name")
    private String shopName;

    @Column(name="shop_open")
    private String shopOpen;

    @Column(name="shop_close")
    private String shopClose;

    @Column(name="shop_dayoff")
    private String shopDayOff;
}
