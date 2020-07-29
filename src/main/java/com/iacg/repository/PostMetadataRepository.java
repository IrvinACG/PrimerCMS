package com.iacg.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iacg.model.PostMetadata;

@Repository
public class PostMetadataRepository implements PostMetadataRep {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(PostMetadata object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(PostMetadata object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PostMetadata> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostMetadata findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
