package fptu.sumer.foodstore_api.serivce;

import fptu.sumer.foodstore_api.entity.CategoryEntity;
import fptu.sumer.foodstore_api.entity.ProductEntity;
import fptu.sumer.foodstore_api.model.Category;
import fptu.sumer.foodstore_api.model.Product;
import fptu.sumer.foodstore_api.reponsitory.CategoryRepository;
import fptu.sumer.foodstore_api.reponsitory.ProductRepository;
import fptu.sumer.foodstore_api.reponsitory.StoreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServices {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    private StoreRepository storeRepository;

    public ProductServices(ProductRepository productRepository, CategoryRepository categoryRepository, StoreRepository storeRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.storeRepository = storeRepository;
    }

    public int save(Product product) throws IllegalArgumentException {
        ProductEntity entity = this.toProductEntity(product);

        boolean checkProductCode = productRepository.existsDistinctByProId(entity.getProId());
        boolean checkCategory = categoryRepository.existsDistinctByCategoryId(entity.getCategoryId());

        if (checkProductCode) {
            throw new IllegalArgumentException("Product is already existed in our database");
        }

        if (!checkCategory) {
            throw new IllegalArgumentException("Invalid category");
        }

        entity.setProStatus(1);
        return productRepository.save(entity).getProId();
    }

    public void update(int id, Product product) {

        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        ProductEntity productEntity = productRepository.findByProId(id);

        if (productEntity == null) {
            throw new IllegalArgumentException("Product not found");
        }

        productEntity.setProName(product.getName());
        productEntity.setProPrice(product.getPrice());
        productEntity.setProImage(product.getImage());
        productEntity.setProQuantity(product.getQuantity());
        productEntity.setProDescription(product.getDescription());
        productEntity.setProStatus(product.getStatus());

        productRepository.save(productEntity);
    }

    public Product findById(int id) {
        return this.toProduct(this.productRepository.findByProId(id));
    }

    public List<Product> findAllByStatus(int status) {
        return this.toProducts(productRepository.findAllByProStatus(status));
    }

    public List<Product> findAllByCategoryId(int categoryId) {
        return this.toProducts(productRepository.findAllByCategoryId(categoryId));
    }

    // CONVERTERS

    private Category toCategory(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getCategoryId());
        category.setName(categoryEntity.getCategoryName());

        return category;
    }

    private List<Product> toProducts(List<ProductEntity> productDTOs) {
        List<Product> products = new ArrayList<>();
        if (productDTOs != null) {
            for (ProductEntity productDTO: productDTOs) {

                // create a product model
                Product product = new Product();

                // set data
                product.setId(productDTO.getProId());
                product.setStoreId(productDTO.getStoreId());
                product.setName(productDTO.getProName());
                product.setPrice(productDTO.getProPrice());
                product.setImage(productDTO.getProImage());
                product.setQuantity(productDTO.getProQuantity());
                product.setDescription(productDTO.getProDescription());
                product.setStatus(productDTO.getProStatus());
                product.setStoreName(storeRepository.findByStoreId(productDTO.getStoreId()).getStoreName());
                product.setCategory(this.toCategory(this.categoryRepository.findByCategoryId(productDTO.getCategoryId())));

                // add to the bag
                products.add(product);
            }
        }
        return products;
    }

    private Product toProduct(ProductEntity entity) {
        Product product = new Product();
        product.setId(entity.getProId());
        product.setName(entity.getProName());
        product.setDescription(entity.getProDescription());
        product.setPrice(entity.getProPrice());
        product.setImage(entity.getProImage());
        product.setQuantity(entity.getProQuantity());
        product.setStoreId(entity.getStoreId());
        product.setStoreName(this.storeRepository.findByStoreId(entity.getStoreId()).getStoreName());
        product.setCategory(this.toCategory(this.categoryRepository.findByCategoryId(entity.getCategoryId())));

        return product;
    }

    private ProductEntity toProductEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setProId(product.getId());
        entity.setProName(product.getName());
        entity.setProDescription(product.getDescription());
        entity.setProImage(product.getImage());
        entity.setProPrice(product.getPrice());
        entity.setProQuantity(product.getQuantity());
        entity.setCategoryId(product.getCategory() != null? product.getCategory().getId() : 0);
        entity.setStoreId(product.getStoreId());

        return entity;
    }

}
