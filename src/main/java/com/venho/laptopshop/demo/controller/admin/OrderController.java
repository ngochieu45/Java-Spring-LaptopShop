package com.venho.laptopshop.demo.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.venho.laptopshop.demo.domain.Order;
import com.venho.laptopshop.demo.domain.User;
import com.venho.laptopshop.demo.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/admin/order")
    public String getOrderInfo(Model model,
            @RequestParam("page") Optional<String> pageOptional) {

        int page = 1;
        try {
            if (pageOptional.isPresent()) {
                page = Integer.parseInt(pageOptional.get());
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        Pageable pageable = PageRequest.of(page - 1, 5);
        Page<Order> order_list = this.orderService.getAllOrder(pageable);
        List<Order> orders = order_list.getContent();
        model.addAttribute("order_list", orders);

        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", order_list.getTotalPages());
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
