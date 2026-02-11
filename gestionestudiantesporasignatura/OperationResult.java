package gestionestudiantesporasignatura;

/**
 * Clase que representa el resultado de una operacion en el sistema
 * Ayuda a manejar respuestas de forma estandarizada
 */
public class OperationResult {
    private String message; // Mensaje descriptivo del resultado
    private boolean success; // Indica si la operacion fue exitosa
    private Object data; // Datos que se quieren devolver (puede ser cualquier tipo)

    // Constructor vacio
    public OperationResult() {
    }

    // Constructor con todos los parametros
    public OperationResult(String message, boolean success, Object data) {
        this.message = message;
        this.success = success;
        this.data = data;
    }

    // Constructor sin datos
    public OperationResult(String message, boolean success) {
        this.message = message;
        this.success = success;
        this.data = null;
    }

    // Metodos getter y setter
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Resultado: " + (success ? "Exito" : "Error") +
                " - " + message +
                (data != null ? " [Datos: " + data + "]" : "");
    }
}
