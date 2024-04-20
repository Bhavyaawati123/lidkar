package com.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.dto.CategoryDto;
import com.backend.dto.ProductDto;
import com.backend.entity.Product;
import com.backend.service.ProductService;





@RestController
@RequestMapping("/api/product")
@CrossOrigin("*")
public class ProductController {

	@Autowired
	ProductService productService;

 @PostMapping("/create/{categoryId}")
	    public ResponseEntity<ProductDto> createProduct(@Validated @RequestBody ProductDto productDto ,@PathVariable("categoryId") Long categoryId) {
	                                                    
	        try {
	          
	            ProductDto createdProduct = productService.createProduct(productDto,categoryId);
	           
	            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	        } catch (Exception e) {
	            
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
//	    @PutMapping("/update/{CategoryId}")
//	    public ResponseEntity<C> updateCategory(@PathVariable Long CategoryId ,@RequestBody CategoryDto categoryDto){
//
//
//	       try {
//	        CategoryDto updated =this.productService.updateCategory(CategoryId, categoryDto);
//	        return new ResponseEntity<>(updated,HttpStatus.ACCEPTED);
//	       } catch (Exception e) {
//	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	       } 
//
//	    }
	    
	    @GetMapping("/all")
	    public ResponseEntity<List<ProductDto>> GetAllCategories(){



	       try {
	       List< ProductDto > categoryList =this.productService.getAllCategories();
	        return new ResponseEntity<>(categoryList,HttpStatus.OK);
	       } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	       } 

	    }
	    @GetMapping("/getCategory/{ProductId}")
	    public ResponseEntity<ProductDto> GetAllCategories(@PathVariable Long ProductId){


	       try {
	    	   ProductDto  categoryList =this.productService.getCategoryById(ProductId);
	        return new ResponseEntity<>(categoryList,HttpStatus.OK);
	       } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	       } 

	    }
	    
}
