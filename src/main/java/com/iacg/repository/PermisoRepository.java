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

import com.iacg.mappers.PermisoMapper;
import com.iacg.model.Permiso;

@Repository
public class PermisoRepository implements PermisoRep {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void postConstruc() {
		jdbcTemplate =  new JdbcTemplate(dataSource);
	}

	@Override
	public boolean save(Permiso object) {
		try {
			String sql = String.format("INSERT INTO permisos (Nombre) VALUES ('%s') ",
					object.getNombre());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Permiso object) {
		if(object.getIdPermiso()!=0) {
			String sql = String.format("UPDATE permisos SET Nombre='%s' WHERE IdPermiso='%d'",
					object.getNombre(),object.getIdPermiso());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Permiso> findAll(Pageable pageable) {		
		return jdbcTemplate.query("SELECT * FROM permisos", new PermisoMapper());
	}

	@Override
	public Permiso findById(int id) {
		Object params[] = {id};
		return jdbcTemplate.queryForObject("SELECT * FROM permisos WHERE IdPermiso=?",params, new PermisoMapper());
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
}
