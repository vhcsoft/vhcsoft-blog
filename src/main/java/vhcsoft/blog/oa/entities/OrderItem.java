package vhcsoft.blog.oa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;

import vhcsoft.blog.oa.controller.Views;

@Entity(name="ORDERITEMS")
public class OrderItem {

	@JsonView(Views.Public.class)
	@Id
	@GeneratedValue
	private Long id;
	
	@JsonView(Views.Public.class)
	private String productName;
	
	@JsonView(Views.Public.class)
	private Double price ;
	private Integer amount;
	
	@ManyToOne
	private Order order;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
