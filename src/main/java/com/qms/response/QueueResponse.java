package com.qms.response;

import lombok.Data;

@Data
public class QueueResponse {

    private String queueId;
    private String queueDate;
    private String queueTime;
    private String queuePrice;
    private String queueTimeout;
    private String employeeId;
    private String employeeName;
    private String serviceId;
    private String statusId;
    private String shopId;

}
