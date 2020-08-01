package com.iacg.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.iacg.component.TestDataBaseConfiguration;
import com.iacg.model.UsuarioMetadata;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = (TestDataBaseConfiguration.class))
public class UsuarioMetadataRepositoryTest {
	
	@Autowired
	private UsuarioMetadataRepository usuarioMetadataRepository;
	
	private UsuarioMetadata usu;
	
	@Test
	public void testInsert() {
		usu = new UsuarioMetadata();
		usu.setIdUsuario(1);
		usu.setClave("Clave2");
		usu.setValor("Valor2");
		usu.setTipo("Tipo2");
		
		boolean result = usuarioMetadataRepository.save(usu);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testUpdate() {
		usu = new UsuarioMetadata();
		usu.setIdUsuarioMetadata(1);
		usu.setIdUsuario(1);
		usu.setClave("Clave3");
		usu.setValor("Valor3");
		usu.setTipo("Tipo3");
		
		boolean result = usuarioMetadataRepository.update(usu);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testGetAll() {
		SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
		Assert.assertFalse(usuarioMetadataRepository.findAll(pageable).isEmpty());
	}
	
	@Test
	public void testGetById() {
		usu = usuarioMetadataRepository.findById(4);
		Assert.assertTrue(usu!=null);
		Assert.assertTrue(!usu.getValor().equals(""));
	}
}
