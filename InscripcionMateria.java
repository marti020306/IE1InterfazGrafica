package ie1interfazgrafica;
 
import java.util.Arraylist;

public class InscripcionMateria implements Evaluable
{
    private Materia materia;
    private int totalClases;
    private int clasesAsistidas;
    private ArrayList <Double> notas;

    private static final int MAX_NOTAS = 5;
    private static final double MINIMO_REGULAR = 75.0;


    public InscripcionMateria (Materia materia)
    {
        thismateria=materia;
        this.totalClases=0;
        this.clasesAsistidas=0;
        this.notas= new ArrayList<Double>();
    }

    public Materia getMateria()
    {
        return materia;
    }

    public void registrarAsistencia (boolean presente)
    {
        totalClases++;
        if (presente)
        {
            clasesAsistidas++;
        }
    }

    public void agregarNota (double nota)
    {
        if (nota< 0 || nota > 10)
        {
            throw new IllegalArgumentException("La nota debe ser entre 0 y 10");
        }
        if (notas.size() >= MAX_NOTAS)
        {
            throw new IllegalStateException("No se pueden agregar mas de 5 notas");
        }
        notas.add(nota);
    }

    public double getPorcentajeAsistencia()
    {
        if (totalClases == 0)
        {
            return 0;
        }
        return (clasesAsistidas * 100.0)/ totalClases;
    }
     @Override 
     public String getCondicion()
    {
        if (getPorcentajeAsistencia () >= MINIMO_REGULAR)
        {
            return "Regular";
        }
        else 
        {
            return "Libre";
        }
    }
     @Override
     public double getNota()
    {
        if(notas.isEmpty())
        {
            return 0;
        }
        double suma=0;
        for (double nota: notas)
        {
            suma+=nota;
        }
        return suma/notas.size();
    }
    @Override
    public boolean estaAprobado()
    {
        return getNota () >= 6 && getCondicion().equals("Regular");
    }
    public Arraylist<Double> getNotas()
    {
        return notas;
    }
    public int getTotalClases()
    {
        return totalClases;
    }
    public int getClasesAsistidas()
    {
        return clasesAsistidas;
    }
}