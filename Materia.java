package academico;

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
        setAnio(anio);
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


}
