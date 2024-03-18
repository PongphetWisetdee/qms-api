package com.qms.controller;

import com.qms.entity.ShopEntity;
import com.qms.repository.ShopRepository;
import com.qms.response.QueueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QueueController {

    @Autowired
    private ShopRepository shopRepo;

    @GetMapping("/getQueue")
    public QueueResponse getQueue() {
        QueueResponse queue = new QueueResponse();
        queue.setId("01");
        queue.setName("queue");
        return queue;
    }

    @GetMapping("protected/getAllShop")
    public List<ShopEntity> shopList() {
        return shopRepo.findAll();
    }

}
