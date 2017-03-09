package com.example.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class ProductPackFlavorOrderId implements Serializable{

	@ManyToOne
	@JoinColumn(name = "orderId", insertable = false, updatable = false)
	private Order order;
	
	@ManyToOne
	@JoinColumns({ 
		@JoinColumn(name = "packId", insertable = false, updatable = false),
		@JoinColumn(name = "productId", insertable = false, updatable = false), 
		@JoinColumn(name = "flavorId", insertable = false, updatable = false)})
	private ProductPackFlavor productPackFlavor;
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	public ProductPackFlavor getProductPackFlavor() {
		return productPackFlavor;
	}

	public void setProductPackFlavor(ProductPackFlavor productPackFlavor) {
		this.productPackFlavor = productPackFlavor;
	}
	
	@Override
	public String toString(){
		return order.toString() + ", " + productPackFlavor.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((productPackFlavor == null) ? 0 : productPackFlavor.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductPackFlavorOrderId other = (ProductPackFlavorOrderId) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (productPackFlavor == null) {
			if (other.productPackFlavor != null)
				return false;
		} else if (!productPackFlavor.equals(other.productPackFlavor))
			return false;
		return true;
	}
	
}
