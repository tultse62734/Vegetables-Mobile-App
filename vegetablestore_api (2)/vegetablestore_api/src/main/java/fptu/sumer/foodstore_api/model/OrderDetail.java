package fptu.sumer.foodstore_api.model;

import fptu.sumer.foodstore_api.entity.DetailOrderEntity;

import java.io.Serializable;

public class OrderDetail implements Serializable {

    public OrderDetail() {

    }
    private int id;
    private int orderId;
    private int productId;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public DetailOrderEntity toDetailOrderEntity() {
        DetailOrderEntity orderDetail = new DetailOrderEntity();
        orderDetail.setProductId(this.productId);
        orderDetail.setQuantity(this.quantity);
        return orderDetail;
    }
}
