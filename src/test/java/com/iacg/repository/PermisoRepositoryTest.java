package com.iacg.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.iacg.component.TestDataBaseConfiguration;
import com.iacg.model.Permiso;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = (TestDataBaseConfiguration.class))
public class PermisoRepositoryTest {
	
	@Autowired
	private PermisoRepository permisoRepository;
	
	private Permiso permiso;
	
	@Test
	public void testInsert() {
		permiso = new Permiso();
		permiso.setNombre("Primer Permiso");
		boolean result = permisoRepository.save(permiso);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testUpdate() {
		permiso = new Permiso();
		permiso.setIdPermiso(1);
		permiso.setNombre("Cambio Primer Permiso");
		boolean result = permisoRepository.update(permiso);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testGetAll() {
		SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
		Assert.assertFalse(permisoRepository.findAll(pageable).isEmpty());
	}
	
	@Test
	public void testGetById() {
		permiso  = permisoRepository.findById(1);
		Assert.assertTrue(permiso!=null);
		Assert.assertTrue(!permiso.getNombre().equals(""));
	}
}
