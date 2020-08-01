package com.iacg.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.iacg.component.TestDataBaseConfiguration;
import com.iacg.model.Post;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = (TestDataBaseConfiguration.class))
public class PostRepositoryTest {
	
	@Autowired
	private PostRepository postRepository;
	
	private Post post;
	
	@Test
	public void testInsert() {
		post = new Post();
		post.setTitulo("Titulo 1");
		post.setSlug("Slug 1");
		post.setExtracto("Extracto 1");
		post.setIdUsuario(1);
		post.setCategoria(1);
		post.setImagenDestacada("Imagen 1");
		post.setTipo("Tipo 1");
		boolean result = postRepository.save(post);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testUpdate() {
		post = new Post();
		post.setIdPost(1);
		post.setTitulo("Titulo 3");
		post.setSlug("Slug 3");
		post.setExtracto("Extracto 3");
		post.setIdUsuario(1);
		post.setCategoria(1);
		post.setImagenDestacada("Imagen 3");
		post.setTipo("Tipo 3");
		boolean result = postRepository.update(post);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testGetAll() {
		SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
		Assert.assertFalse(postRepository.findAll(pageable).isEmpty());
	}
	
	@Test
	public void testGetById() {
		post = postRepository.findById(1);
		Assert.assertTrue(post !=null);
		Assert.assertTrue(!post.getTitulo().equals(""));
	}

}
