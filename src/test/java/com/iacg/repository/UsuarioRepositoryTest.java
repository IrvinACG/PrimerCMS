package com.iacg.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.iacg.component.TestDataBaseConfiguration;
import com.iacg.model.Usuario;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = (TestDataBaseConfiguration.class))
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private Usuario usuario=null;
	
	@Test
	public void testInsert() {
		usuario = new Usuario();
		usuario.setNombre("Alejandro");
		usuario.setApellido("Cruz Gonzalez");
		usuario.setCorreo("irvincruz912@gmail.com");
		usuario.setContrasenia("123456");
		usuario.setIdGrupo(1);
		boolean result = usuarioRepository.save(usuario);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testUpdate() {
		usuario = new Usuario();
		usuario.setIdUsuario(1);
		usuario.setNombre("Irvin Alejandro");
		usuario.setApellido("Cruz Gonzalez");
		usuario.setCorreo("irvincruz912@gmail.com");
		usuario.setContrasenia("123456");
		usuario.setIdGrupo(1);
		boolean result = usuarioRepository.update(usuario);
		Assert.assertTrue(result);
	}
	
	@Test
	public void testGetAll() {
		SpringDataWebProperties.Pageable pageable = new SpringDataWebProperties.Pageable();
		Assert.assertFalse(usuarioRepository.findAll(pageable).isEmpty());
	}
	
	@Test
	public void testGetById() {
		usuario = usuarioRepository.findById(1);
		Assert.assertTrue(usuario !=null);
		Assert.assertTrue(!usuario.getNombre().equals(""));
	}
}
