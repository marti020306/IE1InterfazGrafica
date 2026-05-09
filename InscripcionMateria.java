package academico
 
import java.util.Arraylist;

public class IncripcionMateria implements Consultable
{
    private Materia materia;
    private int totalClases;
    private int clasesAsistidas;
    private Arraylist <Double> notas;

    private static final int MAX_NOTAS = 4;
    private static final double MINIMO_REGULAR = 75.0;


    public InscripcionMateria (Materia materia)
    {
        this,materia=materia;
        this.totalClases=0;
        this.clasesAsisridas=0;
        this.notas= new Arraylist<Double>();
    }

    
}