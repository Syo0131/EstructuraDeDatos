package arreglosunidimensionales;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DailySales {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        List<Integer> sales = new ArrayList<>();

        System.out.println("Ingrese sus ventas de los ultimos 7 dias");

        double sum = 0;
        int maxSalesDay = 0;
        int maxSalesDayIndex = 0;

        for (int i = 0; i < 7; i++) {
            int num = 0;

            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.print("Dia " + (i + 1) + ": ");
                    num = scan.nextInt();
                    validInput = true;
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                    scan.next();
                }
            }

            sales.add(num);
            sum += num;

            if (num > maxSalesDay) {
                maxSalesDay = num;
                maxSalesDayIndex = i;
            }
        }

        double avgSales = sum / sales.size();

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Total de ventas: " + sum);
        System.out.println("Promedio de ventas diario: " + df.format(avgSales));
        System.out.println("Dia con mas ventas: Dia " + (maxSalesDayIndex + 1) + " con " + maxSalesDay);

        scan.close();

    }
}