package Clases;

import java.io.*;

public class Session {

    private User user;
    private boolean logged;
    private static final String USERS_FILE = "./assets/files/users.txt";


    public Session() {
        logged = false;

        File file = new File(USERS_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Archivo de usuarios listo.");
} catch (IOException e) {
                System.out.println("No se ha podido preparar el archivo de usuarios.");
}
        }
    }


    public boolean isLogged() {
        return logged;
    }

    public void login() {
        String username = Input.getString("Usuario: ");
        String password = Input.getString("Contraseña: ");

        try (BufferedReader br = new BufferedReader(new FileReader(USERS_FILE))) {

            String line;
            while ((line = br.readLine()) != null) {

                String[] data = line.split("#");

                if (data.length >= 8 && data[0].equalsIgnoreCase(username) && data[1].equals(password)) {

                    user = new User(data[0], data[2], data[3], data[4], data[5], data[6], data[7]);
                    logged = true;

                    System.out.println("Login correcto.");
                    return;
                }
            }

            System.out.println("Usuario o contraseña incorrectos.");

        } catch (IOException e) {
            System.out.println("Error al leer el fichero de usuarios.");
        }
    }


    public void signup() {

        String username = Input.getString("Nombre de usuario: ");

        if (userExists(username)) {
            System.out.println("El usuario ya existe.");
            return;
        }

        String password = Input.getString("Contraseña: ");
        String name = Input.getString("Nombre completo: ");
        String nif = Input.getString("NIF: ");
        String email = Input.getString("Email: ");
        String address = Input.getString("Dirección: ");
        String birthdate = Input.getString("Fecha de nacimiento: ");

        try (BufferedWriter bw = new BufferedWriter(
                new FileWriter(USERS_FILE, true))) {

            bw.write(username + "#" + password + "#" + name + "#" + nif + "#"
                    + email + "#" + address + "#" + birthdate + "#user");
            bw.newLine();

            System.out.println("Usuario registrado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero.");
        }
    }


    public void showUser() {
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("No hay ningún usuario cargado.");
        }
    }

    public void logout() {
        logged = false;
        user = null;
        System.out.println("Sesión cerrada.");
    }

    private boolean userExists(String username) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(USERS_FILE));
            String line;

            while ((line = br.readLine()) != null) {
            	if (line.toLowerCase().startsWith(username.toLowerCase() + "#")){
                    br.close();
                    return true;
                }
            }
            br.close();
        } catch (IOException e) {
        }
        return false;
    }
}
