package Classes.Utils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Classes.Docente;

public class InputValidator {

    public static boolean isValidNombreApellido(String input) {
        // Definimos un patron regex: Permite letras y espacios solamente.
        String regex = "^[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean isLegajoDuplicado(List<Docente> docentes, int legajo) {
        for (Docente docente : docentes) {
            if (docente.getLegajo() == legajo) {
                return true; // Legajo ya existe
            }
        }
        return false; // Legajo no existe
    }

    public static boolean isValidZonaRural(String input) {
        // Definimos el patrón regex para "Zona Rural" seguido de una letra mayúscula
        String regex = "Zona Rural [A-Z]";
        // Creamos un objeto Pattern a partir del regex
        Pattern pattern = Pattern.compile(regex);
        // Creamos el matcher que compara el string de entrada con el patrón regex
        Matcher matcher = pattern.matcher(input);
        // Retorna true si se cumple el patrón, de lo contrario, retorna false
        return matcher.find();
    }

    public static boolean isValidSalario(String salarioStr) {
        try {
            double salario = Double.parseDouble(salarioStr);
            return salario >= 0; // Salario no negativo
        } catch (NumberFormatException e) {
            return false; // No es un número válido
        }
    }

    public static boolean isValidAntiguedad(String antiguedadStr, int edad) {
        try {
            int antiguedad = Integer.parseInt(antiguedadStr); // Intentar convertir a int
            return antiguedad <= edad; // Antigüedad no mayor a la edad
        } catch (NumberFormatException e) {
            return false; // No es un número válido
        }
    }
}