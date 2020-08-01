package com.iacg.repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iacg.mappers.GrupoPermisoMapper;
import com.iacg.model.GrupoPermiso;

@Repository
public class GrupoPermisoRepository implements GrupoPermisoRep{
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void postConstruc() {
		jdbcTemplate =  new JdbcTemplate(dataSource);
	}

	@Override
	public boolean save(GrupoPermiso object) {
		try {
			String sql = String.format("INSERT INTO grupo_permiso (IdGrupo,IdPermiso) VALUES ('%d','%d')",
					object.getIdGrupo(),object.getIdPermiso());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(GrupoPermiso object) {
		if(object.getIdPermiso()!=0) {
			String sql = String.format("UPDATE grupo_permiso SET IdGRupo='%d' WHERE IdPermiso='%d'",
					object.getIdGrupo(),object.getIdPermiso());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<GrupoPermiso> findAll(Pageable pageable) {		
		return jdbcTemplate.query("SELECT * FROM grupo_permiso", new GrupoPermisoMapper());
	}

	@Override
	public GrupoPermiso findById(int id) {
		Object params[] = {id};
		return jdbcTemplate.queryForObject("SELECT * FROM grupo_permiso WHERE IdPermiso=?",params, new GrupoPermisoMapper());
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}
