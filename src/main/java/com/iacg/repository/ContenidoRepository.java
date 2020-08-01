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

import com.iacg.mappers.ContenidoMapper;
import com.iacg.model.Contenido;

@Repository
public class ContenidoRepository implements ContenidoRep{
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void postConstruc() {
		jdbcTemplate =  new JdbcTemplate(dataSource);
	}
	@Override
	public boolean save(Contenido object) {
		try {
			String sql = String.format("INSERT INTO contenido (Tipo,Contenido,IdPost) VALUES('%s','%s','%d')",
					object.getTipo(),object.getContenido(),object.getIdPost());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(Contenido object) {
		if(object.getIdContenido()!=0) {
			String sql = String.format("UPDATE contenido SET Tipo='%s', Contenido='%s' "
					+ "WHERE IdContenido='%d'",
					object.getTipo(),object.getContenido(),
					object.getIdContenido());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Contenido> findAll(Pageable pageable) {		
		return jdbcTemplate.query("SELECT * FROM contenido", new ContenidoMapper());
	}

	@Override
	public Contenido findById(int id) {
		Object params[] = {id};
		return jdbcTemplate.queryForObject("SELECT * FROM contenido WHERE IdContenido=?",params, new ContenidoMapper());
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
}
