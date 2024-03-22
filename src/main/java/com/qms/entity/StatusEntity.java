package com.qms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "status")
public class StatusEntity {

    @Id
    @Column(name="status_id")
    private String statusId;

    @Column(name="status_name")
    private String statusName;

}
