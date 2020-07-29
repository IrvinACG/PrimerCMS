package com.iacg.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iacg.mappers.UsuarioMapper;
import com.iacg.model.Usuario;

@Repository
public class UsuarioRepository implements UsuarioRep{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public boolean save(Usuario object) {
		try {
			String sql = String.format("INSERT INTO usuarios (Nombre,Apellidos,Contrasenia,Correo,IdGrupo) VALUES ('%s','%s','%s','%s','%d')",
					object.getNombre(),object.getApellido(),object.getContrasenia(),object.getCorreo(),object.getIdGrupo());
			jdbcTemplate.execute(sql);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean update(Usuario object) {
		if(object.getIdUsuario()!=0) {
			String sql = String.format("UPDATE usuarios SET Nombre='%s', Apellidos='%s', Contrasenia='%s', Correo='%s', IdGrupo='%d' "
					+ "WHERE IdUsuario='%d'",
					object.getNombre(),object.getApellido(),object.getContrasenia(),object.getCorreo(),object.getIdGrupo(),
					object.getIdUsuario());
			jdbcTemplate.execute(sql);
			return true;
		}
		return false;
	}

	@Override
	public List<Usuario> findAll(Pageable pageable) {
		return jdbcTemplate.query("SELEC * FROM usuarios", new UsuarioMapper());
	}

	@Override
	public Usuario findById(int id) {
		Object params[] = {id};
		return jdbcTemplate.queryForObject("SELECT * FROM usuarios WHERE IdUsuario=?",params, new UsuarioMapper());
	}
}
