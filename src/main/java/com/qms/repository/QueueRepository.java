package com.qms.repository;

import com.qms.entity.QueueEntity;
import com.qms.entity.ShopEntity;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@NonNullApi
@Repository
public interface QueueRepository extends CrudRepository<QueueEntity, String> {

    List<QueueEntity> findByQueueDateAndQueueShop(Date queueDate, String queueShop);

}