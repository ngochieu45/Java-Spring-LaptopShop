package com.venho.laptopshop.demo.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.venho.laptopshop.demo.domain.Product;
import com.venho.laptopshop.demo.service.ProductService;

@Controller
public class ItemController {
    private final ProductService productService;

    public ItemController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public String getProductDetailPage(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        System.out.println("product " + product);
        model.addAttribute("id", id);
        model.addAttribute("product", product);
        return "/client/product/view-detail";
    }

}
