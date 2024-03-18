package com.qms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

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

    @Column(name="servicePrice")
    private String price;

    @Column(name="service_shop")
    private String serviceShop;

}
