package org.blog.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.blog.model.Blog;
import org.blog.utils.Util;

public class BlogDao extends DAO{

	String sql;
	
	public void cadastrar(Blog blog)throws Exception{
	
		open();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		sql = "insert into tb_blog(login,senha,email,nome,dtcadblog) "
				+ "select  ?,?,?,?,now() ";
		
		stmt = con.prepareStatement(sql);		
		
		stmt.setString(1, blog.getLogin());
		stmt.setString(2, blog.getSenha());
		stmt.setString(3, blog.getEmail());
		stmt.setString(4, blog.getNome());
		//stmt.setString(5, sdf.format(date));
		
		stmt.execute();
		
		close();
	}
	
	
	public void alterar(Blog blog)throws Exception{
		
		open();
		
		sql = "update tb_blog"
				+ " set login = ?,"
				+ "		senha = ?,"
				+ "		email = ?,"
				+ "		nome = ?,"
				+ "		dtcadblog = now()"
				+ "where id_blog = ? ";
				
		
		stmt = con.prepareStatement(sql);
		stmt.setString(1, blog.getLogin());
		stmt.setString(2, blog.getSenha());
		stmt.setString(3, blog.getEmail());
		stmt.setString(4, blog.getNome());
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		//stmt.setString(5, sdf.format(blog.getDataCadBlog()));
		stmt.setInt(5, blog.getIdBlog());
		
		stmt.execute();
		
		close();
	}
	
	
	public Blog consultarPorId(Integer id) throws Exception{
		
		Blog blog = null;
		
		sql = "Select * from tb_blog where id_blog = ?";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			blog.setIdBlog(rs.getInt("id_blog"));
			blog.setLogin(rs.getString("login"));
			blog.setSenha(rs.getString("senha"));
			blog.setEmail(rs.getString("email"));
			blog.setNome(rs.getString("nome"));
			blog.setDataCadBlog(rs.getDate("dtcadblog"));
			
		}
		
		
		return blog;
		
	}

	
public List<Blog> listar() throws Exception{
		
		List<Blog> lista = new ArrayList<>();
		
		sql = "Select * from tb_blog order by datacadblog";
		stmt = con.prepareStatement(sql);
		
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {
			Blog blog = new Blog();
			blog.setIdBlog(rs.getInt("id_blog"));
			blog.setLogin(rs.getString("login"));
			blog.setSenha(rs.getString("senha"));
			blog.setEmail(rs.getString("email"));
			blog.setNome(rs.getString("nome"));
			blog.setDataCadBlog(rs.getDate("dtcadblog"));
			lista.add(blog);
		}
		
		
		return lista;
		
	}

	
}
