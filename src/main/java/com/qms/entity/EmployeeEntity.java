package com.qms.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @Column(name="employee_id")
    private String employeeId;

    @Column(name="employee_name")
    private String employeeName;

    @Column(name="employee_shop")
    private String employeeShop;

}
