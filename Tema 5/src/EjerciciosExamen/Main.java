package EjerciciosExamen;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    	
//M-------------------------------------------------------------------------------------------------------------------------------------
        
    	//LLAMAR A LOS MÉTODOS:
        Cliente[] clientes = importarClientes();

        System.out.println("--- LISTA DE CLIENTES ---");
        mostrarClientes(clientes);
        
//--------------------------------------------------------------------------------------------------------------------------------------

        //PARTE QUE TE DICE EL NÚMERO DE CLIENTES LIBRES:
        int libres = 0;
        for (Cliente c : clientes) {
            if (c == null) libres++;
        }
        System.out.println("Puedes añadir " + libres + " clientes adicionales.");

        Scanner sc = new Scanner(System.in);
        
//--------------------------------------------------------------------------------------------------------------------------------------
        
        //Te pide introducir 2 clientes escribiendo en el formato de una línea todos los atributos.
        for (int i = 0; i < 2; i++) {
            System.out.println("\nIntroduzca datos del cliente " + (i+1) + " (nombre#apellidos#nif#direccion#email#tel#fecha#tipo#descuento#mat):");
            String lineaInput = sc.nextLine();
            String[] datos = lineaInput.split("#");
            
            if(datos.length == 10) {
                Cliente nuevo = new Cliente(datos[0], datos[1], datos[2], datos[3], 
                                            datos[4], datos[5], datos[6], datos[7], 
                                            datos[8], datos[9]);
                clientes = agregarCliente(clientes, nuevo);
            } else {
                System.out.println("Formato incorrecto. Se esperaban 10 campos separados por #");
            }
        }
       
        System.out.println("\n--- LISTA ACTUALIZADA ---");
        mostrarClientes(clientes);
        
//--------------------------------------------------------------------------------------------------------------------------------------

        //PARTE DE LOS DESCUENTOS:
        double suma = 0;
        int contNormal = 0;
        
        for (Cliente c : clientes) {
            if (c != null && c.getTipo().equalsIgnoreCase("normal")) {
                suma += c.getDescuento();
                contNormal++;
            }
        }
        System.out.println("\nSuma descuentos 'normal': " + suma);
        System.out.println("Media descuentos 'normal': " + (contNormal > 0 ? (suma / contNormal) : 0));
        
//--------------------------------------------------------------------------------------------------------------------------------------

        //ELIMINAR CLIENTE 3:
        if (clientes.length > 2) {
            clientes[2] = null;
            System.out.println("\nCliente 3 eliminado.");
        }
        
        mostrarClientes(clientes);

//--------------------------------------------------------------------------------------------------------------------------------------
        
        //PARTE DE LOS INGRESOS:
        double ingresosTotales = 0;
        for (Cliente c : clientes) {
            if (c != null) {
                ingresosTotales += 500 * (1 - (c.getDescuento() / 100));
            }
        }
        System.out.printf("\nIngreso total previsto: %.2f€\n", ingresosTotales);
        System.out.println("Fin del programa.");
    }

//M-------------------------------------------------------------------------------------------------------------------------------------
    
    //MÉTODO IMPORTAR CLIENTES:
    public static Cliente[] importarClientes() {
        File archivo = new File(".\\assets\\clientes.txt");
        Cliente[] lista = null;

        try (Scanner sc = new Scanner(archivo)) {
            if (sc.hasNextLine()) {
                String linea = sc.nextLine();
                
                String[] fields = linea.split(";");
                
                lista = new Cliente[fields.length + 5];

                for (int i = 0; i < fields.length; i++) {
                    String[] campos = fields[i].split("#");
                    if (campos.length == 10) {
                        lista[i] = new Cliente(campos[0], campos[1], campos[2], campos[3], 
                                               campos[4], campos[5], campos[6], campos[7], 
                                               campos[8], campos[9]);
                    }
                }
            } else {
                lista = new Cliente[5];
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se encuentra el archivo.");
            lista = new Cliente[5];
        }
        return lista;
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------

    //MÉTODO MOSTRAR CLIENTES:
    public static void mostrarClientes(Cliente[] lista) {
        if (lista == null) return;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                System.out.println("--- Cliente " + (i + 1) + " ---");
                System.out.println(lista[i].toString());
            }
        }
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------

    //MÉTODO AGREGAR CLIENTES:
    public static Cliente[] agregarCliente(Cliente[] lista, Cliente c) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                lista[i] = c;
                break;
            }
        }
        return lista;
    }
    
//--------------------------------------------------------------------------------------------------------------------------------------
    
}