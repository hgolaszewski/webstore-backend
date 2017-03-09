package com.example.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class ProductPackFlavor implements Serializable{
	
	
	@EmbeddedId
	ProductPackFlavorId productPackFlavorId = new ProductPackFlavorId();
	
	@Temporal(TemporalType.DATE)
	private Date exp;
	
	private short quantity;


	public Flavor getFlavor() {
		return productPackFlavorId.getFlavor();
	}

	public void setFlavor(Flavor flavor) {
		this.productPackFlavorId.setFlavor(flavor);
	}

	public ProductPack getProductPack() {
		return productPackFlavorId.getProductPack();
	}

	public void setProductPack(ProductPack productPack) {
		this.productPackFlavorId.setProductPack(productPack);
	}

	public Date getExp() {
		return exp;
	}

	public void setExp(Date exp) {
		this.exp = exp;
	}

	public short getQuantity() {
		return quantity;
	}

	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "[ProductPack: " + productPackFlavorId.toString() + ", " + exp + quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exp == null) ? 0 : exp.hashCode());
		result = prime * result + ((productPackFlavorId == null) ? 0 : productPackFlavorId.hashCode());
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
		ProductPackFlavor other = (ProductPackFlavor) obj;
		if (exp == null) {
			if (other.exp != null)
				return false;
		} else if (!exp.equals(other.exp))
			return false;
		if (productPackFlavorId == null) {
			if (other.productPackFlavorId != null)
				return false;
		} else if (!productPackFlavorId.equals(other.productPackFlavorId))
			return false;
		return true;
	}

}
