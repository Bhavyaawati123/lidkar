package com.backend.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
	@Table(name = "asmit_product")
	public class Product {
	    
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(unique = true, nullable = false)
	    private Long productId;

	    private String productName;

	    private String productUrl;
	    private String productDetails;
	    @ManyToOne
	    @JoinColumn(name="category_id")
		private Category category;
	   

		public Product(Long productId, String productName, String productUrl, String productDetails, Category category,
				 List<Image> images) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productUrl = productUrl;
			this.productDetails = productDetails;
			this.category = category;
			
			this.images = images;
		}

		@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Cart> cart;
	    
	    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    private List<Image> images;
	    
		
		
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public List<Image> getImages() {
			return images;
		}
		public void setImages(List<Image> images) {
			this.images = images;
		}
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
		public String getProductUrl() {
			return productUrl;
		}
		public void setProductUrl(String productUrl) {
			this.productUrl = productUrl;
		}
		public String getProductDetails() {
			return productDetails;
		}
		public void setProductDetails(String productDetails) {
			this.productDetails = productDetails;
		}
		
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
		

		

	

	
}

	   


