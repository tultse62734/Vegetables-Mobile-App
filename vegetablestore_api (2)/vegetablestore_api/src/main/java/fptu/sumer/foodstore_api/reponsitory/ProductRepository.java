package fptu.sumer.foodstore_api.reponsitory;


import fptu.sumer.foodstore_api.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    ProductEntity findByProNameContaining(String searchValue);

    ProductEntity findByProId(int productCode);

    List<ProductEntity> findAllByProStatus(int status);

    boolean existsDistinctByProId(int proCode);

    List<ProductEntity> findAllByCategoryId(int categoryId);

}
