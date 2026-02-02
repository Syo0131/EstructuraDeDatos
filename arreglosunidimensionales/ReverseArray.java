package arreglosunidimensionales;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese 6 numeros: ");

        List<Integer> reverse = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            int num = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Numero " + (i + 1) + ": ");
                    num = sc.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada invalida. Por favor, ingrese solo numeros enteros.");
                    sc.next();
                }

            }

            reverse.add(num);
        }
        System.out.print("Lista inversa: [");
        for (int i = reverse.size() - 1; i >= 0; i--) {
            System.out.print(reverse.get(i));
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        sc.close();
    }
}
