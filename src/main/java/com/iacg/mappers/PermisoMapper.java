package com.iacg.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iacg.model.Permiso;

public class PermisoMapper implements RowMapper<Permiso>{

	@Override
	public Permiso mapRow(ResultSet rs, int rowNum) throws SQLException {
		Permiso permiso = new Permiso();
		permiso.setIdPermiso(rs.getInt("IdPermiso"));
		permiso.setNombre(rs.getString("Nombre"));
		return permiso;
	}

}
