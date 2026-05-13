# IE1InterfazGrafica

Sistema de Autogestión Académica

Descripción del proyecto
Este proyecto consiste en un sistema de autogestión académica desarrollado en Java utilizando Programación Orientada a Objetos. El sistema permite administrar estudiantes, materias, inscripciones, asistencia y notas, aplicando conceptos como:
● Herencia
● Polimorfismo
● Interfaces
● Encapsulamiento
● Clases abstractas
● Validaciones 
● Uso de colecciones dinámicas (ArrayList) 
Trabajo colaborativo con Git y GitHub.
El programa funciona mediante consola utilizando un menú interactivo.

Instrucciones de ejecución Requisitos 

● Java JDK 17 o superior 
● NetBeans / Visual Studio Code 
● Extensión Java Extension Pack (en VS Code)

Ejecución

1. Clonar el repositorio: git clone URL_DEL_REPOSITORIO
2. Abrir el proyecto en NetBeans o VS Code.
3. Ejecutar la clase: Autogestion.java / rama InsepcionAcademica Estructura del proyecto

Clases principales

Persona Académica
Clase abstracta base que contiene:
● nombre 
● legajo 
● método abstracto mostrarResumen()

Estudiante 
Clase que hereda de PersonaAcademica. Funciones principales:
● carrera y año de ingreso
● inscripción a materias 
● baja de materias 
● cálculo de promedio general (implementado con recursividad)
● materias críticas 
● búsqueda de materias por nombre 
● visualización del perfil del estudiante

Materia
Representa una materia académica. Incluye:
● nombre 
● código
● cuatrimestre
● año
● validaciones 
● resumen de materia

InscripcionMateria 
Representa la cursada de una materia. Incluye: 
● asistencia
● notas
● condición académica
● aprobación 
● cálculo de promedio

Interfaces
Consultable
Define: void mostrarResumen();

Evaluable 
Define: String getCondicion(); 
double getNota();
boolean estaAprobado(); 

También incluye un método default: 
mostrarEstadoAcademico(); 

Autogestion
Clase principal con menú interactivo por consola. 
Permite:
● ver perfil
● inscribirse a materias
● registrar asistencia 
● registrar notas
● consultar materias
● generar reportes 

Integrantes y roles

Martina Roldán — "Persona Académica" 
Responsable de:
● Interfaces Evaluable y Consultable 
● Clase abstracta PersonaAcademica
● Validaciones generales
● Explicación de conceptos POO 
● Integración inicial de arquitectura

Guadalupe Astudillo — "Cursada" 
Responsable de:  
● Clase Materia
● Clase InscripcionMateria
● Validaciones de materias y notas
● Registro de asistencia 
● Cálculo de porcentaje de asistencia
● Condición académica (Regular / Libre) 
● Cálculo de promedio
● Verificación de aprobación 

Sofía Delgado — "Gestión Académica"
Responsable de: 
● Clase Estudiante
● Inscripción y baja de materias 
● Búsqueda de inscripciones
● Promedio general (cálculo recursivo)
● Materias críticas 
● Resumen del estudiante

Leandro Gaido — "Interfaz y experiencia"
Responsable de:
● Clase principal Autogestion 
● Menú interactivo
● Scanner y entrada de datos
● Reportes
● Flujo general del sistema
● Integración final y pruebas

Desafíos encontrados
Durante el desarrollo surgieron distintos desafíos, entre ellos: 
● Gestión de ramas y uso de Git en VS Code: Faltaba costumbre de hacer git pull antes de comenzar a trabajar en las ramas, lo que impedía ver completamente los cambios actualizados del equipo y provocaba desfasajes en el desarrollo.
● Organización y dependencias de código: Coordinar qué debía programar cada integrante primero para que los demás pudieran avanzar (por ejemplo, las interfaces de Martina debían crearse antes de que las clases de Sofía o Guadalupe pudieran implementarlas o compilarlas).
● Inconsistencias y conflictos de compilación: Problemas de compatibilidad al integrar el código porque los métodos y variables debían llamarse exactamente igual. 
Hubo errores debido a sutiles diferencias entre mayúsculas y minúsculas (ej. usar MostrarResumen() en vez de mostrarResumen()) o usar terminaciones diferentes (ej. estaAprobada() cuando la interfaz exigía estaAprobado()). 

Uso de IA y herramientas externas

Se recurrió a IA (como Claude) y a búsquedas externas para comprender y resolver obstáculos de programación, tales como: 
● Trabajo colaborativo: Apoyo para definir una ruta secuencial clara para la creación de código, las dependencias y la realización correcta de los merges en GitHub.
● Conceptos de POO: Reforzar el concepto de polimorfismo y entender las diferencias de uso en Java entre implements (para relacionar con interfaces) y extends (para heredar de una clase padre). Diferencias clave entre la sobrecarga (overload) y la sobreescritura (override) de métodos.
● Excepciones y validaciones: Comprender a fondo el mecanismo defensivo de throw new IllegalArgumentException para detener la ejecución ante datos que no son válidos. 
● Manejo de colecciones: Entender la naturaleza dinámica de las listas ArrayList y la sintaxis de expresiones lambda en Java moderno junto con el método removeIf para filtrar y eliminar elementos de forma limpia y directa.

Conceptos aplicados 
● Programación Orientada a Objetos
● Herencia
● Polimorfismo
● Encapsulamiento 
● Interfaces 
● Clases abstractas 
● Sobrescritura de métodos (@Override)
● Colecciones dinámicas (ArrayList)
● Validaciones con excepciones 
● Git y GitHub para trabajo colaborativo
● Recursividad 


Link De los Archivos: https://drive.google.com/drive/folders/1uuxX8CpO4Vz4udkca6teTfnn2vq3HALv?usp=sharing

[IE Interfaz Gráfica- Entrega(Delgado, Roldán, Gaido y Astudillo)-20260513T223224Z-3-001.zip](https://github.com/user-attachments/files/27734647/IE.Interfaz.Grafica-.Entrega.Delgado.Roldan.Gaido.y.Astudillo.-20260513T223224Z-3-001.zip)


