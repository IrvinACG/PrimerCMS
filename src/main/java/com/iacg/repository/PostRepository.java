package com.iacg.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iacg.mappers.PostMapper;
import com.iacg.model.Post;

@Repository
public class PostRepository implements PostRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Post object) {
		try {
			String sql = String.format("INSERT INTO post (Titulo,Slug,Extracto,IdUsuario,Categoria,ImagenDestacada,Tipo) "
					+ "VALUES ('%s','%s','%s','%d','%d','%s','%s')"
					, object.getTitulo(),object.getSlug(),object.getExtracto(),object.getIdUsuario(),object.getCategoria(),
					object.getImagenDestacada(),object.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Post object) {
		if(object.getIdPost()!=0) {
			String sql = String.format("UPDATE post SET Titulo='%s', Slug='%s', Extracto='%s', IdUsuario='%d', Categoria='%d', "
					+ "ImagenDestacada='%s', Tipo='%s' "
					+ "WHERE IdPost='%d'",
					object.getTitulo(),object.getSlug(),object.getExtracto(),object.getIdUsuario(),object.getCategoria(),
					object.getImagenDestacada(),object.getTipo(),
					object.getIdPost());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Post> findAll(Pageable pageable) {		
		return jdbcTemplate.query("SELEC * FROM post", new PostMapper());
	}

	@Override
	public Post findById(int id) {
		Object params[] = {id};
		return jdbcTemplate.queryForObject("SELECT * FROM post WHERE IdPost=?",params, new PostMapper());
	}
}
