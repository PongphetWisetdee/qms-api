package com.qms.controller;

import com.qms.entity.QueueEntity;
import com.qms.request.QueueRequest;
import com.qms.response.QueueResponse;
import com.qms.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/queue")
public class QueueController {

    @Autowired
    private QueueService queueService;

    @GetMapping("/getQueueById/{id}")
    public QueueEntity getQueueById(@PathVariable("id") String queueId) throws SQLException {
        return queueService.getQueueById(queueId);
    }

    @PostMapping("/queueListForWeb")
    public  List<QueueResponse> queueListForWeb(@RequestBody QueueRequest request) throws SQLException {
        return  queueService.getQueueByDateForWeb(request);
    }

}
