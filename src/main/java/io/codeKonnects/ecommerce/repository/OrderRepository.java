package io.codeKonnects.ecommerce.repository;

import io.codeKonnects.ecommerce.model.Order;
import io.codeKonnects.ecommerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByUserOrderByCreatedDateDesc(User user);
}
