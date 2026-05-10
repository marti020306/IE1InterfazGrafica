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
    

}
