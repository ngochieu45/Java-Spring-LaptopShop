package com.venho.laptopshop.demo.controller.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.venho.laptopshop.demo.domain.Cart;
import com.venho.laptopshop.demo.domain.CartDetail;
import com.venho.laptopshop.demo.domain.Product;
import com.venho.laptopshop.demo.domain.User;
import com.venho.laptopshop.demo.repository.CartDetailRepository;
import com.venho.laptopshop.demo.repository.CartRepository;
import com.venho.laptopshop.demo.service.ProductService;
import com.venho.laptopshop.demo.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ItemController {
    private final ProductService productService;
    private final CartDetailRepository cartDetailRepository;
    private final CartRepository cartRepository;

    private final UserService userService;

    public ItemController(ProductService productService,
            CartDetailRepository cartDetailRepository,
            UserService userService,
            CartRepository cartRepository) {
        this.productService = productService;
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
        this.cartRepository = cartRepository;
    }

    @GetMapping("/product/{id}")
    public String getProductDetailPage(Model model, @PathVariable long id) {
        Product product = this.productService.getProductById(id);
        model.addAttribute("id", id);
        model.addAttribute("product", product);
        return "client/product/view-detail";
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String getAddProductToCart(@PathVariable long id, HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        long productId = id;

        String email = (String) session.getAttribute("email");
        this.productService.handleAddProductToCart(email, productId, session);
        return "redirect:/";
    }

    @GetMapping("/cart")
    public String getCartPage(Model model, HttpServletRequest request) {
        User user = new User();
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");
        user.setId(id);
        Cart cart = this.productService.fetchByUser(user);

        List<CartDetail> cartDetails = cart == null ? new ArrayList<CartDetail>() : cart.getCartDetails();

        double totalPrice = 0;
        for (CartDetail cd : cartDetails) {
            totalPrice += cd.getPrice() * cd.getQuantity();
        }

        model.addAttribute("cartDetails", cartDetails);
        model.addAttribute("totalPrice", totalPrice);
        return "client/cart/show";
    }

}
