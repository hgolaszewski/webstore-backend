package com.example.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = {"name", "producerId"}) })
public class Product implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private short id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId", nullable = false)
	private Category category;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "producerId", nullable = false)
	private Producer producer;
	
	@Column(name = "name", unique = true, nullable = false, length = 45)
	private String name;
	
	@Column(name = "description", nullable = true, columnDefinition = "TEXT")
	private String description;

	@JsonManagedReference
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product", cascade=CascadeType.ALL)
	private Set<Opinion> opinions = new HashSet<>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "productPackId.product", cascade=CascadeType.ALL)
	private Set<ProductPack> productsPacks = new HashSet<>(0);
	
	public Product(){
	}
	
	public Product(Category category, Producer producer, String name, String description){
		this.category = category;
		this.producer = producer;
		this.name = name;
		this.description = description;
	}
	
	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Set<Opinion> getOpinions() {
		return opinions;
	}

	public void setOpinions(Set<Opinion> opinions) {
		this.opinions = opinions;
	}
	
	
	public Set<ProductPack> getProductsPacks() {
		return productsPacks;
	}

	public void setProductsPacks(Set<ProductPack> productsPacks) {
		this.productsPacks = productsPacks;
	}

	@Override
	public String toString(){
		return "[Product: "+ id +", " + name +", "+ description +", " + producer.toString()+", " +category.toString()+"]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((producer == null) ? 0 : producer.hashCode());
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (producer == null) {
			if (other.producer != null)
				return false;
		} else if (!producer.equals(other.producer))
			return false;
		return true;
	}
}
