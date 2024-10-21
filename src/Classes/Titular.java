package Classes;

import java.time.LocalDate;

public class Titular extends Docente {

    protected int _antiguedad;

    public Titular(
            int numLegajo,
            String nombre,
            LocalDate fechaNacimiento,
            int edad,
            double salario,
            int antiguedad
    ) {
        super(numLegajo, nombre, edad, salario, fechaNacimiento);
        _antiguedad = antiguedad; 
    }

    @Override
    public void calcularPlusSalarial() {
        if( _edad > 30 && _antiguedad > 6 ){
            _salario += PLUS_SALARIAL;
            _plusSalarialAplicado = true;
        }
    }
}
