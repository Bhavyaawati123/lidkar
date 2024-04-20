package com.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.entity.Product;




@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//	Optional<Product> findByProductName(String productname);
	
////	Jpa Query
//	Product findByProductPhone(String productPhone);
//	
////	Native Query
//    @Query("SELECT p FROM Product p WHERE p.phoneNumber = :productPhone")
//	Product findByPhoneNumber(@Param("productPhone") String productPhone);

	
}
