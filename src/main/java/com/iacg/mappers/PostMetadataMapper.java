package com.iacg.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iacg.model.PostMetadata;

public class PostMetadataMapper implements RowMapper<PostMetadata> {

	@Override
	public PostMetadata mapRow(ResultSet rs, int rowNum) throws SQLException {
		PostMetadata postMetadata = new PostMetadata();
		postMetadata.setIdPostMetadata(rs.getInt("IdPostMetadata"));
		postMetadata.setTipo(rs.getString("Tipo"));
		postMetadata.setClave(rs.getString("Clave"));
		postMetadata.setValor(rs.getString("Valor"));
		postMetadata.setIdPost(rs.getInt("IdPost"));
		return postMetadata;
	}

}
