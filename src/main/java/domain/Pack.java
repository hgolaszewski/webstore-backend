package domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity
public class Pack implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private short id;

	@Column(name = "size", columnDefinition = "decimal(4,0)", nullable = false)
	private short size;

	
	@Column(name = "type", columnDefinition="enum('gram','kaps','ml','saszetek')", nullable = false)
	@Enumerated(EnumType.STRING)
	private Type type;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "productPackId.pack")
	private Set<ProductPack> productsPacks = new HashSet<>(0);
	
	public Pack(){
		
	}
	
	public Pack(short size, Type type) {
		this.size = size;
		this.type = type;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public short getSize() {
		return size;
	}

	public void setSize(short size) {
		this.size = size;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Set<ProductPack> getProductsPacks() {
		return productsPacks;
	}

	public void setProductsPacks(Set<ProductPack> productsPacks) {
		this.productsPacks = productsPacks;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pack other = (Pack) obj;
		if (id != other.id)
			return false;
		if (size != other.size)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[Pack: " + id + ", " + size + ", " + type + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + size;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

}
