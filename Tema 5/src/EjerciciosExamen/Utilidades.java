package EjerciciosExamen;

import java.util.regex.Pattern;

public class Utilidades {

    public static boolean validarNif(String nif) {
        return Pattern.matches("^[0-9]{8}[A-Z]$", nif);
    }

    public static boolean validarEmail(String email) {
        String regex = "^[\\w-\\+]+(\\.[\\w-\\+]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.matches(regex, email);
    }

    public static boolean validarTelefono(String tel) {
        return Pattern.matches("^[0-9]{3} [0-9]{3} [0-9]{3}$", tel);
    }

    public static boolean validarFecha(String fecha) {
        return Pattern.matches("^[0-9]{2}/[0-9]{2}/[0-9]{4}$", fecha);
    }

    public static boolean validarMatricula(String mat) {
        // 4 números, espacio y 3 letras (excluyendo vocales, Ñ, Q, S)
        return Pattern.matches("^[0-9]{4} [BCDFGHJKLMNPRTVWXYZ]{3}$", mat);
    }

    public static boolean validarDescuento(String desc) {
        try {
            double d = Double.parseDouble(desc);
            return d >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}