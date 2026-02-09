package Ejemplos;

import java.util.ArrayList;

public class Modulo {
	private int id;
	private String nombre;
	private int curso;
	private int horas;
	private String profesor;
	private ArrayList<Alumno> alumnos;
	
	public Modulo(int id, String nombre, int curso, int horas, String profesor) {
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.horas = horas;
		this.profesor = profesor;
		this.alumnos = new ArrayList<Alumno>();
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public int getCurso() {
		return curso;
	}
	public void setHoras(int horas) {
		this.horas = horas;
	}
	public int getHoras() {
		return horas;
	}
	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
	public String getProfesor() {
		return profesor;
	}
	
	public void addAlumno(Alumno alu) {
		alumnos.add(alu);
	}
	public ArrayList<Alumno> getAlumnos() {
		return alumnos;
	}
	
	public String toString() {
		return id + " - " + nombre + " (" + curso + "º curso) " + horas + " horas. Profesor: " + profesor;
	}
}