package fptu.sumer.foodstore_api.reponsitory;


import fptu.sumer.foodstore_api.entity.DetailOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailOrderRepository extends JpaRepository<DetailOrderEntity, Integer> {

    List<DetailOrderEntity> findAllByOrderId(int orderId);

}
