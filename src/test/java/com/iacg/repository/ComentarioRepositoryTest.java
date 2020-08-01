package com.iacg.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.iacg.component.TestDataBaseConfiguration;
import com.iacg.model.Comentario;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = (TestDataBaseConfiguration.class))
public class ComentarioRepositoryTest {

	@Autowired
	private ComentarioRepository comentarioRepository;
	
	private Comentario comentario;
	
	@Test
	public void testInsert() {
		comentario = new Comentario();
		comentario.setComentario("Comentario 1");
		comentario.setIdUsuario(1);
		comentario.setIdPost(1);
		comentario.setRespuesta(1);
		boolean result = comentarioRepository.save(comentario);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testUpdate() {
		comentario = new Comentario();
		comentario.setIdComentario(1);
		comentario.setComentario("Comentario 10");
		comentario.setIdUsuario(1);
		comentario.setIdPost(1);
		comentario.setRespuesta(1);
		boolean result = comentarioRepository.save(comentario);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testGetAll() {
		SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
		Assert.assertFalse(comentarioRepository.findAll(pageable).isEmpty());
	}
	
	@Test
	public void testGetById() {
		comentario = comentarioRepository.findById(1);
		Assert.assertTrue(comentario!=null);
		Assert.assertTrue(!comentario.getComentario().equals(""));
	}
	
}
