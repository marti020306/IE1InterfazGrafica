package IE1interfazgrafica;
import java.util.Scanner;
public class Autogestion 
{
    public static void main(String[] args)
    { 

        Scanner sc = new Scanner(System.in);
            Estudiante alumno = new Estudiante ("Martina", "123","Sistemas", 2023);
    
        int opcion;
        do
        {
            System.out.println("\n===MENU===");
            System.out.println("1. Ver Perfil");
            System.out.println("2. Inscribirse a Materia");
            System.out.println("3. Registrar Asistencia");
            System.out.println("4. Registrar Nota");
            System.out.println("5. Ver Materias");
            System.out.println("0. Salir");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion)
            {
                 case 1: alumno.mostrarResumen();
                    break;

                     case 2: { System.out.print("Nombre:");
                     String nombre = sc.nextLine();
                     System.out.print("Codigo:");
                     String codigo = sc.nextLine();
                     System.out.print("Cuatrimestre:");
                     int cuatri = sc.nextInt();
                     System.out.print("Año:");
                     int anio = sc.nextInt();
                     Materia m = new Materia(nombre, codigo, cuatri, anio);
                     alumno.inscribirse(m); }
                        break;

                        case 3: {System.out.print("Codigo materia: ");
                         String cod = sc.nextLine();
                        InscripcionMateria i = alumno.getInscripcion(cod);
                  
                        if (i != null)
                        {System.out.print("¿Presente? (true/false): ");
                         boolean p = sc.nextBoolean();
                        sc.nextLine();
                        i.registrarAsistencia(p);
                        }
                        }
                        break;

                             case 4: {System.out.print("Codigo materia: ");
                             String cod = sc.nextLine();
                             InscripcionMateria i = alumno.getInscripcion(cod);
                             if (i != null)
                            {
                             System.out.print("Nota: ");
                             double nota = sc.nextDouble();
                             sc.nextLine();
                             i.agregarNota(nota);
                            }
                        }
                        break;

                            case 5: { for (InscripcionMateria i: alumno.getMaterias())
                            { 
                                System.out.println(i.getMateria().getNombre());
                                i.mostrarEstadoAcademico();
                            }
                        }
                        break;
                           
                    case 0: System.out.println("Chau!");
                    break;

                    default: System.out.println("Opcion Invalida");
                    break;    

                }
            } while (opcion != 0);
              sc.close();
        }
    }   



