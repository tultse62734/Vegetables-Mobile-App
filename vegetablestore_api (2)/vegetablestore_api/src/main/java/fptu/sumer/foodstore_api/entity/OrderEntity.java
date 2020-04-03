package fptu.sumer.foodstore_api.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "[Order]", schema = "dbo", catalog = "SmartFarm")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private int orderId;

    @Basic
    @Column(name = "UserId")
    private int userId;

    @Basic
    @Column(name = "OrderDate")
    private String  orderDate;

    @Basic
    @Column(name = "Total")
    private float total;

    @Basic
    @Column(name = "Notes")
    private String notes;


    public OrderEntity() {
    }

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

}
