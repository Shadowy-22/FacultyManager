package Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

public abstract class Docente {
    protected int _numLegajo;
    protected String _nombre;
    protected int _edad;
    protected double _salario;
    protected LocalDate _fechaNacimiento; // Usamos el LocalDate para manejar el formato de la fecha.
    protected final double PLUS_SALARIAL = 80000;
    protected boolean _plusSalarialAplicado = false;

    public Docente(int numLegajo, String nombre, int edad, double salario, LocalDate fechaNacimiento) {
        this._numLegajo = numLegajo;
        this._nombre = nombre;
        this._edad = edad;
        this._salario = salario;
        this._fechaNacimiento = fechaNacimiento;
    }

    // Método que utilizamos siempre al asignar una fecha de nacimiento a un Docente para convertirla a LocalDate.
    public static LocalDate parseDate(String fecha) {
        // Definimos los posibles formatos en una lista
        Map<String, DateTimeFormatter> formatters = new HashMap<>();
        formatters.put("dd/MM/yyyy", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        formatters.put("MM/dd/yyyy", DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        for (Map.Entry<String, DateTimeFormatter> entry : formatters.entrySet()) {
            String pattern = entry.getKey();
            DateTimeFormatter formatter = entry.getValue();
            try {
                // Intentamos convertir la fecha utilizando el formato actual
                return LocalDate.parse(fecha, formatter);
            } catch (DateTimeParseException e) {
                // Manejamos el error, mostrando el patrón
                System.out.println("Error al intentar convertir la fecha: " + fecha + " con el formato: " + pattern);
                // Y luego continuamos al siguiente
            }
        }

        // Si ninguno de los formatos funcionó, mostramos el error
        System.out.println("Ninguno de los formatos introducidos es válido. Intenta con dd/MM/yyyy ó MM/dd/yyyy.");
        return null;
    }

    // Formatear la fecha para mostrarla pantalla en el formato dd/MM/yyyy
    public String formatDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return _fechaNacimiento.format(formatter);
    }

    public abstract void calcularPlusSalarial();

    public String getNombre() {
        return _nombre;
    }

    public double getSalario() {
        return _salario;
    }

    public int getLegajo() {
        return _numLegajo;
    }

    public boolean isPlusAplicado() {
        return _plusSalarialAplicado;
    }
}
