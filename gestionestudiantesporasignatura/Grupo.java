package gestionestudiantesporasignatura;

/**
 * Clase que representa un grupo de estudiantes dentro de una asignatura
 */
public class Grupo {
    private String nombreGrupo;
    private Estudiante[] estudiantes; // Arreglo de estudiantes
    private int numeroEstudiantes; // Contador de estudiantes en el grupo

    // Constructor
    public Grupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
        this.estudiantes = new Estudiante[50]; // Maximo 50 estudiantes por grupo
        this.numeroEstudiantes = 0;
    }

    // Metodos getter
    public String getNombreGrupo() {
        return nombreGrupo;
    }

    public Estudiante[] getEstudiantes() {
        return estudiantes;
    }

    public int getNumeroEstudiantes() {
        return numeroEstudiantes;
    }

    /**
     * Metodo para agregar un estudiante al grupo
     */
    public OperationResult agregarEstudiante(Estudiante estudiante) {
        // Validar que el estudiante no sea nulo
        if (estudiante == null) {
            return new OperationResult("El estudiante no puede ser nulo", false);
        }

        // Verificar que no se exceda el limite de estudiantes
        if (numeroEstudiantes >= estudiantes.length) {
            return new OperationResult("El grupo ya esta lleno", false);
        }

        // Verificar que el estudiante no este ya registrado
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (estudiantes[i].getIdentificacion().equals(estudiante.getIdentificacion())) {
                return new OperationResult("El estudiante ya esta registrado en este grupo", false);
            }
        }

        // Agregar el estudiante
        estudiantes[numeroEstudiantes] = estudiante;
        numeroEstudiantes++;

        return new OperationResult("Estudiante agregado correctamente al grupo", true);
    }

    /**
     * Metodo para buscar un estudiante por su identificacion
     */
    public Estudiante buscarEstudiante(String identificacion) {
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (estudiantes[i].getIdentificacion().equals(identificacion)) {
                return estudiantes[i];
            }
        }
        return null;
    }

    /**
     * Metodo para calcular el porcentaje de estudiantes aprobados
     */
    public double calcularPorcentajeAprobados() {
        if (numeroEstudiantes == 0) {
            return 0.0;
        }

        int aprobados = 0;
        for (int i = 0; i < numeroEstudiantes; i++) {
            if (estudiantes[i].estaAprobado()) {
                aprobados++;
            }
        }

        return (aprobados * 100.0) / numeroEstudiantes;
    }

    /**
     * Metodo para mostrar el listado de calificaciones del grupo
     */
    public void mostrarListadoCalificaciones() {
        System.out.println("\n========================================");
        System.out.println("LISTADO DE CALIFICACIONES - GRUPO: " + nombreGrupo);
        System.out.println("========================================");

        if (numeroEstudiantes == 0) {
            System.out.println("No hay estudiantes registrados en este grupo.");
            return;
        }

        System.out.println(String.format("%-20s %-15s %-15s %-20s %-10s %-10s",
                "Nombre", "ID", "Tipo", "Calificaciones", "Promedio", "Estado"));
        System.out.println("----------------------------------------"
                + "----------------------------------------"
                + "----------------------------------------");

        for (int i = 0; i < numeroEstudiantes; i++) {
            Estudiante est = estudiantes[i];
            System.out.println(String.format("%-20s %-15s %-15s %-20s %-10.2f %-10s",
                    est.getNombre(),
                    est.getIdentificacion(),
                    est.getTipoEstudiante(),
                    est.obtenerCalificacionesTexto(),
                    est.calcularPromedio(),
                    est.estaAprobado() ? "Aprobado" : "Reprobado"));
        }

        System.out.println("----------------------------------------"
                + "----------------------------------------"
                + "----------------------------------------");
        System.out.println("Total de estudiantes: " + numeroEstudiantes);
        System.out.println("Porcentaje de aprobados: " +
                String.format("%.2f", calcularPorcentajeAprobados()) + "%");
        System.out.println("========================================\n");
    }
}
