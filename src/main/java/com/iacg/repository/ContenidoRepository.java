package com.iacg.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iacg.model.Contenido;

@Repository
public class ContenidoRepository implements ContenidoRep{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Contenido object) {
		try {
			String sql = String.format("INSERT INTO contenido (Tipo,Contenido,IdPost) VALUES('%s','%s','%d')",
					object.getTipo(),object.getContenido(),object.getIdPost());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Contenido object) {
		if(object.getIdContenido()!=0) {
			String sql = String.format("UPDATE contenido SET Tipo='%s', Contenido='%s', IdPost='%d' "
					+ "WHERE IdContenido='%d'",
					object.getTipo(),object.getContenido(),object.getIdPost(),
					object.getIdContenido());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Contenido> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contenido findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
