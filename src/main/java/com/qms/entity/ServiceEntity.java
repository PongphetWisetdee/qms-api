package com.qms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "service")
public class ServiceEntity {

    @Id
    @Column(name="service_id")
    private String serviceId;

    @Column(name="service_nameth")
    private String serviceNameTH;

    @Column(name="service_nameen")
    private String serviceNameEN;

    @Column(name="service_time")
    private String serviceTime;

    @Column(name="service_price")
    private String servicePrice;

    @Column(name="shop_id")
    private String shopId;

}
