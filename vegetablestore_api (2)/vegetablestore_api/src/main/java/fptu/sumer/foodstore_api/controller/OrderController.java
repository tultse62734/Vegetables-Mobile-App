package fptu.sumer.foodstore_api.controller;


import fptu.sumer.foodstore_api.entity.*;
import fptu.sumer.foodstore_api.model.Order;
import fptu.sumer.foodstore_api.serivce.OrderServices;
import io.swagger.annotations.Api;
import org.jboss.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/")
@Api(value = "Order Management")
public class OrderController {
    private static final Logger LOGGER = Logger.getLogger(OrderController.class.getName());
    private OrderServices orderServices;
    public OrderController(OrderServices orderServices) {
        this.orderServices = orderServices;
    }
    @GetMapping("orders")
    public ResponseEntity getAllOrder() {
        List<Order> listOrderEntity = this.orderServices.findAll();
        if (listOrderEntity != null) {
            return ResponseEntity.ok(listOrderEntity);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
    @PostMapping("orders")
    @Consumes(MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity createOrder(@RequestBody Map<String, String> order) {
        try {
            int userId = Integer.parseInt(order.get("Userld").toString());
            String orderDate = order.get("OrderDate").toString();
            float total = Float.parseFloat(order.get("Total").toString());
            String notes = order.get("Notes").toString();
            Order order1 = new Order();
            order1.setUserId(userId);
            order1.setNotes(notes);
          order1.setOrderDate(orderDate);
            order1.setTotal(total);
            if (order == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
            int newOrderId = this.orderServices.save(order1);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
            return ResponseEntity.status(HttpStatus.OK).body(newOrderId);
        } catch (IllegalArgumentException ex) {
            LOGGER.info(ex.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //get order by order ID
    @GetMapping("orders/{id}")
    public ResponseEntity getOrderById(@PathVariable("id") int orderId) {
        try {
            Order orderListEntity = this.orderServices.find(orderId);
            if (orderListEntity != null) {
                return ResponseEntity.ok(orderListEntity);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    //get order by userID
    @GetMapping("accounts/{id}/orders")
    public ResponseEntity getOrderByCuID(@PathVariable("id") int cusId) {
        try {
            List<OrderEntity> listOrderEntity = this.orderServices.findAllByUser(cusId);
            return ResponseEntity.status(HttpStatus.OK).body(listOrderEntity);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

// bây giwof t sẽ comment hướng dẫn tụi m insert nha. để hiểu lắm.

//    @PostMapping("orders")
//    public ResponseEntity updateOrderById(
//            @RequestBody ItemRequestModel item
//    ) {
//
//        String userId = item.getUserId();
//        float total = item.getTotal();
//        String notes = item.getNotes();


//        lấy tất cả sp trong giỏ hàng đổ vào 1 cái list;
//        List<ItemModel> listProduct = item.getListProduct();
//              tạo entitty để tạo order lưu vào db

//            OrderEntity order = new OrderEntity();
//            order.setUserId(userId);
//            Date orderDate = new Date(System.currentTimeMillis());
//            order.setOrderDate(orderDate);
//            order.setTotal(total);
//            order.setNotes(notes);
    // sau khi set value thì lưu order đó vào db. dùng hàm saveandflush bên dưới nghĩa là lưu vào db sau đó trả lại id mà record vừa insert vào
//            orderRepository.saveAndFlush(order);
//
        //lay id vừa insert để insert vào order detail
//            int orderId = order.getOrderId();
//            insert order detail

//            createNewDetailOrder(orderId, listProduct);
//            return new ResponseEntity(HttpStatus.OK);
//
//        }
//
//    }

    // cái này tạm bỏ qua đii :(
//    private void createNewDetailOrder(int orderId, List<ItemModel> listProduct) {
////        tạo 1 orderdetail object
//        DetailOrderEntity detailOrder = new DetailOrderEntity();
//        //set order id vừa tạo
//        detailOrder.setOrderId(orderId);
////        duyệt list lấy tất cả item giỏ hàng
//        for (ItemModel item : listProduct) {
//            detailOrder.setProductId(item.getProductId());
//            detailOrder.setQuantity(item.getQuantity());
//            detailOrder.setPrice(item.getPrice());
//
////            insert từng sp vào DB
//            detailOrderRepository.save(detailOrder);
//        }
//
//
//    }

//    private int createPayment(int orderId, float amount, Date payDate) {
//        PaymentEntity payment = new PaymentEntity();
//        payment.setOrderId(orderId);
//        payment.setPayAmount(amount);
//        payment.setPayDate(payDate);
//        paymentRepository.save(payment);
//        return payment.getPayId();
//    }

}
