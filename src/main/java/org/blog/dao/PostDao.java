package org.blog.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.blog.model.Blog;
import org.blog.model.Post;

public class PostDao extends DAO{

	String sql;
	
	public void cadastrar(Post post)throws Exception{
		
		open();
		
		sql = "insert into tb_post(id_blog,titulo,conteudo,dtcadpost) "
				+ "select ?,?,?,now()";
		
		stmt = con.prepareStatement(sql);		
		
		stmt.setInt(1, post.getBlog().getIdBlog());
		stmt.setString(2, post.getTitulo());
		stmt.setString(3, post.getConteudo());		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		//stmt.setString(4, sdf.format(post.getDataCadPost()));
		
		stmt.execute();
		
		close();
	}
	
	
	public void alterar(Post post)throws Exception{
		
		open();
		
		sql = "update tb_post"
				+ " set id_blog = ?,"
				+ "		titulo = ?,"
				+ "		conteudo = ?,"				
				+ "		dtcadpost = now()"
				+ "where id_post = ? ";
				
		
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, post.getBlog().getIdBlog());
		stmt.setString(2, post.getTitulo());
		stmt.setString(3, post.getConteudo());		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		//stmt.setString(4, sdf.format(post.getDataCadPost()));
		stmt.setInt(4, post.getIdPost());
		
		stmt.execute();
		
		close();
	}
	
	
	public Post consultarPorId(Integer id) throws Exception{
		
		Post post = null;
		Blog blog = null;
		BlogDao blogD = new BlogDao();
		
		sql = "Select * from tb_post where id_post = ?";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			post.setIdPost(rs.getInt("id_post"));			
			post.setTitulo(rs.getString("titulo"));
			post.setConteudo(rs.getString("conteudo"));			
			post.setDataCadPost(rs.getDate("dtcadpost"));
			
			blog = blogD.consultarPorId(rs.getInt("id_blog"));			
			post.setBlog(blog);
			
		}
		
		
		return post;
		
	}

	
public List<Post> listar() throws Exception{
		
		List<Post> lista = new ArrayList<>();
		
		sql = "Select * from tb_blog order by datacadblog";
		stmt = con.prepareStatement(sql);
		
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {

			Post post= new Post();
			Blog blog = null;
			BlogDao blogD = new BlogDao();
			
			post.setIdPost(rs.getInt("id_post"));			
			post.setTitulo(rs.getString("titulo"));
			post.setConteudo(rs.getString("conteudo"));			
			post.setDataCadPost(rs.getDate("dtcadpost"));
			
			blog = blogD.consultarPorId(rs.getInt("id_blog"));			
			post.setBlog(blog);

			
			lista.add(post);
		}
		
		
		return lista;
		
	}


}
