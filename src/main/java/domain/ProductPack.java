package domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
public class ProductPack implements Serializable {

	@Column(name = "image", nullable = true, columnDefinition = "BLOB")
	private byte[] image;
	@Column(name = "price", nullable = false, columnDefinition = "decimal(5,2)")
	private float price;

	@EmbeddedId
	ProductPackId productPackId = new ProductPackId();

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "productPackFlavorId.productPack")
	private Set<ProductPackFlavor> productsPacksFlavor = new HashSet<>(0);

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Transient
	public Product getProduct() {
		return productPackId.getProduct();
	}

	public void setProduct(Product product) {
		this.productPackId.setProduct(product);
	}

	@Transient
	public Pack getPack() {
		return productPackId.getPack();
	}

	public void setPack(Pack pack) {
		this.productPackId.setPack(pack);
	}

	public ProductPackId getProductPackId() {
		return productPackId;
	}

	public void setProductPackId(ProductPackId productPackId) {
		this.productPackId = productPackId;
	}

	public Set<ProductPackFlavor> getProductsPacksFlavor() {
		return productsPacksFlavor;
	}

	public void setProductsPacksFlavor(Set<ProductPackFlavor> productsPacksFlavor) {
		this.productsPacksFlavor = productsPacksFlavor;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductPack other = (ProductPack) obj;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (productPackId == null) {
			if (other.productPackId != null)
				return false;
		} else if (!productPackId.equals(other.productPackId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[ProductPack: " + productPackId.toString() + ", " + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((productPackId == null) ? 0 : productPackId.hashCode());
		return result;
	}
}
