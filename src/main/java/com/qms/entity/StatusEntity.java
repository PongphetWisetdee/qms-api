package com.qms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "status")
public class StatusEntity {

    @Id
    @Column(name="status_id")
    private String statusId;

    @Column(name="status_name")
    private String statusName;

    @Column(name="status_shop")
    private String statusShop;

}
