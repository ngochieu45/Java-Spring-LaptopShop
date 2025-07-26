package com.venho.laptopshop.demo.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.venho.laptopshop.demo.domain.Product;
import com.venho.laptopshop.demo.service.ProductService;
import com.venho.laptopshop.demo.service.UploadService;

import jakarta.validation.Valid;

@Controller
public class ProductController {

    private final ProductService productService;
    private final UploadService uploadService;

    ProductController(ProductService productService, UploadService uploadService) {
        this.productService = productService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/product")
    public String getProduct(Model model) {
        List<Product> product_list = this.productService.getAllProduct();
        model.addAttribute("product_list", product_list);
        return "/admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "/admin/product/create";
    }

    @PostMapping("/admin/product/create")
    public String createUserPage(Model model, @ModelAttribute("newProduct") @Valid Product newProduct,
            BindingResult newProductBindingResult,
            @RequestParam("product_img") MultipartFile file) {

        List<FieldError> errors = newProductBindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getField() + " - " + error.getDefaultMessage());
        }

        if (newProductBindingResult.hasErrors()) {
            return "/admin/product/create";
        }
        String product_img = this.uploadService.handleSaveUploadFile(file, "product");

        newProduct.setImage(product_img);
        this.productService.handleSaveProduct(newProduct);
        return "redirect:/admin/product";
    }

    @PostMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") long id) {
        this.productService.deleteProductById(id);
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/update/{id}")
    public String getUpdateProductPage(Model model, @PathVariable("id") long id) {
        model.addAttribute("id", id);
        Product productDetail = productService.getProductById(id);
        model.addAttribute("product", productDetail);
        return "/admin/product/update";
    }

    @PostMapping("/admin/product/update/{id}")
    public String updateProduct(@ModelAttribute("product") Product updateProduct) {
        Product currentProduct = this.productService.getProductById(updateProduct.getId());
        if (currentProduct != null) {
            currentProduct.setName(updateProduct.getName());
            currentProduct.setPrice(updateProduct.getPrice());
            currentProduct.setDetailDesc(updateProduct.getDetailDesc());
            currentProduct.setShortDesc(updateProduct.getShortDesc());
            currentProduct.setQuantity(updateProduct.getQuantity());
            currentProduct.setFactory(updateProduct.getFactory());
            currentProduct.setTarget(updateProduct.getTarget());
            productService.handleSaveProduct(currentProduct);
        }
        return "redirect:/admin/product";
    }

}
