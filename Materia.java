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

    public void setCodigo (String codigo)
    {
        if (codigo== null || codigo.length() < 3 || codigo.length() > 10)
        {
            throw new IllegalArgumentException("Codigo debe tener entre 3 y 10 caracteres");
        }
        this.codigo = codigo;
    }
    
    public void setCuatrimestre (int cuatrimestre)
    {
        if (cuatrimestre != 1 && cuatrimestre != 2)
        {
            throw new IllegalArgumentException("Cutrimestre debd ser 1 o 2");
        }
        this.cuatrimestre= cuatrimestre;
    } 
    public void setAnio (int anio)
    {

        if (anio< 2000)
        {
            throw new IllegalArgumentException ("Ano invalido");
        }
        this.anio = anio;
    }
}
