package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class ProductPackFlavorOrder implements Serializable {

	@EmbeddedId
	ProductPackFlavorOrderId productPackFlavorOrderId = new ProductPackFlavorOrderId();
	
	@Column(nullable = false)
	private short quantity;
	
	public short getQuantity() {
		return quantity;
	}
	
	public void setQuantity(short quantity) {
		this.quantity = quantity;
	}
	
	public ProductPackFlavorOrderId getProductPackFlavorOrderId() {
		return productPackFlavorOrderId;
	}

	public void setProductPackFlavorOrderId(ProductPackFlavorOrderId productPackFlavorOrderId) {
		this.productPackFlavorOrderId = productPackFlavorOrderId;
	}

	@Override
	public String toString(){
		return "[ProductPackFlavorOrder : " + this.productPackFlavorOrderId.toString() + ", " + this.getQuantity() + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductPackFlavorOrder other = (ProductPackFlavorOrder) obj;
		if (productPackFlavorOrderId == null) {
			if (other.productPackFlavorOrderId != null)
				return false;
		} else if (!productPackFlavorOrderId.equals(other.productPackFlavorOrderId))
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productPackFlavorOrderId == null) ? 0 : productPackFlavorOrderId.hashCode());
		return result;
	}

}
