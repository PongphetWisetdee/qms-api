package com.qms.controller;

import com.qms.entity.QueueEntity;
import com.qms.request.QueueRequest;
import com.qms.request.QueueUpdateForWebRequest;
import com.qms.request.QueueUpdateRequest;
import com.qms.response.QueueResponse;
import com.qms.response.QueueResponseForWeb;
import com.qms.response.QueueSlotResponse;
import com.qms.response.QueueUpdateResponse;
import com.qms.service.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
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
    public List<QueueResponse> queueListForWeb(@RequestBody QueueRequest request) throws SQLException {
    //public List<QueueResponseForWeb> queueListForWeb(@RequestBody QueueRequest request) throws SQLException {
        return queueService.getQueueByDateForWeb(request);
    }

    @PostMapping("/queueListForWebTailWind")
    public List<QueueResponseForWeb> queueListForWebTailWind(@RequestBody QueueRequest request) throws SQLException {
        return queueService.getQueueByDateForWebTailWind(request);
    }

    @PostMapping("/queueUpdateStatus")
    public QueueUpdateResponse queueUpdateStatus(@RequestBody QueueUpdateRequest request) throws SQLException {
        return queueService.updateQueueStatus(request);
    }

    @PostMapping("/queueUpdateStatusForWeb")
    public QueueUpdateResponse queueUpdateStatusForWeb(@RequestBody QueueUpdateForWebRequest request) throws SQLException {
        return queueService.updateQueueForWebStatus(request);
    }

    @PostMapping("/queueUpdateStatusForWebTailWind")
    public QueueUpdateResponse updateQueueForWebTailWindStatus(@RequestBody QueueUpdateForWebRequest request) throws SQLException {
        return queueService.updateQueueForWebTailWindStatus(request);
    }

    @PostMapping("/queueUpdateStatusForWebTailWind2")
    public QueueUpdateResponse updateQueueForWebTailWindStatusShop2(@RequestBody QueueUpdateForWebRequest request) throws SQLException {
        return queueService.updateQueueForWebTailWindStatusShop2(request);
    }

    @GetMapping("/daily-schedule")
    public ResponseEntity<List<QueueSlotResponse>> getDailySchedule(
            @RequestParam String shopId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate queueDate) {
        List<QueueSlotResponse> schedule = queueService.getDailySchedule(shopId, queueDate);
        return ResponseEntity.ok(schedule);
    }

}
