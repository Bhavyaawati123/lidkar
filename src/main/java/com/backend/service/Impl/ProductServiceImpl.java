package com.backend.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dto.CategoryDto;
import com.backend.dto.ProductDto;
import com.backend.entity.Category;
import com.backend.entity.Product;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.repository.CategoryRepo;
import com.backend.repository.ProductRepository;
import com.backend.service.ProductService;

import java.util.Random;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepositories;

	
	 @Autowired
	    private CategoryRepo categoryRepo;
	 @Autowired
	    private ProductRepository productRepo;


	    @Autowired
	    private ModelMapper modelMapper;

	   
	    
//	    @Override
//		public ProductDto createProduct(ProductDto productDto, Long categoryId) {
//	    	  Category category = this.categoryRepo.findById(categoryId)
//	    	          .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
//
//	    		    	Product product= dtoToCategory(productDto);
//	    		    	product.setCategory(category);
//	    		        Product savedCategory =  productRepo.save(product);
//	    		        return categoryToDto(savedCategory);
//		}
	    public ProductDto createProduct(ProductDto productDto, Long categoryId) {
	       
	        Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
	        if (!categoryOptional.isPresent()) {
	            throw new ResourceNotFoundException("Category", "categoryId", categoryId);
	        }

	        Category category = categoryOptional.get();

	        
	        Product product =dtoToCategory(productDto);
	        product.setCategory(category);

	      
	        Product savedProduct = productRepo.save(product);

	        return categoryToDto(savedProduct);
	    }

//	    @Override
//	    public ProductDto updateCategory(Long categoryId, ProductDto productDto) {
//
//
//	    	Category category = categoryRepo.findById(categoryId)
//	                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", categoryId));
//
//	        category.setTitle(categoryDto.getTitle());
//	        category.setDescription(categoryDto.getDescription());
//
//	        Category updatedCategory = categoryRepo.save(category);
//	        return categoryToDto(updatedCategory);
//	    }

	    @Override
	    public List<ProductDto> getAllCategories() {





	        List<Product> categories = productRepo.findAll();
	        return categories.stream()
	                .map(this::categoryToDto)
	                .collect(Collectors.toList());
	    }

	    @Override
	    public ProductDto getCategoryById(Long productId) {
	        Product category = productRepo.findById(productId)
	                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", productId));
	        return categoryToDto(category);
	    }

	    @Override
	    public String deleteCategory(Long productId) {
	        Product category = productRepo.findById(productId)
	                .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", productId));
	        productRepo.delete(category);
	        return "The Category is deleted Successfully";
	    }

	    public ProductDto categoryToDto(Product product) {
	        return modelMapper.map(product, ProductDto.class);
	    }

	    public Product dtoToCategory(ProductDto productDto) {
	        return modelMapper.map(productDto, Product.class);
	    }

		

		
}
