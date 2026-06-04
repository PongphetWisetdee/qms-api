package com.qms.repository;

import com.qms.entity.EmployeeEntity;
import com.qms.entity.QueueEntity;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@NonNullApi
@Repository
public interface QueueRepository extends CrudRepository<QueueEntity, String> {

        public QueueEntity findQueueByQueueId(String queueId);

        @Query(value = """
            SELECT 
                e.employee_id AS employeeId, 
                q.queue_id AS queueId, 
                q.queue_time AS queueTime, 
                q.status_id AS statusId
            FROM employee e
            LEFT JOIN queue q 
                ON e.employee_id = q.employee_id 
                AND q.queue_date = :queueDate
            WHERE e.shop_id = :shopId
            ORDER BY e.employee_id
            """, nativeQuery = true)
        List<EmployeeQueueProjection> findScheduleByShopAndDate(
                @Param("shopId") String shopId,
                @Param("queueDate") LocalDate queueDate);

}

