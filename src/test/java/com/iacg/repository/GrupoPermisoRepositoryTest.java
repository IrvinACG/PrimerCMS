package com.iacg.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.iacg.component.TestDataBaseConfiguration;
import com.iacg.model.GrupoPermiso;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = (TestDataBaseConfiguration.class))
public class GrupoPermisoRepositoryTest {
	
	@Autowired
	private GrupoPermisoRepository grupoPermisoRepository;
	
	private GrupoPermiso gp=null;
	
	@Test
	public void test1Insert() {
		gp = new GrupoPermiso();
		gp.setIdGrupo(1);
		gp.setIdPermiso(1);
		boolean result = grupoPermisoRepository.save(gp);
		Assert.assertTrue(result);
	}
	
	@Test
	public void test2Update() {
		gp = new GrupoPermiso();
		gp.setIdGrupo(2);
		gp.setIdPermiso(1);
		boolean result = grupoPermisoRepository.update(gp);
		Assert.assertTrue(result);
	}
	
	@Test
	public void test3GetAll() {
		SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
		Assert.assertFalse(grupoPermisoRepository.findAll(pageable).isEmpty());
	}
	
	@Test
	public void test4GetById() {
		gp = grupoPermisoRepository.findById(1);
		Assert.assertTrue(gp!=null);
		Assert.assertTrue(gp.getIdGrupo()!=0);
	}
}
