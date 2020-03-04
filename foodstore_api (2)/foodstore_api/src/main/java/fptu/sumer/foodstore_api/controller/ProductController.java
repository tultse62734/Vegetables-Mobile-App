package fptu.sumer.foodstore_api.controller;

import fptu.sumer.foodstore_api.model.Product;
import fptu.sumer.foodstore_api.serivce.ProductServices;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/")
@Api(value = "Account Management System", description = "Operations pertaining to account in Account Management System")
public class ProductController {

    private final Logger LOGGER = Logger.getLogger(ProductController.class.getName());

    private ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }

    @GetMapping("products")
    public ResponseEntity getAllProductByStatus() {
       try {
           List<Product> products = this.productServices.findAllByStatus(1);
           return ResponseEntity.status(HttpStatus.OK).body(products);
       } catch (Exception ex) {
           LOGGER.info(ex.getLocalizedMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }

    @GetMapping("products/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id) {
        try {
            Product product = this.productServices.findById(id);
            if(product != null){
                return ResponseEntity.status(HttpStatus.OK).body(product);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception ex) {
            LOGGER.info(ex.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("products/category/{id}")
    public ResponseEntity getProductByCategoryId(@PathVariable int id) {
        try {
            List<Product> products = this.productServices.findAllByCategoryId(id);
            return ResponseEntity.status(HttpStatus.OK).body(products);
        } catch (Exception ex) {
            // tạm log info, ra production phải đổi sang config riêng
            LOGGER.info(ex.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("products")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createNewProduct(@RequestBody Product product) {

       try {
           int createResult = this.productServices.save(product);
           return ResponseEntity.status(HttpStatus.CREATED).body(createResult);
       } catch (IllegalArgumentException ex) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       } catch (Exception ex) {
           LOGGER.info(ex.getLocalizedMessage());
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
       }
    }

    @PutMapping("products/{id}")
    public ResponseEntity updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
        try {
            this.productServices.update(id, product);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException ex) {
            // có thể extend exception này để thêm error code, phân biệt lỗi 404 và illegal argument
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
