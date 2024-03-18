package com.qms.controller;

import com.qms.entity.ShopEntity;
import com.qms.repository.ShopRepository;
import com.qms.response.QueueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getAllShop")
    public ShopEntity shopList() {
        return shopRepo.findByShopId("S001");
    }

}
