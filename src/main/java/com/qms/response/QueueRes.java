package com.qms.response;

import com.qms.entity.QueueEntity;
import lombok.Data;

import java.util.Date;

@Data
public class QueueRes {

    private String queueId;
    private String queueDate;
    private String queueTime;
    private String queueStatus;
    private String queueEmployee;

}
