package com.daw.apimeals.order;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private long price;
	private String addres;
	private long phoneNumber;
	
	/*Falta meter la relacion entre pedidos <->menus/productos
	 * Un pedido puede tener 0 o mas productos(individuales).
	 * Un pedido puede tener 0 o mas menús-> El usuario puede optar por coger 
	 * productos individuales*/
	protected Order() {}
	
	public Order(long id,long price,String addres,long phoneNumber) {
		this.id=id;
		this.price=price;
		this.addres=addres;
		this.phoneNumber=phoneNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

}
