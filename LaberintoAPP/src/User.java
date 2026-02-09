public class User {

    private String username;
    private String name;
    private String nif;
    private String email;
    private String address;
    private String birthdate;
    private String role;

    public User(String username, String name, String nif, String email,
                String address, String birthdate, String role) {

        this.username = username;
        this.name = name;
        this.nif = nif;
        this.email = email;
        this.address = address;
        this.birthdate = birthdate;
        this.role = role;
    }

    public String toString() {
        return "Usuario: " + username + "\n" +
               "Nombre completo: " + name + "\n" +
               "NIF: " + nif + "\n" +
               "Email: " + email + "\n" +
               "Dirección: " + address + "\n" +
               "Fecha de nacimiento: " + birthdate + "\n" +
               "Rol: " + role;
    }
}
