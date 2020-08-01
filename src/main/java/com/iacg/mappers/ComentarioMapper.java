package com.iacg.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iacg.model.Comentario;

public class ComentarioMapper implements RowMapper<Comentario> {

	@Override
	public Comentario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comentario comentario = new Comentario();
		comentario.setIdComentario(rs.getInt("IdComentario"));
		comentario.setComentario(rs.getString("Comentario"));
		comentario.setFecha(rs.getDate("Fecha"));
		comentario.setIdPost(rs.getInt("IdPost"));
		comentario.setIdUsuario(rs.getInt("IdUsuario"));
		comentario.setRespuesta(rs.getInt("Respuesta"));
		return comentario;
	}

}
