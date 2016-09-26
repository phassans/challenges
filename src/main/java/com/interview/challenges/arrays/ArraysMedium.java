package com.interview.challenges.arrays;

import java.util.ArrayList;

public class ArraysMedium {

    int[] arr = { 3, 5, 2, 6, 8, 12 };
    int[] arr1 = { 1, 2, 3 };

    public void evaluate() {
        isSumPossible(arr, 15);
        System.out.println("\nPermuations are - ");
        findPermutations(arr1);
        
        System.out.println("\nCombinations are - ");
        findCombinations(arr1);
    }

    public boolean isSumPossible(int[] arr, int sum) {
        int size = arr.length;
        boolean[] bitArr = new boolean[size];
        int iSum = 0;
        boolean isSumPossible = false;
        while (incrementArrBitByOne(bitArr)) {
            iSum = 0;
            for (int i = 0; i < bitArr.length; i++) {
                if (bitArr[i])
                    iSum += arr[i];
            }

            if (sum == iSum) {
                System.out.print("Sum Possible - ");
                for (int i = 0; i < bitArr.length; i++) {
                    if (bitArr[i])
                        System.out.print(arr[i] + ", ");
                }
                isSumPossible = true;
                System.out.println("");
            }
        }
        return isSumPossible;
    }

    private boolean incrementArrBitByOne(boolean[] bitArr) {
        boolean carry = false;
        // Or go reverse order
        for (int i = 0; i < bitArr.length; i++) {
            carry = bitArr[i];
            bitArr[i] = !bitArr[i];
            if (carry == false)
                break;
        }
        // System.out.println(Arrays.toString(bitArr));
        return !carry;
    }

    public void findPermutations(int[] arr) {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        boolean[] used = new boolean[arr.length];
        doPermute(arr, newArr, used, 0);
    }

    private void doPermute(int[] arr2, ArrayList<Integer> list, boolean[] used, int level) {
        if (level == arr2.length) {
            for (Integer a : list) {
                System.out.print(a + ", ");
            }
            System.out.println();
        }
        for (int i = 0; i < arr2.length; i++) {
            if (used[i])
                continue;
            list.add(arr2[i]);
            used[i] = true;
            doPermute(arr2, list, used, level + 1);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
    
    public void findCombinations(int[] arr) {
        ArrayList<Integer> newArr = new ArrayList<Integer>();
        boolean[] used = new boolean[arr.length];
        doCombine(arr, newArr, used, 0);
    }
    
    private void doCombine(int[] arr2, ArrayList<Integer> list, boolean[] used, int level) {
        if (level <= arr2.length) {
            for (Integer a : list) {
                System.out.print(a + ", ");
            }
            System.out.println();
        }
        for (int i = 0; i < arr2.length; i++) {
            if (used[i])
                continue;
            list.add(arr2[i]);
            used[i] = true;
            doCombine(arr2, list, used, level + 1);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
