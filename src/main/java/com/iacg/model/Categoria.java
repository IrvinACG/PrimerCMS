package com.iacg.model;

import java.util.Date;

public class Categoria {
	private int IdCategoria;
	private String Nombre;
	private String Descripcion;
	private Date Fecha;
	private long CategoriaSuperior;
	
	public Categoria() {}
	
	public Categoria(int idCategoria, String nombre, String descripcion, Date fecha, long categoriaSuperior) {
		IdCategoria = idCategoria;
		Nombre = nombre;
		Descripcion = descripcion;
		Fecha = fecha;
		CategoriaSuperior = categoriaSuperior;
	}
	public int getIdCategoria() {
		return IdCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	public Date getFecha() {
		return Fecha;
	}
	public void setFecha(Date fecha) {
		Fecha = fecha;
	}
	public long getCategoriaSuperior() {
		return CategoriaSuperior;
	}
	public void setCategoriaSuperior(long categoriaSuperior) {
		CategoriaSuperior = categoriaSuperior;
	}
	
	
}
