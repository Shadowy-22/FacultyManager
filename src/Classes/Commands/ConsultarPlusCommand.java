package Classes.Commands;

import java.util.List;

import Classes.Docente;
import Classes.Services.PlusSalarialService;

public class ConsultarPlusCommand implements ICommand {
    private final List<Docente> docentes;

    public ConsultarPlusCommand(List<Docente> docentes) {
        this.docentes = docentes;
    }

    @Override
    public void execute() {
        PlusSalarialService.consultarPlus(docentes);
    }
}
