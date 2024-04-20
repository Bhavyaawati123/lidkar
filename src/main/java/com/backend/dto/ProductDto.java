package com.backend.dto;

public class ProductDto {

	 private Long productId;

	    private String productName;

	    private String productUrl;
	    private String productDetails;
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
		

	

}
