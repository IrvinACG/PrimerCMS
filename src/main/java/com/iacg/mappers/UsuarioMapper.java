package com.iacg.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.iacg.model.Usuario;

public class UsuarioMapper implements RowMapper<Usuario>{

	@Override
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(rs.getInt("IdUsuario"));
		usuario.setNombre(rs.getString("Nombre"));
		usuario.setApellido(rs.getString("Apellidos"));
		usuario.setCorreo(rs.getString("Correo"));
		usuario.setContrasenia(rs.getString("Contrasenia"));
		usuario.setIdGrupo(rs.getInt("IdGrupo"));
		return usuario;
	}

}
