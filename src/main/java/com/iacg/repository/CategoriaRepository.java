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

import com.iacg.mappers.CategoriaMapper;
import com.iacg.model.Categoria;

//@Repository
public class CategoriaRepository implements CategoriaRep{
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void postConstruc() {
		jdbcTemplate =  new JdbcTemplate(dataSource);
	}
	
	@Override
	public boolean save(Categoria categoria) {
		try {
			String sql = String.format("INSERT INTO categoria (Nombre,Descripcion,CategoriaSuperior) "
					+ "VALUES ('%s','%s','%d')",
					categoria.getNombre(),categoria.getDescripcion(),categoria.getCategoriaSuperior());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			log.error(e.getMessage());
			return false;
		}		
	}

	@Override
	public boolean update(Categoria categoria) {
		if(categoria.getIdCategoria()!=0) {
			String sql=String.format("UPDATE categoria SET Nombre='%s', Descripcion='%s', CategoriaSuperior='%d' "
					+ "WHERE IdCategoria='%d'",
					categoria.getNombre(),categoria.getDescripcion(),categoria.getCategoriaSuperior(),categoria.getIdCategoria());
			jdbcTemplate.execute(sql);			
			return true;
		}
		return false;
	}

	@Override
	public List<Categoria> findAll(Pageable pageable) {		
		return jdbcTemplate.query("SELECT * FROM categoria", new CategoriaMapper());
	}

	@Override
	public Categoria findById(int id) {
		Object params[] = {id};
		return jdbcTemplate.queryForObject("SELECT * FROM categoria WHERE IdCategoria=?",params, new CategoriaMapper());
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	
}
