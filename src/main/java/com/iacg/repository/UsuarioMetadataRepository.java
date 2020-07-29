package com.iacg.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iacg.mappers.UsuarioMetadataMapper;
import com.iacg.model.UsuarioMetadata;

@Repository
public class UsuarioMetadataRepository implements UsuarioMetadataRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(UsuarioMetadata object) {
		try {
			String sql = String.format("INSERT INTO usuario_metadata (IdUsuario,Clave,Valor,Tipo) VALUES ('%d','%s','%s','%s')", 
					object.getIdUsuario(),object.getClave(),object.getValor(),object.getTipo());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean update(UsuarioMetadata object) {
		if(object.getIdUsuarioMetadata()!=0) {
			String sql = String.format("UPDATE usuario_metadata SET IdUsuario='%d', Clave='%s', Valor='%s', Tipo='%s' "
					+ "WHERE IdUsuarioMetadata='%d'",
					object.getIdUsuario(),object.getClave(),object.getValor(),object.getTipo(),
					object.getIdUsuarioMetadata());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<UsuarioMetadata> findAll(Pageable pageable) {		
		return jdbcTemplate.query("SELEC * FROM usuario_metadata", new UsuarioMetadataMapper());
	}

	@Override
	public UsuarioMetadata findById(int id) {
		Object params[] = {id};
		return jdbcTemplate.queryForObject("SELECT * FROM usuario_metadata WHERE IdUsuarioMetadata=?",params, new UsuarioMetadataMapper());
	}
}
