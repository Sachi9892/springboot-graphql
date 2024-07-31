package com.curiouscoder.repository;

import com.curiouscoder.entity.OrderClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderClass , Integer> {
}
