package testTasks;

import java.math.BigInteger;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the value of N
        System.out.print("Введіть число N: ");
        int n = scanner.nextInt();

        // Check n of positive value
        while (n < 0) {
            System.out.println("N повинно бути додатним!");
            System.out.print("Введіть число N: ");
            n = scanner.nextInt();
        }

        // Calculate the Catalan number
        BigInteger result = catalanNumber(n);
        System.out.println(String.format("Число правильних дужкових виразів для N = %d: %d", n, result));
    }

    /**
     * Method to calculate the Catalan number
     * @param n number
     * @return Catalan number
     */
    public static BigInteger catalanNumber(int n) {
        // Cn = (2n)! / ((n+1)! * n!)
        BigInteger numerator = factorial(2 * n); // Calculate (2n)!
        BigInteger denominator = factorial(n + 1).multiply(factorial(n)); // Calculate (n+1)! * n!
        return numerator.divide(denominator); // Divide numerator by denominator
    }

    /**
     * Method to calculate the factorial of a number
     * @param num
     * @return factorial of a number
     */
    public static BigInteger factorial(int num) {
        BigInteger result = BigInteger.valueOf(1);  // Initialize result as 1
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));    // Multiply by each number up to num
        }
        return result;
    }

}
