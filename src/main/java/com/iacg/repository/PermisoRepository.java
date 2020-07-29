package com.iacg.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iacg.model.Permiso;

@Repository
public class PermisoRepository implements PermisoRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Permiso object) {
		try {
			String sql = String.format("INSERT INTO permisos (Nombre) VALUES ('%s') ",
					object.getNombre());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Permiso object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Permiso> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permiso findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
