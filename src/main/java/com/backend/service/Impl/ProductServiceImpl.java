package com.backend.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entity.Product;
import com.backend.repository.ProductRepository;
import com.backend.service.ProductService;

import java.util.Random;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepositories;

	// @Override
	// public User createUser(User user) {
//	       User save = this.userRepositories.save(user);
//	       return save;
	// }

	@Override
	public Product createProduct(Product product) {
		// User userAlreadyExists = userRepositories.findByUsername(user.getUsername())
		// .orElseThrow(null);
		// if (userAlreadyExists != null) {
		// return null;
		// }

		productRepositories.save(product);
		return product;
	}

//	@Override
//	public Product updateProduct(Long userId, Product product) {
//		Optional<Product> byId = this.productRepositories.findById(userId);
//		Product product1 = byId.get();
//
//		product1.setProductName(product.getProductName());
//		product1.setProductCode(product.getProductCode());
//
//		Product save = this.productRepositories.save(product1);
//		return save;
//	}

	@Override
	public Product updateProduct(Long productId, Product product) {
		Optional<Product> byId = this.productRepositories.findById(productId);
		Product product2 = byId.get();
		product2.setProductAddress(product.getProductAddress());
		product2.setProductName(product.getProductName());
		product2.setProductPhone(product.getProductPhone());
		Product save = this.productRepositories.save(product2);
		return save;
	}

	@Override
	public void deleteUser(Long userId) {
		Product isUserExists = this.productRepositories.findById(userId).orElseThrow(null);
		this.productRepositories.delete(isUserExists);
	}

	@Override
	public List<Product> fetchAllProduct() {
		List<Product> users = this.productRepositories.findAll();
		return users;
	}

//	@Override
//	public Product findByIdUser(Long userid) {
//		Product user = productRepositories.findById(userid)
//				.orElseThrow(() -> new ProductNameNotFoundException("id not found in database"));
//		
//		return user;
//	}

//	@Override
//	public Product findByProductName(String productname) {
//		Product user3 = this.productRepositories.findByProductName(productname)
//				.orElseThrow(() -> new ProductNameNotFoundException("name not found in database"));
//		return user3;
//	}
//
//	
//	public Product findByProductName1(String productname) {
//		Optional<Product> product = this.productRepositories.findByProductName(productname);
//		Product myProduct = product.get();
//		if (product.isEmpty()) {
//			throw new ProductNameNotFoundException("name not found in database");
//		}
//
//		return myProduct;
//
//	}

//	@Override
//	public Product getRandomProduct() {
//		List<Product> allProducts = productRepositories.findAll();
//		  if (allProducts.isEmpty()) {
//			  throw  new ProductNameNotFoundException("data not found in database");//data not found exception
//	        }
//        Random random = new Random();
//        int randomIndex = random.nextInt(allProducts.size());
//        return allProducts.get(randomIndex);
//      
//	}

//	@Override
//    public  List<Product> getRandomProduct(int count){
//        List<Product> allProducts =  productRepositories.findAll();
//        if (allProducts.isEmpty()) {
//            throw new ProductNameNotFoundException("Data not found in database");
//        }
//
//        count = Math.min(count, allProducts.size());
//
//        Random random = new Random();
//        List<Product> randomProducts = new ArrayList<>();
//
//       
//        for (int i = 0; i < count; i++) {
//            int randomIndex = random.nextInt(allProducts.size());
//            randomProducts.add(allProducts.get(randomIndex));
//          
//            allProducts.remove(randomIndex);
//        }
//
//        return randomProducts;
//    }
}
