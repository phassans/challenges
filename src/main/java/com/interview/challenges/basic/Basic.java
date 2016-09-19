package com.interview.challenges.basic;

public class Basic {

    public void evaluate(Basic basic) {
        System.out.println("isPrime " + basic.isPrime(1));

        System.out.println("Factorial Sequential " + basic.fact(5));

        System.out.println("Factorial Recursive " + basic.factRecursive(5));

        System.out.print("Fibonacci ");
        basic.fibonacci(8);

        System.out.print("\nFibonacci Recursive ");
        for (int i = 1; i <= 8; i++) {
            System.out.print(basic.fibonacciRecursive(i) + ", ");
        }

        basic.generatePrimesBetween(100);

        basic.generateNPrimes(100);
    }

    public boolean isPrime(int num) {
        if (num == 1)
            return false;
        for (int i = 2; i < num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public int fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public int factRecursive(int n) {
        if (n == 1)
            return 1;
        return n * factRecursive(n - 1);
    }

    public void fibonacci(int n) {
        if (n == 0)
            System.out.print("0");
        if (n == 1)
            System.out.print("1");
        System.out.print("0, 1, ");
        int i = 3;
        int a = 0;
        int b = 1;
        while (i <= n) {
            int sum = a + b;
            System.out.print(sum + ", ");
            a = b;
            b = sum;
            i++;
        }
    }

    public int fibonacciRecursive(int n) {
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;

        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public void generatePrimesBetween(int n) {
        if (n == 0 || n == 1)
            return;
        System.out.print("\nPrime numbers from 1 to " + n + " - ");
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime)
                System.out.print(i + ", ");
        }
    }

    public void generateNPrimes(int n) {
        System.out.print("\nPrime numbers are ");
        int count = 0;
        for (int i = 2; i <= Integer.MAX_VALUE; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0)
                    isPrime = false;
            }
            if (isPrime) {
                System.out.print(i + ", ");
                count++;
            }
            if (count == n)
                break;
        }
    }
}
