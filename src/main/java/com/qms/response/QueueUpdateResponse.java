package com.qms.response;

import lombok.Data;

@Data
public class QueueUpdateResponse {
    private String queueId;
    private boolean statusUpdateSuccess;
}
