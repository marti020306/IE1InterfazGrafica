package IE1interfazgrafica;
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

    // --- MÉTODOS DE BÚSQUEDA 
    public InscripcionMateria buscarMateria(String codigo) {
        for (InscripcionMateria i : materias) {
            if (i.getMateria().getCodigo().equalsIgnoreCase(codigo)) {
                return i;
            }
        }
        return null;
    }

    public void buscarMateria(String nombre, boolean esNombre) {
        boolean encontrada = false;
        for (InscripcionMateria i : materias) {
            if (i.getMateria().getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                System.out.println("Encontrada: " + i.getMateria().getNombre() + " [" + i.getMateria().getCodigo() + "]");
                encontrada = true;
            }
        }
        if (!encontrada) System.out.println("No se encontraron materias con ese nombre.");
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
            throw new IllegalArgumentException("Carrera invalida");
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

    public void darDeBaja(String codigoMateria)
    {
        materias.removeIf(i -> i.getMateria().getCodigo().equalsIgnoreCase(codigoMateria));
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
  
    public double getPromedioGeneral() {
        if (materias.isEmpty()) return 0;
        return calcularSumaNotasRecursiva(0) / materias.size();
    }

    private double calcularSumaNotasRecursiva(int index) {
        if (index == materias.size()) return 0;
        return materias.get(index).getNota() + calcularSumaNotasRecursiva(index + 1);
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

    //Mostrar resultados
    @Override
    public void mostrarResumen()
    {
        System.out.println("===Perfil del estudiante ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Legajo: " + getLegajo());
        System.out.println("Carrera: " + getCarrera());
        System.out.println("Año de ingreso: " + getAnioIngreso());
        System.out.println("Promedio General: " + String.format("%.2f", getPromedioGeneral()));
    }
}
