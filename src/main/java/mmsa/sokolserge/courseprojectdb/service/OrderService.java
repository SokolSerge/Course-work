package mmsa.sokolserge.courseprojectdb.service;

import lombok.Builder;
import mmsa.sokolserge.courseprojectdb.dto.OrderDto;
import mmsa.sokolserge.courseprojectdb.exception.UserNotFoundException;
import mmsa.sokolserge.courseprojectdb.exception.ProductPriceNotFoundException;
import mmsa.sokolserge.courseprojectdb.exception.OrderNotFoundException;
import mmsa.sokolserge.courseprojectdb.exception.StatusNotFoundException;
import mmsa.sokolserge.courseprojectdb.repo.model.Order;
import mmsa.sokolserge.courseprojectdb.repo.UserRepo;
import mmsa.sokolserge.courseprojectdb.repo.ProductPriceRepo;
import mmsa.sokolserge.courseprojectdb.repo.OrderRepo;
import mmsa.sokolserge.courseprojectdb.repo.StatusRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Builder
@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepo orderRepo;
    private final UserRepo userRepo;
    private final ProductPriceRepo productPriceRepo;
    private final StatusRepo statusRepo;


    public List<Order> getOrders(){
        return orderRepo.findAll();
    }

    public Order saveOrder(OrderDto newOrder) {
        Order order=Order.builder()
                .userId(userRepo.findById(newOrder.getUserId()).orElseThrow(UserNotFoundException::new))
                .productPriceId(productPriceRepo.findById(newOrder.getProductPriceId()).orElseThrow(ProductPriceNotFoundException::new))
                .statusId(statusRepo.findById(newOrder.getStatusId()).orElseThrow(StatusNotFoundException::new))
                .tableId(newOrder.getTableId())
                .build();
        return orderRepo.save(order);
    }

    public Order getOrderById(Long id) {
        Optional<Order> order = orderRepo.findById(id);
        if (order.isPresent()) {
            return order.get();
        }
        throw new OrderNotFoundException();
    }

    public Order updateOrderById(Long id, OrderDto updatedOrder) {
        Optional<Order> order = orderRepo.findById(id);
        if (order.isPresent()) {;
            Order oldOrder = order.get();
            updateOrder(oldOrder, updatedOrder);
            return orderRepo.save(oldOrder);

        }
        throw new OrderNotFoundException();
    }

    private void updateOrder(Order oldOrder, OrderDto updatedOrder) {
        oldOrder.setUserId(userRepo.findById(updatedOrder.getUserId()).orElseThrow(UserNotFoundException::new));
        oldOrder.setStatusId(statusRepo.findById(updatedOrder.getStatusId()).orElseThrow(StatusNotFoundException::new));
        oldOrder.setProductPriceId(productPriceRepo.findById(updatedOrder.getProductPriceId()).orElseThrow(ProductPriceNotFoundException::new));
        oldOrder.setTableId(updatedOrder.getTableId());
    }

    public String deleteOrderById(Long id) {
        if (orderRepo.findById(id).isPresent()) {
            orderRepo.deleteById(id);
            return "Order was successfully deleted";
        }
        throw new OrderNotFoundException();
    }
}
