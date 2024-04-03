package com.backend.service;

import java.util.List;

import com.backend.entity.Product;





public interface ProductService {
   

    Product updateProduct(Long userId, Product product);

    void deleteUser(Long userId);

    List<Product> fetchAllProduct();

//    Product findByIdUser(Long userId);
//
//    Product findByProductName(String productname);

	Product createProduct(Product product);

//	Product getRandomProduct();

//	 List<Product> getRandomProduct(int count);
//
//	Product findByProductName1(String productname);
}


