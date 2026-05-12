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