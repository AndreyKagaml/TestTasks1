package testTasks;

import java.math.BigInteger;
import java.util.Arrays;

public class Task3 {
    public static void main(String[] args) {
        // Calculate the factorial of 100 and the result to a string for the sum its digits
        // and calculate this sum using Stream API
        int digitSum = Arrays.stream(factorial(100).toString().split(""))
                .mapToInt(Integer::parseInt)
                .sum();

        // Output the result
        System.out.println("Сума цифр 100!: " + digitSum);
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
