package com.example.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class ProductPackFlavorId implements Serializable{

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "flavorId", insertable = false, updatable = false)
	private Flavor flavor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ 
		@JoinColumn(name = "packId", insertable = false, updatable = false),
		@JoinColumn(name = "productId", insertable = false, updatable = false) })
	private ProductPack productPack;
	
	public ProductPackFlavorId(){
	}
	
	public ProductPackFlavorId(ProductPack productPack, Flavor flavor){
		this.productPack = productPack;
		this.flavor = flavor;
	}

	public Flavor getFlavor() {
		return flavor;
	}

	public void setFlavor(Flavor flavorId) {
		this.flavor = flavorId;
	}

	public ProductPack getProductPack() {
		return productPack;
	}

	public void setProductPack(ProductPack productPack) {
		this.productPack = productPack;
	}
	
	public String toString(){
		return flavor.toString() + ", " + productPack.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductPackFlavorId other = (ProductPackFlavorId) obj;
		if (flavor == null) {
			if (other.flavor != null)
				return false;
		} else if (!flavor.equals(other.flavor))
			return false;
		if (productPack == null) {
			if (other.productPack != null)
				return false;
		} else if (!productPack.equals(other.productPack))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
		result = prime * result + ((productPack == null) ? 0 : productPack.hashCode());
		return result;
	}

}
