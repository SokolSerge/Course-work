package mmsa.sokolserge.courseprojectdb.api;

import mmsa.sokolserge.courseprojectdb.dto.OrderDto;
import mmsa.sokolserge.courseprojectdb.repo.model.Order;
import mmsa.sokolserge.courseprojectdb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/order")
    public ResponseEntity<List<Order>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }

    @PostMapping(value = "/order")
    public ResponseEntity<Order> postOrder(@RequestBody OrderDto newOrder) {
        return ResponseEntity.ok(orderService.saveOrder(newOrder));
    }

    @GetMapping(value = "/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }

    @PatchMapping(value = "/order/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderDto updatedOrder) {
        return ResponseEntity.ok(orderService.updateOrderById(id, updatedOrder));
    }

    @DeleteMapping(value = "/order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.deleteOrderById(id));
    }

}
