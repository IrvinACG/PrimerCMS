package com.iacg.model;

public class Permiso {
	private long IdPermiso;
	private String Nombre;
	
	public Permiso() {}
	
	public Permiso(long idPermiso, String nombre) {
		IdPermiso = idPermiso;
		Nombre = nombre;
	}
	public long getIdPermiso() {
		return IdPermiso;
	}
	public void setIdPermiso(long idPermiso) {
		IdPermiso = idPermiso;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	

}
