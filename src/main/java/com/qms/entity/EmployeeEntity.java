package com.qms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @Column(name="employee_id")
    private String employeeId;

    @Column(name="employee_name")
    private String employeeName;

    @Column(name="shop_id")
    private String shopId;

}
