package com.vd0.beerstore.entity.beer;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Imagens {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private Cerveja cerveja;
	private String url;
	

	public String getUrl() {
		return url;
	}
	
	public Cerveja getCerveja() {
		return cerveja;
	}
	
	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Long getId() {
		return id;
	}
	
	

}
