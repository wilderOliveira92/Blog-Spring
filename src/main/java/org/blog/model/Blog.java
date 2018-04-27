package org.blog.model;

import java.util.Date;

public class Blog {
	
	private Integer idBlog;
	private String login;
	private String senha;
	private String nome;
	private String email;
	private Date dataCadBlog;
	
	
	
	public Blog() {
		// TODO Auto-generated constructor stub
	}
	

	public Blog(Integer idBlog, String login, String senha, String nome, String email, Date dataCadBlog) {
		super();
		this.idBlog = idBlog;
		this.login = login;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.dataCadBlog = dataCadBlog;
	}



	public Integer getIdBlog() {
		return idBlog;
	}

	public void setIdBlog(Integer idBlog) {
		this.idBlog = idBlog;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadBlog() {
		return dataCadBlog;
	}

	public void setDataCadBlog(Date dataCadBlog) {
		this.dataCadBlog = dataCadBlog;
	}
	

	

}
