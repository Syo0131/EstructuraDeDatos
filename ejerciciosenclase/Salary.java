import java.util.Scanner;

public class Salary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] empleados = new String[4];
        double[][] sueldos = new double[4][3];
        double[] sueldosTotales = new double[4];

        for (int i = 0; i < empleados.length; i++) {
            System.out.println("Ingrese el nombre del empleado " + (i + 1) + ":");
            empleados[i] = sc.nextLine();
        }

        for (int i = 0; i < empleados.length; i++) {
            for (int j = 0; j < sueldos[i].length; j++) {
                System.out.println("Ingrese el sueldo " + (j + 1) + " del empleado " + empleados[i] + ":");
                sueldos[i][j] = sc.nextDouble();
            }
        }

        for (int i = 0; i < empleados.length; i++) {
            for (int j = 0; j < sueldos[i].length; j++) {
                sueldosTotales[i] += sueldos[i][j];
            }
        }

        for (int i = 0; i < empleados.length; i++) {
            System.out.println("El sueldo total del empleado " + empleados[i] + " es: " + sueldosTotales[i]);
        }

        sc.close();
    }
}