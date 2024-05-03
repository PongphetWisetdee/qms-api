package com.qms.controller;

import com.qms.entity.QueueEntity;
import com.qms.request.QueueRequest;
import com.qms.request.QueueUpdateForWebRequest;
import com.qms.request.QueueUpdateRequest;
import com.qms.response.QueueResponse;
import com.qms.response.QueueResponseForWeb;
import com.qms.response.QueueUpdateResponse;
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
    public List<QueueResponseForWeb> queueListForWeb(@RequestBody QueueRequest request) throws SQLException {
        return queueService.getQueueByDateForWeb(request);
    }

    @PostMapping("/queueUpdateStatus")
    public QueueUpdateResponse queueUpdateStatus(@RequestBody QueueUpdateRequest request) throws SQLException {
        return queueService.updateQueueStatus(request);
    }

    @PostMapping("/queueUpdateStatusForWeb")
    public QueueUpdateResponse queueUpdateStatusForWeb(@RequestBody QueueUpdateForWebRequest request) throws SQLException {
        return queueService.updateQueueForWebStatus(request);
    }

}
