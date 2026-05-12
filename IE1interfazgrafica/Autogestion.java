package IE1interfazgrafica;

import java.util.Scanner;

public class Autogestion 
{

    public static void main(String[] args) {

       
        Scanner sc = new Scanner(System.in);
        Estudiante alumno = new Estudiante("Martina", "123", "Sistemas", 2023);
        Materia m1 = new Materia("Matematica", "MAT", 1, 2024);
        Materia m2 = new Materia("Programacion", "PRO", 1, 2024);
        Materia m3 = new Materia("Base de Datos", "BDD", 2, 2024);
        alumno.inscribirse(m1);
        alumno.inscribirse(m2);
        alumno.inscribirse(m3);
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE AUTOGESTION ===");
            System.out.println("1. Ver Perfil");
            System.out.println("2. Gestion de Materias (Inscribir/Baja/Listar)");
            System.out.println("3. Registrar Asistencia");
            System.out.println("4. Registrar Calificacion");
            System.out.println("5. Ver Reportes Académicos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            
            opcion = sc.nextInt();
            sc.nextLine(); 

            // Se cambia -> por : y se agrega el break;
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

        // Se cambia -> por : y se agrega el break;
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

    private static void registrarAsistencia(Estudiante alumno, Scanner sc) {
        System.out.print("Código de materia: ");
        String cod = sc.nextLine();
        InscripcionMateria i = alumno.buscarMateria(cod);
        if (i != null) {
            System.out.print("¿Estuvo presente? (true/false): ");
            i.registrarAsistencia(sc.nextBoolean());
            sc.nextLine(); 
            
            double porc = i.getPorcentajeAsistencia();
            System.out.println("Asistencia actual: " + porc + "%");
            
            if (porc < 75) System.out.println(">>> ALERTA: El alumno ha quedado LIBRE.");
            else if (porc < 80) System.out.println(">>> AVISO: Alumno en ZONA DE RIESGO.");
        } else {
            System.out.println("Materia no encontrada.");
        }
    }

    private static void registrarNota(Estudiante alumno, Scanner sc) {
        System.out.print("Código de materia: ");
        String cod = sc.nextLine();
        InscripcionMateria i = alumno.buscarMateria(cod);
        if (i != null) {
            System.out.print("Ingrese la nota (0-10): ");
            double nota = sc.nextDouble(); sc.nextLine();
            i.agregarNota(nota);
            
            System.out.println("Lista de notas: " + i.getNotas());
            System.out.println("Nuevo promedio: " + i.getNota());
            
            if (nota >= 6) System.out.println("¡Instancia Aprobada!");
            else System.out.println("Instancia No Aprobada.");
        }
    }

    private static void mostrarReportes(Estudiante alumno) {
        System.out.println("\n========== REPORTES ACADÉMICOS ==========");
        System.out.println("\n1. SITUACIÓN GENERAL:");
        for (InscripcionMateria i : alumno.getMaterias()) {
            System.out.println("Materia: " + i.getMateria().getNombre() +
            " | Estado: " + i.getCondicion() +
            " | Asistencia: " + i.getPorcentajeAsistencia() + "%" +
            " | Promedio: " + i.getNota());
           
        }
        System.out.println("PROMEDIO GENERAL (RECURSIVO): " + String.format("%.2f", alumno.getPromedioGeneral()));

        System.out.println("\n2. MATERIAS EN RIESGO (Asistencia 75%-85%):");
        if (alumno.getMateriasCriticas().isEmpty()) {
            System.out.println("No hay materias en riesgo.");
        } else {
            for (InscripcionMateria i : alumno.getMateriasCriticas()) {
                System.out.println("!!! " + i.getMateria().getNombre() + " - Asistencia: " + i.getPorcentajeAsistencia() + "%");
            }
        }
        System.out.println("\n3. MATERIAS APROBADAS:");
        double max = 0, min = 10, sumaAp = 0;
        int cantAp = 0;
        for (InscripcionMateria i : alumno.getMaterias())
        {
            if (i.estaAprobado())
            {
                double p = i.getNota();
                System.out.println("- " + i.getMateria().getNombre() + " | Promedio: " + p);
                if (p > max) max = p;
                if (p < min) min = p;
                sumaAp += p;
                cantAp++;
            }
        }
        if (cantAp == 0)
            System.out.println("No hay materias aprobadas.");
        else
            System.out.println("Max: " + max + " | Min: " + min + " | Promedio: " + (sumaAp/cantAp));

        System.out.println("==========================================");
    }
}