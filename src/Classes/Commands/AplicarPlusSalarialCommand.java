package Classes.Commands;

import java.util.List;

import Classes.Docente;
import Classes.Services.PlusSalarialService;

public class AplicarPlusSalarialCommand implements ICommand {
    private final List<Docente> docentes;

    public AplicarPlusSalarialCommand(List<Docente> docentes) {
        this.docentes = docentes;
    }

    @Override
    public void execute() {
        PlusSalarialService.aplicarPlusSalarial(docentes);
    }
}
