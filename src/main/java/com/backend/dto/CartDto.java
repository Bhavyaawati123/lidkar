package com.backend.dto;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.backend.entity.Product;
import com.backend.entity.User;

public class CartDto {
	 private Long cartProductId;

	    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.DETACH)
	    @JoinColumn(name = "product_id")
	    private Product products;


	   
		public Long getCartProductId() {
			return cartProductId;
		}

		public void setCartProductId(Long cartProductId) {
			this.cartProductId = cartProductId;
		}

		public Product getProducts() {
			return products;
		}

		public void setProducts(Product products) {
			this.products = products;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		private Integer quantity;

	    @ManyToOne
	    @JoinColumn(name = "user_id")
	    
	    private User user;
}
