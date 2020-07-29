package com.iacg.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iacg.model.Categoria;

public class CategoriaMapper implements RowMapper<Categoria>{

	@Override
	public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(rs.getInt("IdCategoria"));
		categoria.setNombre("Nombre");
		categoria.setDescripcion("Descripcion");
		categoria.setFecha(rs.getDate("Fecha"));
		categoria.setCategoriaSuperior(rs.getInt("CategoriaSuperior"));
		return categoria;
	}

}
