package com.iacg.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iacg.model.GrupoPermiso;

@Repository
public class GrupoPermisoRepository implements GrupoPermisoRep{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(GrupoPermiso object) {
		try {
			String sql = String.format("INSERT INTO grupo_permiso (IdGrupo,IdPermiso) VALUES ('%d','%d')",
					object.getIdGrupo(),object.getIdPermiso());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(GrupoPermiso object) {
		
		return false;
	}

	@Override
	public List<GrupoPermiso> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrupoPermiso findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
