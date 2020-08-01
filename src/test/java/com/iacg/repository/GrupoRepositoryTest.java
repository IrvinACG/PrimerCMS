package com.iacg.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.iacg.component.TestDataBaseConfiguration;
import com.iacg.model.Grupo;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = (TestDataBaseConfiguration.class))
public class GrupoRepositoryTest {
	
	@Autowired
	private GrupoRepository grupoRepository;
	
	private Grupo grupo;
	
	@Test
	public void testInsert() {
		grupo = new Grupo();
		grupo.setIdGrupo(2);
		grupo.setNombre("Segundo Grupo");
		boolean result = grupoRepository.save(grupo);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testUpdate() {
		grupo = new Grupo();
		grupo.setIdGrupo(1);
		grupo.setNombre("Cambio Segundo Grupo");
		boolean result = grupoRepository.update(grupo);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testGetAll() {
		SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
		Assert.assertFalse(grupoRepository.findAll(pageable).isEmpty());
	}
	
	@Test
	public void testGetById() {
		grupo = grupoRepository.findById(1);
		Assert.assertTrue(grupo!=null);
		Assert.assertTrue(!grupo.getNombre().equals(""));
	}

}
