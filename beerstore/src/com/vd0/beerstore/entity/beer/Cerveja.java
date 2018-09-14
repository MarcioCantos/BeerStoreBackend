package com.vd0.beerstore.entity.beer;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cerveja {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	private Double valor;
	
	@OneToMany(mappedBy="cerveja", cascade = CascadeType.ALL)
	private List<Imagens> imagens;	
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	public List<Imagens> getImagens() {
		return imagens;
	}
	
	public void setImagens(List<Imagens> imagens) {
		this.imagens = imagens;
	}
	
	public Long getId() {
		return id;
	}
	
	
}
