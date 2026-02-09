package Ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ParteA {

	public static void main(String[] args) {
		ArrayList<Modulo> modulos = importarModulos();
		ArrayList<Alumno> alumnos = importarAlumnos();
		ArrayList<String[]> parejas = importarParejas();

		for(int i = 0; i < modulos.size(); i++) {
			for(int j = 0; j < parejas.size(); j++) {
				int modId = Integer.parseInt(parejas.get(j)[0]);
				int aluId = Integer.parseInt(parejas.get(j)[1]);
				if(modulos.get(i).getId() == modId) {
					for(int k = 0; k < alumnos.size(); k++) {
						if(alumnos.get(k).getId() == aluId) {
							modulos.get(i).addAlumno(alumnos.get(k));
						}
					}
				}
			}
		}
		
		for(int i = 0; i < modulos.size(); i++) {
			System.out.println("\n" + modulos.get(i));
			ArrayList<Alumno> lista = modulos.get(i).getAlumnos();
			System.out.println("Alumnos: " + lista.size());
			for(int j = 0; j < lista.size(); j++) {
				System.out.println("\t" + lista.get(j));
			}
		}
		
		generarHTML(modulos);
	}

	public static ArrayList<Modulo> importarModulos() {
		ArrayList<Modulo> lista = new ArrayList<Modulo>();
		
		try {
			File archivo = new File("./assets/modulos.txt");
			Scanner lector = new Scanner(archivo);
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] campos = linea.split("&");
				if(campos.length == 5) {
					int id = Integer.parseInt(campos[0]);
					String nombre = campos[1];
					int curso = Integer.parseInt(campos[2]);
					int horas = Integer.parseInt(campos[3]);
					String profesor = campos[4];
					Modulo m = new Modulo(id, nombre, curso, horas, profesor);
					lista.add(m);
				}
			}
			lector.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha ocurrido un error!");
		}
		
		return lista;
	}
	
	public static ArrayList<Alumno> importarAlumnos() {
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		
		try {
			File archivo = new File("./assets/alumnos.txt");
			Scanner lector = new Scanner(archivo);
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] campos = linea.split("&");
				if(campos.length == 7) {
					int id = Integer.parseInt(campos[0]);
					Alumno a = new Alumno(id, campos[1], campos[2], campos[3], campos[4], campos[5], campos[6]);
					lista.add(a);
				}
			}
			lector.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha ocurrido un error!");
		}
		
		return lista;
	}
	
	public static ArrayList<String[]> importarParejas() {
		ArrayList<String[]> lista = new ArrayList<String[]>();
		
		try {
			File archivo = new File("./assets/modulo_alumno.txt");
			Scanner lector = new Scanner(archivo);
			while (lector.hasNextLine()) {
				String linea = lector.nextLine();
				String[] campos = linea.split(",");
				lista.add(campos);
			}
			lector.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ha ocurrido un error!");
		}
		
		return lista;
	}
	
	public static void generarHTML(ArrayList<Modulo> modulos) {
		String html = "<!DOCTYPE html>" + 
		"<html>" + 
		"<head><title>Lista de módulos</title><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"></head>" + 
		"<body><h1>Listado de módulos</h1>" + 
		"<ul>";
		
		for(int i = 0; i < modulos.size(); i++) {
			Modulo m = modulos.get(i);
			html += "<li>" + m + "</li>";
			html += "<ul>";
			ArrayList<Alumno> alumnos = modulos.get(i).getAlumnos();
			for(int j = 0; j < alumnos.size(); j++) {
				html += "<li>" + alumnos.get(j) + "</li>";
			}
			html += "</ul>";
		}
		
		html += "</ul></body></html>";
		try {
			FileWriter fichero = new FileWriter("./output/modulos_y_alumnos.html");
			fichero.write(html);
			fichero.close();
		} catch (IOException e) {
			System.out.println("Ha ocurrido un error");
		}
	}
}