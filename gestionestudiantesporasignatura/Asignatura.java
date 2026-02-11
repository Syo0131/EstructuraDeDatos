package gestionestudiantesporasignatura;

/**
 * Clase que representa una asignatura que puede tener varios grupos
 */
public class Asignatura {
    private String nombreAsignatura;
    private String codigo;
    private Grupo[] grupos; // Arreglo de grupos
    private int numeroGrupos; // Contador de grupos

    // Constructor
    public Asignatura(String nombreAsignatura, String codigo) {
        this.nombreAsignatura = nombreAsignatura;
        this.codigo = codigo;
        this.grupos = new Grupo[10]; // Maximo 10 grupos por asignatura
        this.numeroGrupos = 0;
    }

    // Metodos getter
    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public String getCodigo() {
        return codigo;
    }

    public Grupo[] getGrupos() {
        return grupos;
    }

    public int getNumeroGrupos() {
        return numeroGrupos;
    }

    /**
     * Metodo para agregar un grupo a la asignatura
     */
    public OperationResult agregarGrupo(Grupo grupo) {
        // Validar que el grupo no sea nulo
        if (grupo == null) {
            return new OperationResult("El grupo no puede ser nulo", false);
        }

        // Verificar que no se exceda el limite de grupos
        if (numeroGrupos >= grupos.length) {
            return new OperationResult("La asignatura ya tiene el maximo de grupos", false);
        }

        // Verificar que el grupo no este ya registrado
        for (int i = 0; i < numeroGrupos; i++) {
            if (grupos[i].getNombreGrupo().equals(grupo.getNombreGrupo())) {
                return new OperationResult("El grupo ya existe en esta asignatura", false);
            }
        }

        // Agregar el grupo
        grupos[numeroGrupos] = grupo;
        numeroGrupos++;

        return new OperationResult("Grupo agregado correctamente a la asignatura", true);
    }

    /**
     * Metodo para buscar un grupo por su nombre
     */
    public Grupo buscarGrupo(String nombreGrupo) {
        for (int i = 0; i < numeroGrupos; i++) {
            if (grupos[i].getNombreGrupo().equals(nombreGrupo)) {
                return grupos[i];
            }
        }
        return null;
    }

    /**
     * Metodo para listar todos los grupos de la asignatura
     */
    public void listarGrupos() {
        System.out.println("\nGrupos de la asignatura " + nombreAsignatura + ":");
        if (numeroGrupos == 0) {
            System.out.println("No hay grupos registrados.");
        } else {
            for (int i = 0; i < numeroGrupos; i++) {
                System.out.println((i + 1) + ". " + grupos[i].getNombreGrupo() +
                        " - " + grupos[i].getNumeroEstudiantes() + " estudiantes");
            }
        }
    }
}
