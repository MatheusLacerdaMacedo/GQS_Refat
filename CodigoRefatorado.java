package main;
import java.util.Scanner;

public class EquacaoSegundoGrau {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continuar;

        do {
            System.out.println("Informe os coeficientes da equação:");
            double a = lerCoeficiente("a", scanner);
            double b = lerCoeficiente("b", scanner);
            double c = lerCoeficiente("c", scanner);

            resolverEquacao(a, b, c);

            System.out.print("Deseja resolver outra equação? (s/n): ");
            continuar = scanner.next().charAt(0);

        } while (continuar == 's' || continuar == 'S');

        scanner.close();
    }

    public static double lerCoeficiente(String coeficiente, Scanner scanner) {
        System.out.printf("Informe o coeficiente %s: ", coeficiente);
        return scanner.nextDouble();
    }

    public static void resolverEquacao(double a, double b, double c) {
        if (a == 0) {
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Igualdade confirmada: 0 = 0");
                } else {
                    System.out.println("Coeficientes informados incorretamente");
                }
            } else {
                double x = -c / b;
                System.out.printf("Esta é uma equação de primeiro grau: x = %.2f%n", x);
            }
        } else {
            double delta = calcularDelta(a, b, c);

            if (delta < 0) {
                System.out.printf("Esta equação não possui raízes reais (delta < 0): delta = %.2f%n", delta);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.printf("Esta equação possui duas raízes reais iguais: x' = x'' = %.2f%n", x);
            } else {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.printf("Esta é uma equação de segundo grau. Esta equação possui duas raízes reais diferentes: delta = %.2f, x' = %.2f, x'' = %.2f%n", delta, x1, x2);
            }
        }
    }

    public static double calcularDelta(double a, double b, double c) {
        return b * b - 4 * a * c;
    }
}
