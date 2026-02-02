package arreglosunidimensionales;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Temperatura {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Create a list to store the numbers
        List<Integer> temps = new ArrayList<>();

        // Ask the user for 10 numbers
        System.out.println("Por favor, ingrese la temperatura en celsius de 10 dias de una ciudad");

        int count = 0;
        double sum = 0;
        int lowtemp = 0;
        int maxtemp = 0;

        for (int i = 0; i < 10; i++) {
            int num = 0;
            boolean validInput = false;

            // Validate user input
            while (!validInput) {
                try {
                    System.out.print("Temperatura " + (i + 1) + ": ");
                    num = scan.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                    scan.next();
                }
            }
            temps.add(num);
            sum += num;

            if (i == 0) {
                maxtemp = num;
                lowtemp = num;
            } else {
                if (num > maxtemp) {
                    maxtemp = num;
                }
                if (num < lowtemp) {
                    lowtemp = num;
                }
            }

            if (num >= 30) {
                count++;
            }
        }

        double avgTemps = sum / temps.size();

        // Print the results
        System.out.println("Días con temperatura mayor o igual a 30 grados: " + count);
        System.out.println("Temperatura máxima: " + maxtemp);
        System.out.println("Temperatura mínima: " + lowtemp);
        System.out.println("Promedio de temperatura: " + avgTemps);

        scan.close();
    }
}
