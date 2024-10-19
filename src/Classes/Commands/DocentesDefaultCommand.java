package Classes.Commands;

import java.util.List;

import Classes.Docente;
import Classes.Services.DocenteService;

public class DocentesDefaultCommand implements ICommand {
    private final List<Docente> docentes;
      // Flag para chequear que los datos predeterminados se hayan insertado.
    private boolean isDocentesInsertados;

    public DocentesDefaultCommand(List<Docente> docentes) {
        this.docentes = docentes;
    }

    @Override
    public void execute() {
        DocenteService.insertarDocentesPredeterminados(docentes, isDocentesInsertados);
        isDocentesInsertados = true;
    }
}
