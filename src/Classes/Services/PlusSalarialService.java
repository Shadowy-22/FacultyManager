package Classes.Services;

import java.util.List;

import Classes.Docente;

public class PlusSalarialService {
    public static void aplicarPlusSalarial(List<Docente> docentes) {
        for (Docente docente : docentes) {
            if (!docente.isPlusAplicado()) {
                double salarioPrevio = docente.getSalario();
                docente.calcularPlusSalarial();
                if(docente.isPlusAplicado()){
                    System.out.println("Plus Salarial aplicado a: " + docente.getNombre() +
                    ". Salario previo: " + salarioPrevio + " Nuevo salario: " + docente.getSalario());
                }
            }
        }
    }

    public static void consultarPlus(List<Docente> docentes) {
        System.out.println("\n=== Docentes CON Plus Salarial ===");
        for (Docente docente : docentes) {
            if (docente.isPlusAplicado()) {
                // Usamos String.format para un string mas limpio
                /*
                 * %s (string),
                 * %d (Enteros),
                 * %.2f (Numeros de punto flotante con 2 decimales)
                 */

                System.out.println(String.format("Docente: %s (Legajo: %d), Salario: %.2f",
                        docente.getNombre(),
                        docente.getLegajo(),
                        docente.getSalario()));
            }
        }

        System.out.println("\n=== Docentes SIN Plus Salarial ===");
        for (Docente docente : docentes) {
            if (!docente.isPlusAplicado()) {

                System.out.println(String.format("Docente: %s (Legajo: %d), Salario: %.2f",
                        docente.getNombre(),
                        docente.getLegajo(),
                        docente.getSalario()));
            }
        }
    }
}
