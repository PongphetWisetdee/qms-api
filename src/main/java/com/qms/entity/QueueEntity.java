package com.qms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.Date;

@Data
@Entity
@Table(name = "queue")
public class QueueEntity {

    @Id
    @Column(name="queue_id")
    private String queueId;

    @Column(name="queue_date", columnDefinition = "DATE")
    private Date queueDate;

    @Column(name="queue_time")
    private String queueTime;

    @Column(name="queue_status")
    private String queue_status;

    @Column(name="queue_service")
    private String queue_service;

    @Column(name="queue_price")
    private String queue_price;

    @Column(name="queue_shop")
    private String queue_shop;

    @Column(name="queue_employee")
    private String queue_employee;
}
