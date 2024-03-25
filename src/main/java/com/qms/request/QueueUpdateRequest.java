package com.qms.request;

import lombok.Data;

@Data
public class QueueUpdateRequest {
    private String queueId;
    private String statusId;
}
