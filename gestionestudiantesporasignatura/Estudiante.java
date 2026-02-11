package gestionestudiantesporasignatura;

/**
 * Clase que representa a un estudiante
 * Hereda de Persona y anade informacion especifica de estudiantes
 */
public class Estudiante extends Persona {
    private String tipoEstudiante; // "Presencial" o "Distancia"
    private double[] calificaciones; // Arreglo para almacenar las calificaciones
    private int numeroCalificaciones; // Contador de calificaciones registradas

    // Constructor
    public Estudiante(String nombre, String identificacion, String tipoEstudiante) {
        super(nombre, identificacion);
        this.tipoEstudiante = tipoEstudiante;
        this.calificaciones = new double[10]; // Maximo 10 calificaciones por estudiante
        this.numeroCalificaciones = 0;
    }

    // Metodos getter y setter
    public String getTipoEstudiante() {
        return tipoEstudiante;
    }

    public void setTipoEstudiante(String tipoEstudiante) {
        this.tipoEstudiante = tipoEstudiante;
    }

    public double[] getCalificaciones() {
        return calificaciones;
    }

    public int getNumeroCalificaciones() {
        return numeroCalificaciones;
    }

    /**
     * Metodo para agregar una calificacion al estudiante
     */
    public OperationResult agregarCalificacion(double calificacion) {
        // Validar que la calificacion este en el rango correcto
        if (calificacion < 0 || calificacion > 100) {
            return new OperationResult("La calificacion debe estar entre 0 y 100", false);
        }

        // Verificar que no se exceda el limite de calificaciones
        if (numeroCalificaciones >= calificaciones.length) {
            return new OperationResult("El estudiante ya tiene el maximo de calificaciones", false);
        }

        // Agregar la calificacion
        calificaciones[numeroCalificaciones] = calificacion;
        numeroCalificaciones++;

        return new OperationResult("Calificacion agregada correctamente", true);
    }

    /**
     * Metodo para calcular el promedio de calificaciones
     */
    public double calcularPromedio() {
        if (numeroCalificaciones == 0) {
            return 0.0;
        }

        double suma = 0;
        for (int i = 0; i < numeroCalificaciones; i++) {
            suma += calificaciones[i];
        }

        return suma / numeroCalificaciones;
    }

    /**
     * Metodo para verificar si el estudiante esta aprobado
     * Se considera aprobado si el promedio es >= 70
     */
    public boolean estaAprobado() {
        return calcularPromedio() >= 70;
    }

    /**
     * Sobreescritura del metodo obtenerInformacion
     */
    @Override
    public String obtenerInformacion() {
        String info = super.obtenerInformacion();
        info += ", Tipo: " + tipoEstudiante;

        if (numeroCalificaciones > 0) {
            info += ", Promedio: " + String.format("%.2f", calcularPromedio());
            info += ", Estado: " + (estaAprobado() ? "Aprobado" : "Reprobado");
        } else {
            info += ", Sin calificaciones";
        }

        return info;
    }

    /**
     * Metodo para obtener todas las calificaciones en formato de texto
     */
    public String obtenerCalificacionesTexto() {
        if (numeroCalificaciones == 0) {
            return "Sin calificaciones";
        }

        String texto = "";
        for (int i = 0; i < numeroCalificaciones; i++) {
            texto += String.format("%.2f", calificaciones[i]);
            if (i < numeroCalificaciones - 1) {
                texto += ", ";
            }
        }
        return texto;
    }
}
