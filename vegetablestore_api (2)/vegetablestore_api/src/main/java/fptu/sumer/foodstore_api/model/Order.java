package fptu.sumer.foodstore_api.model;

import fptu.sumer.foodstore_api.entity.OrderEntity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Order implements Serializable {
    public Order() {
    }
    private int orderId;
    private int userId;
    private String orderDate;
    private float total;
    private String notes;
    private List<OrderDetail> orderDetails;
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public OrderEntity toOrderListEntity() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setNotes(this.notes);
        orderEntity.setOrderDate(this.orderDate);
        orderEntity.setUserId(this.userId);
        orderEntity.setTotal(this.total);
        return orderEntity;
    }
}
