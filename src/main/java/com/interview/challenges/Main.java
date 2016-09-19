package com.interview.challenges;

import com.interview.challenges.basic.Basic;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        evaluateBasics(basic);
    }

    public static void evaluateBasics(Basic basic) {
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
}
