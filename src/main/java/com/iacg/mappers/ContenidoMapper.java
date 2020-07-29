package com.iacg.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iacg.model.Contenido;

public class ContenidoMapper implements RowMapper<Contenido>{

	@Override
	public Contenido mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contenido contenido = new Contenido();
		contenido.setIdContenido(rs.getInt("IdContenido"));
		contenido.setContenido(rs.getString("Contenido"));
		contenido.setTipo(rs.getString("Tipo"));
		contenido.setIdPost(rs.getInt("IdPost"));
		return contenido;
	}

}
