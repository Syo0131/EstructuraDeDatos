package gestionestudiantesporasignatura;

/**
 * Clase que demuestra el funcionamiento del sistema con ejemplos
 * Muestra cómo se verían los reportes con datos reales
 */
public class DatosEjemplo {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║  DEMOSTRACIÓN DEL SISTEMA DE GESTION          ║");
        System.out.println("║  DE ESTUDIANTES POR ASIGNATURA                ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        demostrarSistema();

        System.out.println("\n\n╔════════════════════════════════════════════════╗");
        System.out.println("║  FIN DE LA DEMOSTRACION                        ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("\nPara usar el sistema interactivo, ejecute:");
        System.out.println("  java gestionestudiantesporasignatura.SistemaGestion");
    }

    /**
     * Método que demuestra el uso del sistema con datos de ejemplo
     */
    public static void demostrarSistema() {
        // Crear asignaturas
        Asignatura programacion = new Asignatura("Programacion I", "PROG101");
        Asignatura estructuras = new Asignatura("Estructura de Datos", "EST201");

        // Crear grupos para Programación I
        Grupo grupoA = new Grupo("Grupo A");
        Grupo grupoB = new Grupo("Grupo B");

        // Agregar grupos a Programación I
        programacion.agregarGrupo(grupoA);
        programacion.agregarGrupo(grupoB);

        // Crear grupo para Estructura de Datos
        Grupo grupoC = new Grupo("Grupo C");
        estructuras.agregarGrupo(grupoC);

        // Crear estudiantes para Grupo A
        Estudiante est1 = new Estudiante("Juan Perez", "001-2024", "Presencial");
        est1.agregarCalificacion(85);
        est1.agregarCalificacion(90);
        est1.agregarCalificacion(78);

        Estudiante est2 = new Estudiante("Maria Gonzalez", "002-2024", "Presencial");
        est2.agregarCalificacion(92);
        est2.agregarCalificacion(88);
        est2.agregarCalificacion(95);

        Estudiante est3 = new Estudiante("Carlos Rodriguez", "003-2024", "Distancia");
        est3.agregarCalificacion(65);
        est3.agregarCalificacion(70);
        est3.agregarCalificacion(68);

        Estudiante est4 = new Estudiante("Ana Martinez", "004-2024", "Presencial");
        est4.agregarCalificacion(75);
        est4.agregarCalificacion(80);
        est4.agregarCalificacion(85);

        // Agregar estudiantes al Grupo A
        grupoA.agregarEstudiante(est1);
        grupoA.agregarEstudiante(est2);
        grupoA.agregarEstudiante(est3);
        grupoA.agregarEstudiante(est4);

        // Crear estudiantes para Grupo B
        Estudiante est5 = new Estudiante("Pedro Lopez", "005-2024", "Distancia");
        est5.agregarCalificacion(55);
        est5.agregarCalificacion(60);
        est5.agregarCalificacion(58);

        Estudiante est6 = new Estudiante("Laura Sanchez", "006-2024", "Presencial");
        est6.agregarCalificacion(90);
        est6.agregarCalificacion(95);
        est6.agregarCalificacion(92);

        Estudiante est7 = new Estudiante("Diego Torres", "007-2024", "Presencial");
        est7.agregarCalificacion(80);
        est7.agregarCalificacion(82);
        est7.agregarCalificacion(78);

        // Agregar estudiantes al Grupo B
        grupoB.agregarEstudiante(est5);
        grupoB.agregarEstudiante(est6);
        grupoB.agregarEstudiante(est7);

        // Crear estudiantes para Grupo C
        Estudiante est8 = new Estudiante("Sofia Ramirez", "008-2024", "Presencial");
        est8.agregarCalificacion(88);
        est8.agregarCalificacion(90);

        Estudiante est9 = new Estudiante("Miguel Angel Castro", "009-2024", "Distancia");
        est9.agregarCalificacion(72);
        est9.agregarCalificacion(75);

        // Agregar estudiantes al Grupo C
        grupoC.agregarEstudiante(est8);
        grupoC.agregarEstudiante(est9);

        // Mostrar reportes de demostracion
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║     DEMOSTRACION DEL SISTEMA                   ║");
        System.out.println("╚════════════════════════════════════════════════╝");

        System.out.println("\n===== PROGRAMACION I =====");
        System.out.println("\n--- Reporte del Grupo A ---");
        grupoA.mostrarListadoCalificaciones();

        System.out.println("\n--- Reporte del Grupo B ---");
        grupoB.mostrarListadoCalificaciones();

        System.out.println("\n===== ESTRUCTURA DE DATOS =====");
        System.out.println("\n--- Reporte del Grupo C ---");
        grupoC.mostrarListadoCalificaciones();

        // Mostrar resumen general
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║     RESUMEN GENERAL                            ║");
        System.out.println("╚════════════════════════════════════════════════╝");
        System.out.println("Total de asignaturas: 2");
        System.out.println("Total de grupos: 3");
        System.out.println("Total de estudiantes: 9");
        System.out.println("\nEstadisticas:");
        System.out.println("- Grupo A: " + String.format("%.2f", grupoA.calcularPorcentajeAprobados()) + "% aprobados");
        System.out.println("- Grupo B: " + String.format("%.2f", grupoB.calcularPorcentajeAprobados()) + "% aprobados");
        System.out.println("- Grupo C: " + String.format("%.2f", grupoC.calcularPorcentajeAprobados()) + "% aprobados");
    }
}
