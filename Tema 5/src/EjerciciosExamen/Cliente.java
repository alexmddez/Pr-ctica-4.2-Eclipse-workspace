package EjerciciosExamen;

public class Cliente {
    private String nombre, apellidos, nif, direccion, email, telefono, fechaAlta, tipo, matricula;
    private double descuento;

    public Cliente(String nombre, String apellidos, String nif, String direccion, String email, 
                   String telefono, String fechaAlta, String tipo, String descuento, String matricula) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.tipo = tipo;
        
        /*EN CASO DE QUE SE ESCRIBA POR TECLADO UNA FECHA_ALTA, NIF, EMAIL, TELEFONO, MATRICULA O DESCUENTO INCORRECTOS O CON
        UN FORMATO NO VÁLIDO (NO CUMPLE LA EXPRESIÓN REGULAR), SE LE ASIGNARÁ UNO POR DEFECTO. */
        this.fechaAlta = Utilidades.validarFecha(fechaAlta) ? fechaAlta : "01/01/2000";
        this.nif = Utilidades.validarNif(nif) ? nif : "12345678Z";
        this.email = Utilidades.validarEmail(email) ? email : "sin email";
        this.telefono = Utilidades.validarTelefono(telefono) ? telefono : "000 000 000";
        this.matricula = Utilidades.validarMatricula(matricula) ? matricula : "9999 ZZZ";
        this.descuento = Utilidades.validarDescuento(descuento) ? Double.parseDouble(descuento) : 40.0;
    }

    // Getters y Setters...
    public String getTipo() { return tipo; }
    public double getDescuento() { return descuento; }

    @Override
    public String toString() {
        return String.format("Nombre: %s\nApellidos: %s\nNIF: %s\nDireccion: %s\nEmail: %s\nTelefono: %s\nFecha de alta: %s\nTipo cliente: %s\nDescuento: %.1f\nMatrícula: %s\n",
                nombre, apellidos, nif, direccion, email, telefono, fechaAlta, tipo, descuento, matricula);
    }
}