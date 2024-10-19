import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import Classes.Docente;
import Classes.Commands.*;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Docente> docentes = new ArrayList<>();

        // Creamos las instancias de los comandos
        ICommand agregarTitularCommand = new AgregarTitularCommand(scanner, docentes);
        ICommand agregarSuplenteCommand = new AgregarSuplenteCommand(scanner, docentes);
        ICommand aplicarPlusSalarialCommand = new AplicarPlusSalarialCommand(docentes);
        ICommand consultarPlusCommand = new ConsultarPlusCommand(docentes);
        ICommand DocentesDefaultCommand = new DocentesDefaultCommand(docentes);
        ICommand salirCommand = () -> salir();

        // Usamos el mapa para asociar al menu con los comandos
        Map<Integer, ICommand> opcionesMenu = new HashMap<>();
        opcionesMenu.put(1, agregarTitularCommand);
        opcionesMenu.put(2, agregarSuplenteCommand);
        opcionesMenu.put(3, aplicarPlusSalarialCommand);
        opcionesMenu.put(4, consultarPlusCommand);
        opcionesMenu.put(5, DocentesDefaultCommand);
        opcionesMenu.put(0, salirCommand);

        boolean running = true;

        while (running) {
            System.out.println("\n=== Sistema de Docentes ===");
            System.out.println("1. Agregar un Titular");
            System.out.println("2. Agregar un Suplente");
            System.out.println("3. Aplicar Plus Salarial a los Docentes");
            System.out.println("4. Consultar Docentes con y sin el Plus Salarial");
            System.out.println("5. Insertar Docentes (Titulares y Suplentes) Predeterminados");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            ICommand command = opcionesMenu.get(opcion);
            if (command != null) {
                command.execute(); // Llamamos al metodo execute para realizar el comando.
            } else {
                System.out.println("Opción no válida. Intenta de nuevo");
            }
        }

        scanner.close();
    }

    private static void salir() {
        System.out.println("Saliendo del sistema...");
        System.exit(0);
    }
}
