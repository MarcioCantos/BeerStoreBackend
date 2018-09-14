package com.vd0.beerstore.entity.beer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Atributos {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="CERVEJA_ID", unique= true, nullable=true, insertable=true, updatable=true)
	private Cerveja cerveja;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="TIPOCERVEJA_ID", unique= true, nullable=true, insertable=true, updatable=true)
	private TipoCerveja tipoCerveja;
	
	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="PRODUTOR_ID", unique= true, nullable=true, insertable=true, updatable=true)
	private Produtor produtor;
	private String pais;
	private Float teorAlcoolico;
	
	
	public Cerveja getCerveja() {
		return this.cerveja;
	}
	
	public void setCerveja(Cerveja cerveja) {
		this.cerveja = cerveja;
	}
	
	public TipoCerveja getTipoCerveja() {
		return tipoCerveja;
	}
	public void setTipoCerveja(TipoCerveja tipoCerveja) {
		this.tipoCerveja = tipoCerveja;
	}
	public Produtor getProdutor() {
		return produtor;
	}
	public void setProdutor(Produtor produtor) {
		this.produtor = produtor;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public Float getTeorAlcoolico() {
		return teorAlcoolico;
	}
	public void setTeorAlcoolico(Float teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}
	public Long getId() {
		return id;
	}
	
	
}
