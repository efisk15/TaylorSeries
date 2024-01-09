// Lab: Taylor Series.
// In this file is a program that will approximate the value of e raised to the power of any exponent
// using the Taylor Series. A user can input any exponent they want e raised to and the user can also
// designate how exact they want the estimation to be by entering how many taylor "steps" they want included
// in the approximation.
// Eli Fisk.
// Zach Estsus, Ben Fisk.

import java.util.Scanner;

public class taylorSeries {
    // Get user values for exponent "x" and step value "n", then error check user input.
    // Output Taylor Value, real value, and the error between the 2 values.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 0;
        double x =0;
        boolean bool = true;

        do {
            System.out.print("Enter x: ");
            if(sc.hasNextDouble()) {
                x = sc.nextDouble();
                bool = false;
            }
            else {
            sc.next();
            }
        } while (bool);

        do {
            System.out.print("Enter number of iterations: ");
            if(sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) {
                    if (n < 10000) {
                        bool = true;
                    }
                }
            }
            else {
            sc.next();
            }
        } while (!bool);
        sc.close();

        double answer = taylor(x, n);
        double actual = Math.exp(x);
        double error = Math.abs(answer / actual * 100 - 100);

        System.out.printf("TAYLOR: %.3f, EXP: %.3f, ERROR: %.0f%%%n",answer, actual, error);
    }

    // Return the taylor value when given the expent value and the number of taylor steps.
    static double taylor(double x, int n) {
        int z;
        double total = 1.0;
        for (z = 1; z <= n; ++z) {
            total += taylor_step(z, x);
        }
        return total;
    }

    // Return 1 taylor step when given the exponential number and the taylor step the program
    // is on, which is designated by z.
    public static double taylor_step(double z, double x) {
        double val = x;
        val = Math.pow(val, z);
        for(double i = 1 ; i <= z ; ++i ) {
            val /= i;
        };
        return val;
    } 
}

