package com.qms.service;

import com.qms.entity.QueueEntity;
import com.qms.repository.QueueRepository;
import com.qms.request.QueueReq;
import com.qms.response.QueueRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class QueueService {

    @Autowired
    private QueueRepository queueRepo;

    public List<QueueRes> listQueue(QueueReq request) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        Date dateQueue = df.parse(request.getDate());

        List<QueueEntity> listEntity = queueRepo.findByQueueDateAndQueueShop(dateQueue, request.getShopId());
        List<QueueRes> listQueue = new ArrayList<>();

        listEntity.forEach((entity) -> {
            QueueRes res = new QueueRes();
            res.setQueueId(entity.getQueueId());
            res.setQueueDate(entity.getQueueDate().toString().substring(0, 10));
            res.setQueueTime(entity.getQueueTime());
            res.setQueueStatus(entity.getQueueStatus());
            res.setQueueEmployee(entity.getQueueEmployee());
            listQueue.add(res);
        });
        return listQueue;
    }
}