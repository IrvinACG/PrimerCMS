package com.iacg.model;

public class Grupo {
	private long IdGrupo;
	private String Nombre;
	
	public Grupo() {}
	
	public Grupo(long idGrupo, String nombre) {
		IdGrupo = idGrupo;
		Nombre = nombre;
	}
	public long getIdGrupo() {
		return IdGrupo;
	}
	public void setIdGrupo(long idGrupo) {
		IdGrupo = idGrupo;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
}
