package com.qms.entity;

import jakarta.persistence.*;
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

    @Column(name="queue_price")
    private String queuePrice;

    @Column(name="queue_timeout")
    private String queueTimeOut;

    @Column(name="employee_id")
    private String employeeId;

    @Column(name="status_id")
    private String statusId;

    @Column(name="service_id")
    private String serviceId;

    @Column(name="shop_id")
    private String shopId;

}
