package com.iacg.repository;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.iacg.component.TestDataBaseConfiguration;
import com.iacg.model.Categoria;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = (TestDataBaseConfiguration.class))
public class CategoriaRepositoryTest {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Test
	public void testInsertar() {
		Categoria categoria = new Categoria();
		categoria.setNombre("Categoria 3");
		categoria.setDescripcion("Esta es la tercera categoria");
		categoria.setCategoriaSuperior(1);		
		boolean result = categoriaRepository.save(categoria);
		Assert.assertTrue(result);
	}
	@Test
	public void testUpdate() {
		Categoria categoria = new Categoria();
		categoria.setIdCategoria(1);
		categoria.setNombre("Categoria 1");
		categoria.setDescripcion("Esta es la segunda categoria");
		categoria.setCategoriaSuperior(1);
		boolean result = categoriaRepository.update(categoria);
		Assert.assertTrue(result);
	}
	@Test
	public void testList() {
		SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
		Assert.assertFalse(categoriaRepository.findAll(pageable).isEmpty());
	}
	@Test
	public void testGetCategoria() {
		Categoria categoria = categoriaRepository.findById(2);
		Assert.assertTrue(categoria!=null);
		Assert.assertTrue(categoria.getIdCategoria()==2);
	}
}
