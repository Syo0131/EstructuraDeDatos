package gestionestudiantesporasignatura;

/**
 * Clase base que representa a una persona
 * Esta clase sirve como base para otras clases como Estudiante o Docente
 */
public class Persona {
    protected String nombre;
    protected String identificacion;

    // Constructor vacio
    public Persona() {
    }

    // Constructor con parametros
    public Persona(String nombre, String identificacion) {
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    // Metodos getter y setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    // Metodo que puede ser sobreescrito por las clases hijas
    public String obtenerInformacion() {
        return "Nombre: " + nombre + ", ID: " + identificacion;
    }

    @Override
    public String toString() {
        return obtenerInformacion();
    }
}
