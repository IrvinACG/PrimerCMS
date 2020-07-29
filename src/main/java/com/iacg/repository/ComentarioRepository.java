package com.iacg.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iacg.model.Comentario;

@Repository
public class ComentarioRepository implements ComentarioRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Comentario object) {
		try {
			String sql = String.format("INSERT INTO comentario (Comentario,IdUsuario,IdPost,Respuesta) "
					+ "VALUES ('%s','%d','%d','%s')",
					object.getComentario(),object.getIdUsuario(),object.getIdPost(),object.getRespuesta());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean update(Comentario object) {
		if(object.getIdComentario()!=0) {
			String sql = String.format("UPDATE comentario SET Comentario='%s', IdUsuario='%d', IdPost='%d', Respuesta='%s' "
					+ "WHERE IdComentario='%d'",
					object.getComentario(),object.getIdUsuario(),object.getIdPost(),object.getRespuesta(),
					object.getIdComentario());
				jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Comentario> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comentario findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
