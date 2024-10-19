package Classes.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Classes.Docente;
import Classes.Suplente;
import Classes.Titular;
import Classes.Utils.InputValidator;

public class DocenteService {

    public static void agregarTitular(Scanner scanner, List<Docente> docentes) {
        System.out.println("\n=== Agregar Docente Titular ===");

        System.out.print("Número de Legajo: ");
        int legajo = scanner.nextInt();
        scanner.nextLine();

        if (InputValidator.isLegajoDuplicado(docentes, legajo)) {
            System.out.println("El legajo " + legajo + " ya está en uso. No se puede agregar al Docente Titular.");
            return;
        }

        String nombre;
        while (true) {
            System.out.print("Nombre y Apellido: ");
            nombre = scanner.nextLine();
            if (InputValidator.isValidNombreApellido(nombre)) {
                break; // Salimos del loop si es valido
            } else {
                System.out.println("Entrada inválida. Solo se permiten letras y espacios. Intente nuevamente.");
            }
        }

        System.out.print("Fecha de Nacimiento (DD/MM/AAAA) ó (MM/DD/AAAA): ");
        LocalDate fechaNacimiento = null;
        while (fechaNacimiento == null) {
            String fechaString = scanner.nextLine();
            fechaNacimiento = Docente.parseDate(fechaString);
        }

        // Calculamos la edad a partir de la fecha de nacimiento
        int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
        if (LocalDate.now().getDayOfYear() < fechaNacimiento.getDayOfYear()) {
            edad--; // Restamos la edad en caso de que aun no haya sido su cumpleaños
        }
        System.out.println("Su edad es: " + edad);

        String salarioStr;
        double salario;
        while (true) {
            System.out.print("Salario: ");
            salarioStr = scanner.nextLine();

            // Validar el salario
            if (InputValidator.isValidSalario(salarioStr)) {
                salario = Double.parseDouble(salarioStr); // Convertir a double
                break; // Salir del bucle si es válido
            } else {
                System.out.println("Entrada inválida. Debe ser un número no negativo. Intente nuevamente.");
            }
        }

        System.out.print("Antigüedad (en años): ");
        String antiguedadStr = scanner.nextLine(); // Leer como String

        while (!InputValidator.isValidAntiguedad(antiguedadStr, edad)) {
            System.out.println("Entrada inválida. Debe ser un número y no puede ser mayor que la edad. Intente nuevamente.");
            System.out.print("Antigüedad (en años): ");
            antiguedadStr = scanner.nextLine(); // Volver a leer
        }

        int antiguedad = Integer.parseInt(antiguedadStr);

        // Creamos el titular y lo añadimos a la lista
        Titular titular = new Titular(legajo, nombre, fechaNacimiento, edad, salario, antiguedad);
        docentes.add(titular);

        System.out.println("Docente Titular agregado exitosamente.");
    }

    public static void agregarSuplente(Scanner scanner, List<Docente> docentes) {
        System.out.println("\n=== Agregar Docente Suplente ===");

        System.out.print("Número de Legajo: ");
        int legajo = scanner.nextInt();
        scanner.nextLine();

        if (InputValidator.isLegajoDuplicado(docentes, legajo)) {
            System.out.println("El legajo " + legajo + " ya está en uso. No se puede agregar al Suplente.");
            return;
        }

        String nombre;
        while (true) {
            System.out.print("Nombre y Apellido: ");
            nombre = scanner.nextLine();
            if (InputValidator.isValidNombreApellido(nombre)) {
                break; // Salimos del loop si es valido
            } else {
                System.out.println("Entrada inválida. Solo se permiten letras y espacios. Intente nuevamente.");
            }
        }

        System.out.print("Fecha de Nacimiento (DD/MM/AAAA) ó (MM/DD/AAAA): ");
        LocalDate fechaNacimiento = null;
        while (fechaNacimiento == null) {
            String fechaString = scanner.nextLine();
            fechaNacimiento = Docente.parseDate(fechaString);
        }

        // Calculamos la edad a partir de la fecha de nacimiento
        int edad = LocalDate.now().getYear() - fechaNacimiento.getYear();
        if (LocalDate.now().getDayOfYear() < fechaNacimiento.getDayOfYear()) {
            edad--; // Restamos la edad en caso de que aun no haya sido su cumpleaños
        }
        System.out.println("Su edad es: " + edad);

        String salarioStr;
        double salario;
        while (true) {
            System.out.print("Salario: ");
            salarioStr = scanner.nextLine();

            // Validar el salario
            if (InputValidator.isValidSalario(salarioStr)) {
                salario = Double.parseDouble(salarioStr); // Convertir a double
                break; // Salir del bucle si es válido
            } else {
                System.out.println("Entrada inválida. Debe ser un número no negativo. Intente nuevamente.");
            }
        }

        String zonaRural;
        while (true) {
            System.out.print("Zona Rural (A/B/C/etc): ");
            zonaRural = scanner.nextLine();

            // Verificamos que la Zona rural sea valida
            if (InputValidator.isValidZonaRural(zonaRural)) {
                break; // Salimos del loop
            } else {
                System.out.println(
                        "Entrada inválida. Debe ser 'Zona Rural' seguido de una letra (A-Z). Intente nuevamente.");
            }
        }

        // Creamos el Suplente y lo añadimos a la lista
        Suplente suplente = new Suplente(legajo, nombre, fechaNacimiento, edad, salario, zonaRural);
        docentes.add(suplente);

        System.out.println("Docente Suplente agregado exitosamente.");
    }

    public static void insertarDocentesPredeterminados(List<Docente> docentes, boolean isDocentesInsertados) {

        if (isDocentesInsertados) {
            System.out.println("Los docentes predeterminados ya han sido insertados.");
            return;
        }

        // Creamos algunos docentes titulares
        docentes.add(new Titular(101, "Juan Pérez", LocalDate.of(1980, 5, 15), 44, 50000.0, 7));
        docentes.add(new Titular(102, "María Gómez", LocalDate.of(1975, 3, 22), 35, 60000.0, 6));
        docentes.add(new Titular(103, "Carlos Rodríguez", LocalDate.of(1988, 8, 30), 36, 55000.0, 5));
    
        // Creamos algunos docentes suplentes
        docentes.add(new Suplente(201, "Laura Martínez", LocalDate.of(1990, 12, 10), 24, 30000.0, "Zona Rural A"));
        docentes.add(new Suplente(202, "Javier Sánchez", LocalDate.of(1995, 6, 25), 29, 32000.0, "Zona Rural B"));
        docentes.add(new Suplente(203, "Ana López", LocalDate.of(1982, 4, 17), 42, 31000.0, "Zona Rural C"));
    
        System.out.println("Docentes predeterminados agregados exitosamente.");
        
    }
}
