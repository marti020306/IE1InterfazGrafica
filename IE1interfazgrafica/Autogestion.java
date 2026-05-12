package IE1interfazgrafica;

import java.util.Scanner;

public class Autogestion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Estudiante alumno = new Estudiante("Martina", "123", "Sistemas", 2023);
        
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE AUTOGESTIÓN ===");
            System.out.println("1. Ver Perfil");
            System.out.println("2. Gestión de Materias (Inscribir/Baja/Listar)");
            System.out.println("3. Registrar Asistencia");
            System.out.println("4. Registrar Calificación");
            System.out.println("5. Ver Reportes Académicos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); 


            switch (opcion) {
                case 1:
                    alumno.mostrarResumen();
                    break;
                case 2:
                    menuMaterias(alumno, sc);    
                    break;
                case 3:
                    registrarAsistencia(alumno, sc); 
                    break;
                case 4:
                    registrarNota(alumno, sc);      
                    break;
                case 5:
                    mostrarReportes(alumno);       
                    break;
                case 0:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (opcion != 0);
        sc.close();
   
  
    }

     private static void menuMaterias(Estudiante alumno, Scanner sc) {
        System.out.println("\n--- GESTIÓN DE MATERIAS ---");
        System.out.println("a. Inscribirse a Materia");
        System.out.println("b. Darse de Baja");
        System.out.println("c. Listar Materias");
        System.out.println("d. Buscar por Nombre (Sobrecarga)");
        System.out.print("Opción: ");
        String subOp = sc.nextLine();

        
         switch (subOp.toLowerCase()) {
            case "a":
                System.out.print("Nombre: "); String n = sc.nextLine();
                System.out.print("Código: "); String c = sc.nextLine();
                System.out.print("Cuatrimestre: "); int cu = sc.nextInt();
                System.out.print("Año: "); int a = sc.nextInt(); sc.nextLine();
                alumno.inscribirse(new Materia(n, c, cu, a));
                System.out.println("Inscrito correctamente.");
                break;
            case "b":
                System.out.print("Código de materia para baja: ");
                alumno.darDeBaja(sc.nextLine());
                System.out.println("Materia eliminada.");
                break;
            case "c":
                System.out.println("Materias de " + alumno.getNombre() + ":");
                for (InscripcionMateria i : alumno.getMaterias()) {
                    System.out.println("- " + i.getMateria().getNombre() + " (" + i.getCondicion() + ")");
                }
                break;
            case "d":
                System.out.print("Nombre de la materia: ");
                alumno.buscarMateria(sc.nextLine(), true); 
                break;
            default:
                System.out.println("Opción inválida.");
                break;
        }
    }








}    