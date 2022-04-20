package com.h2.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCTS")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="name")
	private String name;

	@Column(name="price")
	private double price;

	@Column(name="weight")
	private String weight;

	@Column(name="description")
	private String description;

	@Column(name="stock")
	private int stock;

	public ProductEntity() {}

	public ProductEntity(String name, double price, String weight,String description, int stock) {
		this.name = name;
		this.price = price;
		this.description = description;
		this.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ProductEntity [" +
				"id=" + id +
				", name=" + name +
				", price=" + price +
				", weight=" + weight +
				", description=" + description +
				", stock=" + stock +
				"]";
	}
}