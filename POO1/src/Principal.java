import java.util.Scanner;

public class Principal {
	public static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("Introduce la cantidad de alumnos que quieres mostrar: ");
		int cantidad = Integer.parseInt(teclado.nextLine().trim());

		Alumno[] alumnos = new Alumno[cantidad];

		for (int i = 0; i < cantidad; i++) {
			System.out.println("Alumno " + (i + 1) + "---");

			System.out.print("Nombre: ");
			String nombre = teclado.nextLine();

			System.out.print("Apellidos: ");
			String apellidos = teclado.nextLine();

			System.out.print("NRE: ");
			int NRE = Integer.parseInt(teclado.nextLine());

			System.out.print("Email: ");
			String email = teclado.nextLine();

			System.out.print("Direccion: ");
			String direccion = teclado.nextLine();

			alumnos[i] = new Alumno(nombre, apellidos, NRE, email, direccion);
		}
		while (true) {
			System.out.print("Selecciona el numero del alumno para ver su informacion --> ");
			int opcion = Integer.parseInt(teclado.nextLine());

			if (opcion == 0) {
				System.out.println("Saliendo del programa...");
				break;
			} else if (opcion > 0 && opcion <= cantidad) {
				System.out.println("\n--- Información del Alumno ---");
				System.out.println(alumnos[opcion - 1].info());
			} else {
				System.out.println("Opción no válida.");
			}
		}

	}

}
