package com.iacg.model;

public class Usuario {
	private long IdUsuario;
	private String Nombre;
	private String Apellido;
	private String Contrasenia;
	private String Correo;
	private long IdGrupo;
	
	public Usuario() {}
	
	public Usuario(long idUsuario, String nombre, String apellido, String contrasenia, String correo, long idGrupo) {
		IdUsuario = idUsuario;
		Nombre = nombre;
		Apellido = apellido;
		Contrasenia = contrasenia;
		Correo = correo;
		IdGrupo = idGrupo;
	}
	public long getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getContrasenia() {
		return Contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		Contrasenia = contrasenia;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public long getIdGrupo() {
		return IdGrupo;
	}
	public void setIdGrupo(long idGrupo) {
		IdGrupo = idGrupo;
	}
	
	

}
