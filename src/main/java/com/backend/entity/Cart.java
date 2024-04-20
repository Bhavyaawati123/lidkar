package com.backend.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="cart1")
public class Cart{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartProductId;

	private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "product_id")
    
    private Product product;


    public Cart(Long cartProductId, Integer quantity, User user, Product product) {
		super();
		this.cartProductId = cartProductId;
		this.quantity = quantity;
		this.user = user;
		this.product = product;
	}



	



	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Long getCartProductId() {
		return cartProductId;
	}

	public void setCartProductId(Long cartProductId) {
		this.cartProductId = cartProductId;
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







	public Product getProduct() {
		return product;
	}







	public void setProduct(Product product) {
		this.product = product;
	}

	
	

}
