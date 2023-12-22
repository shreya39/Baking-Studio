package com.sheryians.major.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sheryians.major.global.GlobalData;
import com.sheryians.major.service.CategoryService;
import com.sheryians.major.service.ProductService;

@Controller
public class HomeController {
    
	@Autowired
	CategoryService categoryService;
    @Autowired
    ProductService productService;
    
    @GetMapping({"/","/home"})
    public String home(Model m){
    	m.addAttribute("cartCount", GlobalData.cart.size());
    	return "index";
    }
    @GetMapping("/shop")
    public String shop(Model m) {
    	m.addAttribute("categories", categoryService.getAllCategory());
    	m.addAttribute("products", productService.getAllProducts());
    	m.addAttribute("cartCount", GlobalData.cart.size());
    	return "shop";
    }
    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model m,@PathVariable("id") int id) {
    	m.addAttribute("categories", categoryService.getAllCategory());
    	m.addAttribute("products", productService.getAllProductsByCategoryId(id));
    	m.addAttribute("cartCount", GlobalData.cart.size());
    	return "shop";
    }
    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model m,@PathVariable long id) {
    	m.addAttribute("product",productService.getProductById(id).get());
    	m.addAttribute("cartCount", GlobalData.cart.size());
    	return "viewProduct";
    }
}
