package Classes.Commands;

import java.util.List;
import java.util.Scanner;

import Classes.Docente;
import Classes.Services.DocenteService;

public class AgregarTitularCommand implements ICommand {
    private final Scanner scanner;
    private final List<Docente> docentes;

    public AgregarTitularCommand(Scanner scanner, List<Docente> docentes) {
        this.scanner = scanner;
        this.docentes = docentes;
    }

    @Override
    public void execute() {
        DocenteService.agregarTitular(scanner, docentes);
    }
}