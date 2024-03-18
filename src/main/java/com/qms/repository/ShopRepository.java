package com.qms.repository;

import com.qms.entity.ShopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, String> {
    ShopEntity findByShopId(String shopId);
}
