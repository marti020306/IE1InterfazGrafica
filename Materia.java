package ie1interfazgrafica;

public class Materia implements Consultable
{
    private String nombre;
    private String codigo;
    private int cuatrimestre;
    private int anio;

    public Materia (String nombre, String codigo, int cautrimestre, int anio )
    {
        this.nombre=nombre;
        setCodigo(codigo);
        setCuatrimestre(cuatrimestre);
        this.anio = anio;
    }
    public String getNombre()
    {
        return nombre;
    }

    public String getCodigo()
    {
        return codigo;
    }
    public int getCuatrimestre()
    {
        return cuatrimestre;
    }
    public int getAnio()
    {
        return anio;
    }

    public void setCodigo (String codigo)
    {
        if (codigo ==  null || codigo.length() < 3 || codigo.length() > 10)
        {
            throw new IllegalArgumentException("Codigo debe tener entre 3 y 10 caracteres");
        }
        this.codigo=codigo;
    }

    public void setCuatrimestre (int cuatrimestre)
    {
        if (cuatrrimestre != 1 && cuatrimestre != 2)
        {
            throw new IllegalrgumentException("Cuatrimestre debe ser 1 o 2");
        }
        this.cuatrimestre=cuatrimestre;
    }
    public void SetAnio (int anio)
    {
        if (anio<2000)
        {
            throw new IllegalArgumentException("Año invalido")
        }
        this.anio=anio;
    }
    @Override
    public void mostrarResumen()
    {
        System.out.println("[" + codigo + "] " + nombre + "- " + cuatrimestre + "° cuatrimestre" + anio);
         
    }
}
