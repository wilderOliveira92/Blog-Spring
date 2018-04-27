package org.blog.model;

import java.util.Date;

public class Post {

	private Integer idPost;	
	private String titulo;
	private String conteudo;
	private Date dataCadPost;
	
	private Blog blog;
	
	public Post() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Post(Integer idPost, String titulo, String conteudo, Date dataCadPost, Blog blog) {
		super();
		this.idPost = idPost;
		this.titulo = titulo;
		this.conteudo = conteudo;
		this.dataCadPost = dataCadPost;
		this.blog = blog;
	}



	public Integer getIdPost() {
		return idPost;
	}

	public void setIdPost(Integer idPost) {
		this.idPost = idPost;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public Date getDataCadPost() {
		return dataCadPost;
	}

	public void setDataCadPost(Date dataCadPost) {
		this.dataCadPost = dataCadPost;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	
	
	
	
}
