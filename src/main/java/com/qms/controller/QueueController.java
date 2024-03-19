package com.qms.controller;

import com.qms.request.QueueReq;
import com.qms.response.QueueRes;
import com.qms.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/queue")
public class QueueController {

    @Autowired
    private QueueService queueService;

    @PostMapping("/listQueue")
    public List<QueueRes> listQueue(@RequestBody QueueReq request) throws ParseException {
        return queueService.listQueue(request);
    }

}
