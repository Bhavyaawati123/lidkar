package com.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
	@Table(name = "asmit_product")
	public class Product {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(unique = true, nullable = false)
	    private Long productId;

	    private String productName;

	    private String productPhone;
	    private String productAddress;
		public Long getProductId() {
			return productId;
		}
		public void setProductId(Long productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public String getProductPhone() {
			return productPhone;
		}
		public void setProductPhone(String productPhone) {
			this.productPhone = productPhone;
		}
		public String getProductAddress() {
			return productAddress;
		}
		public void setProductAddress(String productAddress) {
			this.productAddress = productAddress;
		}
		
	

		

	

	
}

	   


