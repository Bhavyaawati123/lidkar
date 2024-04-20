package com.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.CartDto;
import com.backend.dto.CategoryDto;
import com.backend.dto.ProductDto;
import com.backend.entity.Cart;
import com.backend.entity.Product;
import com.backend.service.CartService;
import com.backend.service.ProductService;

@RestController
@RequestMapping("/api/cart")

public class CartController {
	@Autowired
	CartService cartService;

	
	
	
	   @PostMapping("/create/{userId}/{productId}")
	    public ResponseEntity<CartDto> createCategory(@Validated @RequestBody CartDto cartDto ,@PathVariable("productId") Long productId ,@PathVariable("userId") Long userId){


	       try {
	    	   CartDto created =this.cartService.createCategory(cartDto,productId,userId);
	        return new ResponseEntity<>(created,HttpStatus.CREATED);
	       } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	       } 
	   }
//	    }
//	    @PutMapping("/update/{CategoryId}")
//	    public ResponseEntity<CategoryDto> updateCategory(@PathVariable Long CategoryId ,@RequestBody CategoryDto categoryDto){
//
//
//	       try {
//	        CategoryDto updated =this.categorySevice.updateCategory(CategoryId, categoryDto);
//	        return new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
//	       } catch (Exception e) {
//	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	       } 
//
//	    }
	    
	    @GetMapping("/all")
	    public ResponseEntity<List<CartDto>> GetAllCategories(){



	       try {
	       List<CartDto > categoryList =this.cartService.getAllCategories();
	        return new ResponseEntity<>(categoryList,HttpStatus.OK);
	       } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	       } 

	    }
	    @GetMapping("/getCategory/{cartId}")
	    public ResponseEntity<CartDto> GetAllCategories(@PathVariable Long cartId){


	       try {
	    	   CartDto  categoryList =this.cartService.getCategoryById(cartId);
	        return new ResponseEntity<>(categoryList,HttpStatus.OK);
	       } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	       } 

	    }
	    
}
