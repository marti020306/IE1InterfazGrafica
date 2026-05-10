package ie1interfazgrafica;
import java.util.ArrayList;

public class Estudiante extends PersonaAcademica implements Consultable
{
    private String carrera;
    private int anioIngreso;
    private ArrayList<InscripcionMateria>materias;

    public Estudiante(String nombre, String legajo, String carrera, int anioIngreso)
    {
        super(nombre, legajo);
        setCarrera(carrera);
        setAnioIngreso(anioIngreso);
        this.materias = new ArrayList<>();
    }


    //Carrera
    public String getCarrera()
    {
        return carrera;
    }

    public void setCarrera(String carrera)
    {
        if (carrera == null || carrera.isEmpty())
        {
            throw new IllegalArgumentException("Carrera invalida")
        }
        this.carrera = carrera;
    }


    //Año de ingreso

    public int getAnioIngreso()
    {
        return anioIngreso;
    }
    public void setAnioIngreso(int anioIngreso)
    {
        if (anioIngreso<2000)
        {
            throw new IllegalArgumentException("Año de ingreso invalido");
        }
        this.anioIngreso = anioIngreso;
    }


    //Inscripcion a materia
    public ArrayList<InscripcionMateria> getMaterias()
    {
        return materias;
    }
    public void inscribirse(Materia m)
    {
        if(getInscripcion(m.getCodigo())!=null)
        {
            throw new IllegalArgumentException("Ya esta inscripto en esa materia");
        }
        materias.add(new InscripcionMateria(m));
    }

    public void DarDeBaja(String codigoMateria)
    {
        materias.removeIf(i -> i.getMateria().getCodigo().equals(codigoMateria));
    }
    public InscripcionMateria getInscripcion(String codigoMateria)
    {
        for (InscripcionMateria i:materias)
        {
            if (i.getMateria() .getCodigo().equalsIgnoreCase(codigoMateria))
            {
                return i;
            }
        }
        return null;
    }


    //Promedio general
    public double getPromedioGeneral()
    {
        if (materias.isEmpty())
        {
            return 0;
        }
        double suma=0;
        for(InscripcionMateria i:materias)
        {
            suma = suma + i.getNota();
        }
        return suma/materias.size();
    }


    //Materias criticas(Asistencia entre 75% y 85%)

    public ArrayList<InscripcionMateria> getMateriasCriticas()
    {
        ArrayList<InscripcionMateria> criticas = new ArrayList<>();
        for(InscripcionMateria i:materias)
        {
            double p =i.getPorcentajeAsistencia();
            if (p>=75 && p<=85)
            {
                criticas.add(i);
            }
        }
        return criticas;
    }

}
