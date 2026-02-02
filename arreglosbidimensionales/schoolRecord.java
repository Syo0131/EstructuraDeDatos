package arreglosbidimensionales;

import java.util.Scanner;

public class schoolRecord {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Ingrese el número de estudiantes (filas): ");
        int rows = scan.nextInt();

        System.out.print("Ingrese el número de asignaturas (columnas): ");
        int column = scan.nextInt();

        int[][] records = new int[rows][column];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                int note = -1;
                boolean validInput = false;

                while (!validInput) {
                    System.out.println("Nota para estudiante " + (i + 1) + " En Materia " + (j + 1) + ": ");

                    if (scan.hasNextInt()) {
                        note = scan.nextInt();

                        if (note >= 0 && note <= 100) {
                            validInput = true;
                        } else {
                            System.out.println("Error: La nota debe estar entre 0 y 100. Intente nuevamente.");
                        }
                    } else {
                        System.out.println("Error: Debe ingresar un número válido. Intente nuevamente.");
                        scan.next();
                    }
                }

                records[i][j] = note;
            }
        }

        System.out.println("\n=== MATRIZ DE CALIFICACIONES ===");
        System.out.print("Estudiante\t");
        for (int j = 0; j < column; j++) {
            System.out.print("Materia " + (j + 1) + "\t");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print("   " + (i + 1) + "\t\t");
            for (int j = 0; j < column; j++) {
                System.out.print(records[i][j] + "\t\t");
            }
            System.out.println();
        }

        int max = records[0][0];
        int min = records[0][0];
        int filaMax = 0;
        int colMax = 0;
        int filaMin = 0;
        int colMin = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (records[i][j] > max) {
                    max = records[i][j];
                    filaMax = i;
                    colMax = j;
                }
                if (records[i][j] < min) {
                    min = records[i][j];
                    filaMin = i;
                    colMin = j;
                }
            }
        }

        System.out.println("\n=== VALORES MAXIMO Y MINIMO ===");
        System.out.println("Valor Maximo: " + max);
        System.out.println("Ubicacion: Estudiante " + (filaMax + 1) + ", Materia " + (colMax + 1));
        System.out.println("\nValor Minimo: " + min);
        System.out.println("Ubicación: Estudiante " + (filaMin + 1) + ", Materia " + (colMin + 1));

        System.out.println("\n=== Promedio POR ESTUDIANTE ===");
        for (int i = 0; i < rows; i++) {
            double sum = 0;
            for (int j = 0; j < column; j++) {
                sum += records[i][j];
            }
            double average = sum / column;
            System.out.printf("Estudiante %d: %.2f\n", (i + 1), average);
        }

        System.out.println("\n=== Promedio POR ASIGNATURA ===");
        for (int j = 0; j < column; j++) {
            double sum = 0;
            for (int i = 0; i < rows; i++) {
                sum += records[i][j];
            }
            double average = sum / rows;
            System.out.printf("Materia %d: %.2f\n", (j + 1), average);
        }

        scan.close();
    }
}