package IE1interfazgrafica;

public interface Evaluable {

    String getCondicion();
    double getNota();
    boolenan estaAprobado();

}

default void mostrarEstadoAcademico() {

    System.out.println("Condicion: " + getCondicion());
    System.out.println("Promedio; " + getNota());
}
