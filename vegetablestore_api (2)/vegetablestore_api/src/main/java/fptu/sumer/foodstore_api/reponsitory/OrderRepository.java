package fptu.sumer.foodstore_api.reponsitory;


import fptu.sumer.foodstore_api.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

    List<OrderEntity> findAll();

    OrderEntity findByOrderId(int orderId);

    List<OrderEntity> findAllByUserId(int cusId);

}
