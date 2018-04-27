package org.blog.model;

import java.util.Date;

public class Comentario {

	private Integer idComent;
	private String conteudo;
	private String nome;
	private Date dataCadComent;
	
	private Post post;
	
	
	public Comentario() {
		// TODO Auto-generated constructor stub
	}


	public Comentario(Integer idComent, String conteudo, String nome, Date dataCadComent, Post post) {
		super();
		this.idComent = idComent;
		this.conteudo = conteudo;
		this.nome = nome;
		this.dataCadComent = dataCadComent;
		this.post = post;
	}


	public Integer getIdComent() {
		return idComent;
	}


	public void setIdComent(Integer idComent) {
		this.idComent = idComent;
	}


	public String getConteudo() {
		return conteudo;
	}


	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Date getDataCadComent() {
		return dataCadComent;
	}


	public void setDataCadComent(Date dataCadComent) {
		this.dataCadComent = dataCadComent;
	}


	public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}
	
	
	
}
