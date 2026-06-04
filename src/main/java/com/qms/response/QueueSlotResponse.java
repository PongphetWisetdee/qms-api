package com.qms.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueueSlotResponse {
    String queueTime;

    String employeeId1;
    String queueId1;
    String statusId1;
    String isQueueExist1;

    String employeeId2;
    String queueId2;
    String statusId2;
    String isQueueExist2;
}
