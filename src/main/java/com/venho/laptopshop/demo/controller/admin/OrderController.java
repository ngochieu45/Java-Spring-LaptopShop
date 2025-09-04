package com.venho.laptopshop.demo.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.venho.laptopshop.demo.domain.Order;
import com.venho.laptopshop.demo.service.OrderService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin/order")
    public String getOrderInfo(Model model) {
        List<Order> order_list = this.orderService.getAllOrder();
        model.addAttribute("order_list", order_list);
        return "admin/order/show";
    }

    @GetMapping("/admin/order/{id}")
    public String getOrderDetail(Model model, @PathVariable("id") long id) {
        Order order = this.orderService.getOrderById(id).get();
        model.addAttribute("order", order);
        model.addAttribute("id", id);
        model.addAttribute("orderDetails", order.getOrderDetails());
        return "admin/order/detail";
    }

    @GetMapping("/admin/order/update/{id}")
    public String getUpdateOrderPage(Model model, @PathVariable("id") long id) {
        Order order = this.orderService.getOrderById(id).get();
        model.addAttribute("order", order);
        return "admin/order/update";
    }

    @PostMapping("/admin/order/update/{id}")
    public String updateOrder(@ModelAttribute("order") Order updateOrder) {
        Order currentOrder = this.orderService.getOrderById(updateOrder.getId()).get();
        currentOrder.setStatus(updateOrder.getStatus());
        this.orderService.handleSaveOrder(currentOrder);
        return "redirect:/admin/order";
    }

    @PostMapping("/admin/order/delete/{id}")
    public String deleteOrder(@PathVariable("id") long id) {
        this.orderService.deleteOrderById(id);
        return "redirect:/admin/order";
    }

}
