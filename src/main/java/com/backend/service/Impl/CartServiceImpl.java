package com.backend.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.dto.CartDto;
import com.backend.dto.ImagesDto;
import com.backend.entity.Cart;
import com.backend.entity.Category;
import com.backend.entity.Image;
import com.backend.entity.Product;
import com.backend.entity.User;
import com.backend.exceptions.ResourceNotFoundException;
import com.backend.repository.CartRepo;
import com.backend.repository.ProductRepository;
import com.backend.repository.UserRepo;
import com.backend.service.CartService;

@Service
public class CartServiceImpl implements CartService{
	@Autowired
	CartRepo cartRepositories;
	@Autowired
	UserRepo userRepositories;
	@Autowired
    private ProductRepository productRepo;


    @Autowired
    private ModelMapper modelMapper;

	@Override
	public CartDto createCategory(CartDto cartDto, Long UserId, Long productId) {
		
		        if (UserId == null || productId == null) {
		            throw new IllegalArgumentException("userId and productId cannot be null.");
		        }

		      
		        User user = userRepositories.findById(UserId)
		                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", UserId));

		    
		        Product product = productRepo.findById(productId)
		                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", productId));

		       

		        
		        Cart cart=dtoToCategory(cartDto);
		        cart.setProduct(product);
		        cart.setUser(user);

		      
		        Cart savedProduct = cartRepositories.save(cart);

		        return categoryToDto(savedProduct);
		    }
		    
	    
		
	

	@Override
	public List<CartDto> getAllCategories() {
		List<Cart> categories = cartRepositories.findAll();
	    return categories.stream()
	            .map(this::categoryToDto)
	            .collect(Collectors.toList());
}

	@Override
	public CartDto getCategoryById(Long cartId) {
		Cart category = cartRepositories.findById(cartId)
	            .orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", cartId));
	    return categoryToDto(category);
	}

	@Override
	public String deleteCategory(Long cartId) {
		Cart category = cartRepositories.findById( cartId)
	            .orElseThrow(() -> new ResourceNotFoundException("Category", "imageId",  cartId));
		cartRepositories.delete(category);
	    return "The Category is deleted Successfully";
	}

	public CartDto categoryToDto(Cart savedCategory) {
	    return modelMapper.map(savedCategory, CartDto.class);
	}

	public Cart dtoToCategory(CartDto cartDto) {
	    return modelMapper.map(cartDto, Cart.class);
	}










}
