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

import com.iacg.mappers.PostMetadataMapper;
import com.iacg.model.PostMetadata;

@Repository
public class PostMetadataRepository implements PostMetadataRep {
	private Log log = LogFactory.getLog(getClass());
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	public void postConstruc() {
		jdbcTemplate =  new JdbcTemplate(dataSource);
	}

	@Override
	public boolean save(PostMetadata object) {
		try {
			String sql = String.format("INSERT INTO post_metadata (Clave,Valor,Tipo,IdPost) VALUES ('%s','%s','%s','%d')", 
					object.getClave(),object.getValor(),object.getTipo(),object.getIdPost());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			log.error(e.getMessage());
			return false;
		}
	}

	@Override
	public boolean update(PostMetadata object) {
		if(object.getIdPostMetadata()!=0) {
			String sql = String.format("UPDATE post_metadata SET Clave='%s', Valor='%s', Tipo='%s', IdPost='%d' "
					+ "WHERE IdPostMetadata='%d'"
					, object.getClave(),object.getValor(),object.getTipo(),object.getIdPost(),
					object.getIdPostMetadata());
			jdbcTemplate.execute(sql);
			return true;
		}	
		return false;
	}

	@Override
	public List<PostMetadata> findAll(Pageable pageable) {		
		return jdbcTemplate.query("SELECT * FROM post_metadata", new PostMetadataMapper());
	}

	@Override
	public PostMetadata findById(int id) {
		Object params[] = {id};
		return jdbcTemplate.queryForObject("SELECT * FROM post_metadata WHERE IdPostMetadata=?",params, new PostMetadataMapper());
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
}
