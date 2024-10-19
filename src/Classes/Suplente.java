package Classes;

import java.time.LocalDate;

public class Suplente extends Docente {

    protected String _zonaRural;

    public Suplente(
            int numLegajo,
            String nombre,
            LocalDate fechaNacimiento,
            int edad,
            double salario,
            String zonaRural
    ) {
        super(numLegajo, nombre, edad, salario, fechaNacimiento); 
        this._zonaRural = zonaRural;
    }

    @Override
    public void calcularPlusSalarial() {
        if( _edad < 25 && _zonaRural.equals("Zona Rural A")){
            _salario += PLUS_SALARIAL;
            _plusSalarialAplicado = true;
        }
    }
}
