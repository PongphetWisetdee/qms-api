package com.qms.repository;

import com.qms.entity.ShopEntity;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@NonNullApi
@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, String> {

    ShopEntity findByShopId(String shopId);
    List<ShopEntity> findAll();
}
