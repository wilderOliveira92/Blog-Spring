package org.blog.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.blog.model.Blog;
import org.blog.model.Comentario;
import org.blog.model.Post;
import org.blog.utils.Util;


public class Main {
	
	
	    public static void main(String[] args)
	    {
	    	/*
	        String driver = "org.postgresql.Driver";
	        String user   = "postgres";
	        String senha = "admin";
	        String url  = "jdbc:postgresql://localhost:5432/db_blog";
	        PreparedStatement stmt;
	        try
	        {
	            Class.forName(driver);
	            Connection con = null;
	            con = (Connection) DriverManager.getConnection(url, user, senha);
	            
	            
	            
	            
	            System.out.println("Conexão realizada com sucesso.");
	        }
	        catch (ClassNotFoundException ex)
	        {
	            System.err.print(ex.getMessage());
	        } 
	        catch (SQLException e)
	        {
	            System.err.print(e.getMessage());
	        }
	        */
	    	
	    	/*
	    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			Date date = new Date(); 
			
			Blog blog = new Blog();
			blog.setIdBlog(1);
			blog.setLogin("wilder");
			blog.setSenha("123");
			blog.setNome("wilder");
			blog.setEmail("dasdas@dasd.com");
			blog.setDataCadBlog(date);
			
			
			try {
				BlogDao blogD = new BlogDao();
				blogD.cadastrar(blog);
				System.out.println("Blog cadastrado");
			}catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
			
			Post post = new Post(null, "Teste", "dadsad a sdaad ", null, blog);
			PostDao pd = new PostDao();
			
			try {				
				pd.cadastrar(post);
				System.out.println("Post cadastrado");
			}catch (Exception e) {
				System.out.println(e.getMessage());	
			}
	    	*/
	    	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
			Date date = new Date(); 
			
	    	
	    	Blog blog = new Blog();
			blog.setIdBlog(1);
			blog.setLogin("wilder");
			blog.setSenha("123");
			blog.setNome("wilder");
			blog.setEmail("dasdas@dasd.com");
			blog.setDataCadBlog(date);
			
			
	    	Post post = new Post(1, "Teste", "dadsad a sdaad ", null, blog);
			Comentario coment = new Comentario(null, "sdasd", "", null, post);
			ComentarioDao cd = new ComentarioDao();
			
			try {				
				cd.cadastrar(coment);
				System.out.println("comentario cadastrado");
			}catch (Exception e) {
				System.out.println(e.getMessage());	
			}
	    }
	}
	
