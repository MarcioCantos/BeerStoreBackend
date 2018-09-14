package com.vd0.beerstore.entity.beer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoCerveja {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String tipoCerveja;
	
	public Long getId() {
		return this.id;
	}
	
	public String getTipoCerveja() {
		return this.tipoCerveja;
	}
	
	public void setTipoCerveja(String tipoCerveja) {
		this.tipoCerveja = tipoCerveja;
	}

}
