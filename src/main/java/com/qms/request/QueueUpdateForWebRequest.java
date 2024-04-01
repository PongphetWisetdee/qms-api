package com.qms.request;

import lombok.Data;

@Data
public class QueueUpdateForWebRequest {
    private String queueId;
    private String statusId;
    private String isQueueExist;
}
