package vhcsoft.blog.oa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import vhcsoft.blog.oa.controller.Views;

@Entity(name = "ORDERS")
public class Order  implements Serializable{

	private static final long serialVersionUID = 5625402399571176471L;

	@JsonView(Views.Public.class)
	@Id
	@GeneratedValue
	private Long id;

	@JsonView(Views.Public.class)
	private String orderDetail;
	
	@JsonView(Views.Public.class)
	@OneToMany(mappedBy="order", orphanRemoval=true, cascade =CascadeType.ALL)
	private List<OrderItem> items = new ArrayList<>();
	
	
	private String owner;
	
	public List<OrderItem> getItems() {
		return items;
	}

	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(String orderDetail) {
		this.orderDetail = orderDetail;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderDetail=" + orderDetail + ", items=" + items + ", owner=" + owner + "]";
	}

	


}
