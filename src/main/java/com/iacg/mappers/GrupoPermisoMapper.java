package com.iacg.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iacg.model.GrupoPermiso;

public class GrupoPermisoMapper implements RowMapper<GrupoPermiso> {

	@Override
	public GrupoPermiso mapRow(ResultSet rs, int rowNum) throws SQLException {
		GrupoPermiso grupoPermiso = new GrupoPermiso();
		grupoPermiso.setIdGrupo(rs.getInt("IdGrupo"));
		grupoPermiso.setIdPermiso(rs.getInt("IdPermiso"));
		return null;
	}

}
