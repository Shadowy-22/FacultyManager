package Classes.Commands;

import java.util.List;
import java.util.Scanner;

import Classes.Docente;
import Classes.Services.DocenteService;

public class AgregarSuplenteCommand implements ICommand {
    private final Scanner scanner;
    private final List<Docente> docentes;

    public AgregarSuplenteCommand(Scanner scanner, List<Docente> docentes) {
        this.scanner = scanner;
        this.docentes = docentes;
    }

    @Override
    public void execute() {
        DocenteService.agregarSuplente(scanner, docentes);
    }
}
