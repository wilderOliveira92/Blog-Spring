package org.blog.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.blog.model.Blog;
import org.blog.model.Comentario;
import org.blog.model.Post;

public class ComentarioDao extends DAO {
	
	String sql;
	
	public void cadastrar(Comentario coment)throws Exception{
		
		open();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		sql = "insert into tb_comentario(id_post,conteudo,nome,dtcadcoment) "
				+ "select ?,?,?,now()";
		
		stmt = con.prepareStatement(sql);		
		
		stmt.setInt(1, coment.getPost().getIdPost() );
		stmt.setString(2, coment.getConteudo());
		stmt.setString(3, coment.getNome());
		//stmt.setString(4, sdf.format(coment.getDataCadComent()));
		
		stmt.execute();
		
		close();
	}
	
	
	public void alterar(Comentario coment)throws Exception{
		
		open();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		
		sql = "update tb_comentario"
				+ " set id_post = ?,"
				+ "		conteudo = ?,"
				+ "		nome = ?,"				
				+ "		dtcadcoment = now()"
				+ "where id_coment = ? ";
				
		
		stmt = con.prepareStatement(sql);
		
		stmt.setInt(1, coment.getPost().getIdPost() );
		stmt.setString(2, coment.getConteudo());
		stmt.setString(3, coment.getNome());
		//stmt.setString(4, sdf.format(coment.getDataCadComent()));
		stmt.setInt(4, coment.getIdComent());
		
		stmt.execute();
		
		close();
	}
	
	
	public Comentario consultarPorId(Integer id) throws Exception{
		
		Comentario coment= null;
		Post post = null;		
		PostDao postD = new PostDao();
		
		sql = "Select * from tb_comentario where id_coment = ?";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		
		rs = stmt.executeQuery();
		
		if(rs.next()) {
			
			coment.setIdComent(rs.getInt("idComent"));
			coment.setConteudo(rs.getString("conteudo"));
			coment.setNome(rs.getString("nome"));
			coment.setDataCadComent(rs.getDate("dtcadcoment"));
			
			post = postD.consultarPorId(rs.getInt("id_post"));			
			coment.setPost(post);
			
		}
		
		
		return coment;
		
	}

	
public List<Comentario> listar() throws Exception{
		
		List<Comentario> lista = new ArrayList<>();
		
		sql = "Select * from tb_comentario";
		stmt = con.prepareStatement(sql);
		
		
		rs = stmt.executeQuery();
		
		while(rs.next()) {

			Comentario coment= null;
			Post post = null;		
			PostDao postD = new PostDao();
			
			coment.setIdComent(rs.getInt("idComent"));
			coment.setConteudo(rs.getString("conteudo"));
			coment.setNome(rs.getString("nome"));
			coment.setDataCadComent(rs.getDate("dtcadcoment"));
			
			post = postD.consultarPorId(rs.getInt("id_post"));			
			coment.setPost(post);

			
			lista.add(coment);
		}
		
		
		return lista;
		
	}


}
