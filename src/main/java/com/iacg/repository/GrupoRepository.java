package com.iacg.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.iacg.mappers.GrupoMapper;
import com.iacg.model.Grupo;

@Repository
public class GrupoRepository implements GrupoRep{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Grupo object) {
		try {
			String sql = String.format("INSERT INTO grupos (Nombre) VALUES ('%s')",
					object.getNombre());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Grupo object) {
		if(object.getIdGrupo()!=0) {
			String sql = String.format("UPDATE grupos SET Nombre='%s' WHERE IdGrupo='%d'",
					object.getNombre(),object.getIdGrupo());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Grupo> findAll(Pageable pageable) {		
		return jdbcTemplate.query("SELEC * FROM grupos", new GrupoMapper());
	}

	@Override
	public Grupo findById(int id) {
		Object params[] = {id};
		return jdbcTemplate.queryForObject("SELECT * FROM grupos WHERE IdGrupo=?",params, new GrupoMapper());
	}

}
