package com.iacg.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.iacg.component.TestDataBaseConfiguration;
import com.iacg.model.PostMetadata;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = (TestDataBaseConfiguration.class))
public class PostMetadataRepositoryTest {
	
	@Autowired
	private PostMetadataRepository postMetadataRepository;
	
	private PostMetadata postM;
	
	@Test
	public void testInsert() {
		postM = new PostMetadata();
		postM.setIdPost(1);
		postM.setClave("Clave 1");
		postM.setValor("Valor 1");
		postM.setTipo("Tipo 1");
		boolean result = postMetadataRepository.save(postM);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testUpdate() {
		postM = new PostMetadata();
		postM.setIdPostMetadata(1);
		postM.setIdPost(1);
		postM.setClave("Clave 2");
		postM.setValor("Valor 2");
		postM.setTipo("Tipo 2");
		boolean result = postMetadataRepository.update(postM);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testGetAll() {
		SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
		Assert.assertFalse(postMetadataRepository.findAll(pageable).isEmpty());
	}
	
	@Test
	public void testGetById() {
		postM =  postMetadataRepository.findById(1);
		Assert.assertTrue(postM!=null);
		Assert.assertTrue(!postM.getClave().equals(""));
	}
}
