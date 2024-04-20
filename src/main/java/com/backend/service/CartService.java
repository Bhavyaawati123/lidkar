package com.backend.service;

import java.util.List;

import com.backend.dto.CartDto;
import com.backend.dto.CategoryDto;
import com.backend.entity.Cart;

public interface CartService {
//	Cart createProduct(Cart cart);
	CartDto createCategory(CartDto cartDto, Long UserId, Long productId);

//	CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto);

	    List<CartDto> getAllCategories();

	    CartDto getCategoryById(Long cartId);

	    String deleteCategory(Long cartId);
}
