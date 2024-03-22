package com.qms.repository;

import com.qms.entity.QueueEntity;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@NonNullApi
@Repository
public interface QueueRepository extends CrudRepository<QueueEntity, String> {

        public QueueEntity findQueueByQueueId(String queueId);

}

