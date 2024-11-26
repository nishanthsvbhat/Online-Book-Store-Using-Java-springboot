package com.example.OBS.entity;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "buy")
public class Buy {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String title;
	private String name;
	private String email;
	private String phone;
	private BigDecimal price;
	private Integer quantity;
	private String status="Pending";
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal bigDecimal) {
		this.price = bigDecimal;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer integer) {
		this.quantity = integer;
	}
	private String address;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String Name) {
		name = Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String Email) {
		email = Email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String Address) {
		address = Address;
	}
}
