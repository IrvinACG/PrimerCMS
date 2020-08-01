package com.iacg.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.iacg.component.TestDataBaseConfiguration;
import com.iacg.model.Contenido;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = (TestDataBaseConfiguration.class))
public class ContenidoRepositoryTest {
	
	@Autowired
	private ContenidoRepository contenidoRepository;
	
	private Contenido contenido;
	
	@Test
	public void testInsert() {
		contenido = new Contenido();
		contenido.setContenido("Contenido 1");
		contenido.setIdPost(1);
		contenido.setTipo("Tipo 1");
		boolean result = contenidoRepository.save(contenido);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testUpdate() {
		contenido = new Contenido();
		contenido.setIdContenido(1);
		contenido.setContenido("Contenido 10");
		contenido.setIdPost(1);
		contenido.setTipo("Tipo 10");
		boolean result = contenidoRepository.update(contenido);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testGetAll() {
		SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
		Assert.assertFalse(contenidoRepository.findAll(pageable).isEmpty());
	}
	
	@Test
	public void testGetById() {
		contenido = contenidoRepository.findById(1);
		Assert.assertTrue(contenido!=null);
		Assert.assertTrue(!contenido.getContenido().equals(""));
	}

}
