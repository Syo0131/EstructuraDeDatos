package gestionestudiantesporasignatura;

import java.util.Scanner;

/**
 * Clase principal que contiene el menu y la logica del sistema de gestion
 */
public class SistemaGestion {
    private Asignatura[] asignaturas; // Arreglo de asignaturas
    private int numeroAsignaturas; // Contador de asignaturas
    private Scanner scanner;

    public static void main(String[] args) {
        SistemaGestion sistema = new SistemaGestion();
        sistema.ejecutar();
    }

    // Constructor
    public SistemaGestion() {
        this.asignaturas = new Asignatura[20]; // Maximo 20 asignaturas
        this.numeroAsignaturas = 0;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Metodo para buscar una asignatura por codigo
     */
    private Asignatura buscarAsignatura(String codigo) {
        for (int i = 0; i < numeroAsignaturas; i++) {
            if (asignaturas[i].getCodigo().equals(codigo)) {
                return asignaturas[i];
            }
        }
        return null;
    }

    /**
     * Metodo para crear una nueva asignatura
     */
    private void crearAsignatura() {
        System.out.println("\n=== CREAR NUEVA ASIGNATURA ===");

        if (numeroAsignaturas >= asignaturas.length) {
            System.out.println("Error: Se alcanzo el limite de asignaturas.");
            return;
        }

        System.out.print("Ingrese el nombre de la asignatura: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese el codigo de la asignatura: ");
        String codigo = scanner.nextLine();

        // Verificar que no exista una asignatura con el mismo codigo
        if (buscarAsignatura(codigo) != null) {
            System.out.println("Error: Ya existe una asignatura con ese codigo.");
            return;
        }

        Asignatura nuevaAsignatura = new Asignatura(nombre, codigo);
        asignaturas[numeroAsignaturas] = nuevaAsignatura;
        numeroAsignaturas++;

        System.out.println("Asignatura creada exitosamente.");
    }

    /**
     * Metodo para crear un nuevo grupo en una asignatura
     */
    private void crearGrupo() {
        System.out.println("\n=== CREAR NUEVO GRUPO ===");

        if (numeroAsignaturas == 0) {
            System.out.println("Error: Primero debe crear una asignatura.");
            return;
        }

        // Mostrar asignaturas disponibles
        System.out.println("\nAsignaturas disponibles:");
        for (int i = 0; i < numeroAsignaturas; i++) {
            System.out.println((i + 1) + ". " + asignaturas[i].getNombreAsignatura() +
                    " (" + asignaturas[i].getCodigo() + ")");
        }

        System.out.print("\nIngrese el código de la asignatura: ");
        String codigo = scanner.nextLine();

        Asignatura asignatura = buscarAsignatura(codigo);
        if (asignatura == null) {
            System.out.println("Error: No se encontró la asignatura con ese código.");
            return;
        }

        System.out.print("Ingrese el nombre del grupo: ");
        String nombreGrupo = scanner.nextLine();

        Grupo nuevoGrupo = new Grupo(nombreGrupo);
        OperationResult resultado = asignatura.agregarGrupo(nuevoGrupo);

        System.out.println(resultado.getMessage());
    }

    /**
     * Metodo para agregar un estudiante a un grupo
     */
    private void agregarEstudiante() {
        System.out.println("\n=== AGREGAR ESTUDIANTE ===");

        // Seleccionar asignatura
        Asignatura asignatura = seleccionarAsignatura();
        if (asignatura == null)
            return;

        // Seleccionar grupo
        Grupo grupo = seleccionarGrupo(asignatura);
        if (grupo == null)
            return;

        // Solicitar datos del estudiante
        System.out.print("\nIngrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese la identificacion del estudiante: ");
        String identificacion = scanner.nextLine();

        System.out.print("Tipo de estudiante (1=Presencial, 2=Distancia): ");
        String opcion = scanner.nextLine();
        String tipoEstudiante = opcion.equals("1") ? "Presencial" : "Distancia";

        // Crear y agregar el estudiante
        Estudiante nuevoEstudiante = new Estudiante(nombre, identificacion, tipoEstudiante);
        OperationResult resultado = grupo.agregarEstudiante(nuevoEstudiante);

        System.out.println(resultado.getMessage());
    }

    /**
     * Metodo para registrar calificaciones de un estudiante
     */
    private void registrarCalificacion() {
        System.out.println("\n=== REGISTRAR CALIFICACION ===");

        // Seleccionar asignatura
        Asignatura asignatura = seleccionarAsignatura();
        if (asignatura == null)
            return;

        // Seleccionar grupo
        Grupo grupo = seleccionarGrupo(asignatura);
        if (grupo == null)
            return;

        // Buscar estudiante
        System.out.print("\nIngrese la identificacion del estudiante: ");
        String identificacion = scanner.nextLine();

        Estudiante estudiante = grupo.buscarEstudiante(identificacion);
        if (estudiante == null) {
            System.out.println("Error: No se encontro el estudiante con esa identificacion.");
            return;
        }

        System.out.println("Estudiante encontrado: " + estudiante.getNombre());
        System.out.print("Ingrese la calificacion (0-100): ");

        try {
            double calificacion = Double.parseDouble(scanner.nextLine());
            OperationResult resultado = estudiante.agregarCalificacion(calificacion);
            System.out.println(resultado.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Debe ingresar un numero valido.");
        }
    }

    /**
     * Metodo para mostrar el listado de calificaciones de un grupo
     */
    private void mostrarListadoCalificaciones() {
        System.out.println("\n=== LISTADO DE CALIFICACIONES ===");

        // Seleccionar asignatura
        Asignatura asignatura = seleccionarAsignatura();
        if (asignatura == null)
            return;

        // Seleccionar grupo
        Grupo grupo = seleccionarGrupo(asignatura);
        if (grupo == null)
            return;

        // Mostrar el listado
        grupo.mostrarListadoCalificaciones();
    }

    /**
     * Metodo auxiliar para seleccionar una asignatura
     */
    private Asignatura seleccionarAsignatura() {
        if (numeroAsignaturas == 0) {
            System.out.println("Error: No hay asignaturas registradas.");
            return null;
        }

        System.out.println("\nAsignaturas disponibles:");
        for (int i = 0; i < numeroAsignaturas; i++) {
            System.out.println((i + 1) + ". " + asignaturas[i].getNombreAsignatura() +
                    " (" + asignaturas[i].getCodigo() + ")");
        }

        System.out.print("\nIngrese el codigo de la asignatura: ");
        String codigo = scanner.nextLine();

        Asignatura asignatura = buscarAsignatura(codigo);
        if (asignatura == null) {
            System.out.println("Error: No se encontro la asignatura con ese codigo.");
        }

        return asignatura;
    }

    /**
     * Metodo auxiliar para seleccionar un grupo
     */
    private Grupo seleccionarGrupo(Asignatura asignatura) {
        if (asignatura.getNumeroGrupos() == 0) {
            System.out.println("Error: La asignatura no tiene grupos registrados.");
            return null;
        }

        asignatura.listarGrupos();

        System.out.print("\nIngrese el nombre del grupo: ");
        String nombreGrupo = scanner.nextLine();

        Grupo grupo = asignatura.buscarGrupo(nombreGrupo);
        if (grupo == null) {
            System.out.println("Error: No se encontro el grupo con ese nombre.");
        }

        return grupo;
    }

    /**
     * Metodo para mostrar el menu principal
     */
    private void mostrarMenu() {
        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║  SISTEMA DE GESTION DE ESTUDIANTES            ║");
        System.out.println("╠════════════════════════════════════════════════╩");
        System.out.println("1. Crear nueva asignatura");
        System.out.println("2. Crear nuevo grupo");
        System.out.println("3. Agregar estudiante a un grupo");
        System.out.println("4. Registrar calificacion");
        System.out.println("5. Mostrar listado de calificaciones");
        System.out.println("6. Calcular porcentaje de aprobados");
        System.out.println("0. Salir");
        System.out.print("\nSeleccione una opcion: ");
    }

    /**
     * Metodo para calcular y mostrar el porcentaje de aprobados
     */
    private void calcularPorcentajeAprobados() {
        System.out.println("\n=== PORCENTAJE DE APROBADOS ===");

        // Seleccionar asignatura
        Asignatura asignatura = seleccionarAsignatura();
        if (asignatura == null)
            return;

        // Seleccionar grupo
        Grupo grupo = seleccionarGrupo(asignatura);
        if (grupo == null)
            return;

        // Calcular y mostrar el porcentaje
        double porcentaje = grupo.calcularPorcentajeAprobados();
        System.out.println("\n========================================");
        System.out.println("Grupo: " + grupo.getNombreGrupo());
        System.out.println("Total de estudiantes: " + grupo.getNumeroEstudiantes());
        System.out.println("Porcentaje de aprobados: " + String.format("%.2f", porcentaje) + "%");
        System.out.println("========================================");
    }

    /**
     * Metodo principal que ejecuta el sistema
     */
    public void ejecutar() {
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    crearAsignatura();
                    break;
                case "2":
                    crearGrupo();
                    break;
                case "3":
                    agregarEstudiante();
                    break;
                case "4":
                    registrarCalificacion();
                    break;
                case "5":
                    mostrarListadoCalificaciones();
                    break;
                case "6":
                    calcularPorcentajeAprobados();
                    break;
                case "0":
                    System.out.println("\nGracias por usar el sistema. ¡Hasta luego!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor intente de nuevo.");
            }
        }

        scanner.close();
    }
}
