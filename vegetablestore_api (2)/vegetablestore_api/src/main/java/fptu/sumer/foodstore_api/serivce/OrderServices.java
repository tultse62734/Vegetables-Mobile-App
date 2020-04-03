package fptu.sumer.foodstore_api.serivce;

import fptu.sumer.foodstore_api.entity.DetailOrderEntity;
import fptu.sumer.foodstore_api.entity.OrderEntity;
import fptu.sumer.foodstore_api.model.Order;
import fptu.sumer.foodstore_api.model.OrderDetail;
import fptu.sumer.foodstore_api.reponsitory.DetailOrderRepository;
import fptu.sumer.foodstore_api.reponsitory.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServices {

    private OrderRepository orderRepository;

    private DetailOrderRepository detailOrderRepository;

    public  OrderServices(OrderRepository orderRepository, DetailOrderRepository detailOrderRepository) {
        this.orderRepository = orderRepository;
        this.detailOrderRepository = detailOrderRepository;
    }

    public Order find(int orderId) {
        // get order info
        OrderEntity order = orderRepository.findByOrderId(orderId);
        Order orderToReturn = this.toOrderModel(order);

        // get order details
        List<OrderDetail> orderDetails = new ArrayList<>();
        List<DetailOrderEntity> detailOrderEntities = this.detailOrderRepository.findAllByOrderId(order.getOrderId());
        detailOrderEntities.forEach(orderDetailEntity -> orderDetails.add(this.toOrderDetail(orderDetailEntity)));

        // set details to the order
        orderToReturn.setOrderDetails(orderDetails);

        // return
        return orderToReturn;
    }

    public List<Order> findAll() {
        List<OrderEntity> orderDTOs = orderRepository.findAll();
        List<Order> orders = new ArrayList<>();
        orderDTOs.forEach(orderDTO -> {
            // convert to working model
            Order order = this.toOrderModel(orderDTO);

            // get details
            List<OrderDetail> orderDetails = new ArrayList<>();
            this.detailOrderRepository
                    .findAllByOrderId(order.getOrderId())
                    .forEach(orderDetailEntity -> orderDetails.add(this.toOrderDetail(orderDetailEntity)));
            order.setOrderDetails(orderDetails);

            // add to final list
            orders.add(order);
        });
        return orders;
    }

    public List<OrderEntity> findAllByUser(int cusId) {
        return orderRepository.findAllByUserId(cusId);
    }

    public int save(Order order) throws IllegalArgumentException {
        // validate
        if (order == null) {
            throw new IllegalArgumentException();
        }

        // save order
        OrderEntity createdOrder = this.orderRepository.save(order.toOrderListEntity());
        System.out.println("hoàn thành");
        // save order details
      // order.getOrderDetails().forEach(orderDetail -> this.detailOrderRepository.save(orderDetail.toDetailOrderEntity()));

        // return newly created order's ID
        return createdOrder.getOrderId();
    }

    // CONVERTERS

    private Order toOrderModel(OrderEntity orderDTO) {
        Order order = new Order();
        order.setOrderId(orderDTO.getOrderId());
        order.setUserId(orderDTO.getUserId());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setNotes(orderDTO.getNotes());
        order.setTotal(orderDTO.getTotal());

        return order;
    }

    private OrderDetail toOrderDetail(DetailOrderEntity detailOrderEntity) {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setId(detailOrderEntity.getOrderId());
        orderDetail.setProductId(detailOrderEntity.getProductId());
        orderDetail.setQuantity(detailOrderEntity.getQuantity());
        orderDetail.setOrderId(detailOrderEntity.getOrderId());

        return orderDetail;
    }
}
