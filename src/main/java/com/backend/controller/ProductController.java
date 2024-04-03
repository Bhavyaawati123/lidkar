package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entity.Product;
import com.backend.service.ProductService;





@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/createProduct")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}

	@PutMapping("/update/{id}")
	public Product updateUser(@PathVariable("id") Long id, @RequestBody Product product) {
		return productService.updateProduct(id, product);
	}

	@GetMapping("/fetchAllUsers")
	public List<Product> fetchAllUsers() {
		return productService.fetchAllProduct();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		productService.deleteUser(id);
	}
//
//	  @GetMapping("/get/{id}")
//	  public Product findByIdd(@PathVariable("id") Long id) {
//	    return productService.findByIdUser(id);
//	  }
//
//	@GetMapping("/findByUsername/{productname}")
//	public Product findByUsername(@PathVariable("productname") String productname) {
//		return productService.findByProductName(productname);
//	}
////	@GetMapping("/randomProducts")
////    public Product getRandomProduct() {
////        return  productService.getRandomProduct();
////    }
//	  
//	  @GetMapping("/randomProducts/{count}")
//	    public List<Product> getRandomProduct(@PathVariable("count") int count) {
//	        return  productService.getRandomProduct( count);
//	    }
}
