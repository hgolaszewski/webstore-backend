package com.example.domain;

import com.fasterxml.jackson.annotation.JsonFilter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
@JsonFilter("ProductPack")
@Entity
public class ProductPack implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private short id;

	@Column(name = "image", nullable = true, columnDefinition = "MEDIUMBLOB")
	private byte[] image;

	@Column(name = "price", nullable = false, columnDefinition = "decimal(5,2)")
	private float price;

	@Column(name = "size", columnDefinition = "decimal(4,0)", nullable = false)
	private short size;

	@Column(name = "type", columnDefinition="enum('g','kaps','ml','sasz', 'tab')", nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "productId", nullable = false)
	private Product product;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "productPackFlavorId.productPack")
	private Set<ProductPackFlavor> productsPacksFlavor = new HashSet<>(0);

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

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

	public short getSize() {return size;}

	public void setSize(short size) {this.size = size;}


	public Set<ProductPackFlavor> getProductsPacksFlavor() {
		return productsPacksFlavor;
	}

	public void setProductsPacksFlavor(Set<ProductPackFlavor> productsPacksFlavor) {
		this.productsPacksFlavor = productsPacksFlavor;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ProductPack that = (ProductPack) o;

		if (id != that.id) return false;
		if (Float.compare(that.price, price) != 0) return false;
		if (size != that.size) return false;
		return type == that.type;
	}

	@Override
	public int hashCode() {
		int result = (int) id;
		result = 31 * result + (price != +0.0f ? Float.floatToIntBits(price) : 0);
		result = 31 * result + (int) size;
		result = 31 * result + type.hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "ProductPack{" +
				"id=" + id +
				", price=" + price +
				", size=" + size +
				", type=" + type +
				", productsPacksFlavor=" + productsPacksFlavor +
				'}';
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
