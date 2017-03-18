package com.example.domain;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "`Order`")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date date;
	@Column(nullable = false)
	private char status;
	@Column(nullable = false)
	private float totalPrice;
	@OneToOne
	@JoinColumn(name = "addressId", nullable = false)
	private Address address;
	@OneToOne
	@JoinColumn(name = "shippingId", nullable = false)
	private Shipping shipping;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	
	@Override
	public String toString(){
		return "[Order : " + this.getId() + ", " + this.getDate() + ", " + this.getStatus() + ", " + this.getTotalPrice() + ", " + this.getAddress() + ", " + this.getShipping() + "]";
	}
	
	@Override
	public boolean equals(Object order){
		if(order == null) return false;
		else if(this.getClass() == order.getClass()){
			if(this.id == ((Order)order).getId()) return true;
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.getId());
	}
	
	
}

