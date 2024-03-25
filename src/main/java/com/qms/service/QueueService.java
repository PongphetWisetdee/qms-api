package com.qms.service;

import com.qms.entity.QueueEntity;
import com.qms.repository.QueueRepository;
import com.qms.request.QueueRequest;
import com.qms.request.QueueUpdateRequest;
import com.qms.response.QueueResponse;
import com.qms.response.QueueUpdateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class QueueService {

    @Autowired
    private QueueRepository queueRepo;

    @Value("${spring.datasource.url}")
    private String jdbcUrl;

    @Value("${spring.datasource.username}")
    private String jdbcUsername;

    @Value("${spring.datasource.password}")
    private String jdbcPass;

    public QueueEntity getQueueById(String queueId) throws SQLException {

        String query = "SELECT * FROM queue WHERE queue_id = ':queueId'"
                .replace(":queueId", queueId);

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        QueueEntity entity = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPass);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            resultSet.next();
            entity = new QueueEntity();
            entity.setQueueId(resultSet.getString("queue_id"));
            entity.setQueueDate(resultSet.getDate("queue_date"));
            entity.setQueueTime(resultSet.getString("queue_time"));
            entity.setQueuePrice(resultSet.getString("queue_price"));
            entity.setQueueTimeOut(resultSet.getString("queue_timeout"));
            entity.setEmployeeId(resultSet.getString("employee_id"));
            entity.setStatusId(resultSet.getString("status_id"));
            entity.setServiceId(resultSet.getString("status_id"));
            entity.setShopId(resultSet.getString("shop_id"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            assert resultSet != null;
            resultSet.close();
            statement.close();
            connection.close();
        }

        return entity;
    }

    public List<QueueResponse> getQueueByDateForWeb(QueueRequest request) throws SQLException {

        String query = "SELECT " + "queue.queue_id, " +
                "queue.queue_date, " +
                "queue.queue_time, " +
                "queue.queue_price, " +
                "queue.queue_timeout, " +
                "queue.employee_id, " +
                "employee.employee_name, " +
                "queue.service_id, " +
                "queue.status_id, " +
                "queue.shop_id " +
                "From queue " +
                "INNER JOIN employee ON queue.employee_id = employee.employee_id " +
                "WHERE queue.queue_date = ':queueDate' AND queue.shop_id = ':shopId'";

        String queryWithParam = query
                .replace(":queueDate", request.getQueueDate())
                .replace(":shopId", request.getShopId());

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        List<QueueResponse> queueResponseList = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPass);
            statement = connection.createStatement();
            resultSet = statement.executeQuery(queryWithParam);

            while (resultSet.next()) {
                QueueResponse queueRes = new QueueResponse();
                queueRes.setQueueId(resultSet.getString("queue_id"));
                queueRes.setQueueDate(resultSet.getString("queue_date"));
                queueRes.setQueueTime(resultSet.getString("queue_time"));
                queueRes.setQueuePrice(resultSet.getString("queue_price"));
                queueRes.setQueueTimeout(resultSet.getString("queue_timeout"));
                queueRes.setEmployeeId(resultSet.getString("employee_id"));
                queueRes.setEmployeeName(resultSet.getString("employee_name"));
                queueRes.setStatusId(resultSet.getString("status_id"));
                queueRes.setServiceId(resultSet.getString("status_id"));
                queueRes.setShopId(resultSet.getString("shop_id"));
                queueResponseList.add(queueRes);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            assert resultSet != null;
            resultSet.close();
            statement.close();
            connection.close();
        }

        return queueResponseList;
    }

    public QueueUpdateResponse updateQueueStatus (QueueUpdateRequest request) throws SQLException {

        QueueUpdateResponse response = new QueueUpdateResponse();
        response.setQueueId(request.getQueueId());

        String query = "UPDATE queue SET status_id = '" + request.getStatusId() + "' WHERE queue_id = '" + request.getQueueId() + "';";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPass);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            response.setStatusUpdateSuccess(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.setStatusUpdateSuccess(false);
        }finally {
            assert statement != null;
            statement.close();
            connection.close();
        }
        return response;
    }
}