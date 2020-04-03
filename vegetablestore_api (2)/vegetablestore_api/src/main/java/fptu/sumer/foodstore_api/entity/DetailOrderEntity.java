package fptu.sumer.foodstore_api.entity;

import javax.persistence.*;

@Entity
@Table(name = "DetailOrder", schema = "dbo", catalog = "SmartFarm")
public class DetailOrderEntity {
    @Id
    @Column(name = "DetailOrderId", updatable = false)
    private int detailOrderId;

    @Column(name = "OrderId")
    private int orderId;

    @Column(name = "ProductId")
    private int productId;

    @Column(name = "Quantity")
    private  int quantity;

    public DetailOrderEntity() {
    }

    public int getDetailOrderId() {
        return detailOrderId;
    }

    public void setDetailOrderId(int detailOrderId) {
        this.detailOrderId = detailOrderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
