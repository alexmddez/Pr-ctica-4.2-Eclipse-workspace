import java.io.*;

public class Ejemplo01 {

    public static void main(String[] args) {
        String fichero = "src/alumnos.txt";

        try {
            // Abrimos el fichero original para leer
            BufferedReader br = new BufferedReader(new FileReader(fichero));
            // Abrimos un fichero temporal para guardar los cambios
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/alumnos.txt"));

            String linea;

            while ((linea = br.readLine()) != null) {
                // Cada línea tiene: nombre nota
                String[] partes = linea.split(" "); // separa por espacio
                if (partes.length == 2) {
                    String nombre = partes[0];
                    double nota = Double.parseDouble(partes[1]);

                    // Si la nota es menor que 5, sumamos 1
                    if (nota < 5) {
                        nota += 1;
                    }

                    // Escribimos la línea ajustada en el fichero temporal
                    bw.write(nombre + " " + nota);
                    bw.newLine();
                } else {
                    // Si la línea no tiene 2 partes, la dejamos igual
                    bw.write(linea);
                    bw.newLine();
                }
            }

            // Cerramos los ficheros
            br.close();
            bw.close();

            // Borramos el fichero original y renombramos el temporal
            File original = new File(fichero);
            File temp = new File("temp.txt");

            if (original.delete()) {
                temp.renameTo(original);
            }

            System.out.println("Notas ajustadas correctamente.");

        } catch (IOException e) {
            System.out.println("Error con el fichero: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al leer la nota: " + e.getMessage());
        }
    }
}
