package com.qms.controller;

import com.qms.response.QueueResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {

    @GetMapping("/getQueue")
    public QueueResponse getQueue() {
        QueueResponse queue = new QueueResponse();
        queue.setId("01");
        queue.setName("queue");
        return queue;
    }

}
