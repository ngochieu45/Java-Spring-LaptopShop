package com.venho.laptopshop.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.venho.laptopshop.demo.domain.Cart;
import com.venho.laptopshop.demo.domain.CartDetail;
import com.venho.laptopshop.demo.domain.Product;
import com.venho.laptopshop.demo.domain.User;
import com.venho.laptopshop.demo.repository.CartDetailRepository;
import com.venho.laptopshop.demo.repository.CartRepository;
import com.venho.laptopshop.demo.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailRepository;
    private final UserService userService;

    public ProductService(ProductRepository productRepository,
            CartRepository cartRepository,
            CartDetailRepository cartDetailRepository,
            UserService userService) {
        this.productRepository = productRepository;
        this.cartRepository = cartRepository;
        this.cartDetailRepository = cartDetailRepository;
        this.userService = userService;
    }

    public Product handleSaveProduct(Product product) {
        return this.productRepository.save(product);
    }

    public List<Product> getAllProduct() {
        return this.productRepository.findAll();
    }

    public void deleteProductById(Long id) {
        this.productRepository.deleteById(id);
    }

    public Product getProductById(long id) {
        return this.productRepository.findById(id);
    }

    public void handleAddProductToCart(String email, long productId) {
        // check user's cart exist
        User user = this.userService.getUserByEmail(email);
        if (user != null) {
            Cart cart = this.cartRepository.findByUser(user);

            if (cart == null) {
                // create cart
                Cart otherCart = new Cart();
                otherCart.setUser(user);
                otherCart.setSum(1);
                cart = this.cartRepository.save(otherCart);
            }
            // save cart detail

            // find product by id
            Product product = this.productRepository.findById(productId);

            CartDetail cartDetail = new CartDetail();
            cartDetail.setCart(cart);
            cartDetail.setProduct(product);
            cartDetail.setPrice(product.getPrice());
            cartDetail.setQuantity(1);
            this.cartDetailRepository.save(cartDetail);
        }

    }
}
