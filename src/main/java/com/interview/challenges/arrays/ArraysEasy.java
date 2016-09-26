package com.interview.challenges.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArraysEasy {

    int[] arr = { 13, 18, 13, 14, 13, 16, 14, 21, 13 };
    int[] arr1 = { 13, 18, 13, 14, 13, 16, 13, 21, 13 };
    int[] arr2 = { 1, 2, 3, 4, 5, 6, 6, 7, 8, 9 };
    int[] arr3 = {1, 0, 1, 0, 0};
    int[] arr4 = {5, 0, 8, 0, 0};
    int[] arr5 = {-1, 2, 1, 12, -9, 3, -4, 4, -3, 21, 52, 4, -2, 0, 0, 0};

    public void evaluate(ArraysEasy arrayEasy) {
        System.out.println("Mean " + arrayEasy.findMean(arr));
        System.out.println("Median " + arrayEasy.findMedian(arr));
        System.out.println("Mode " + arrayEasy.findMode(arr));
        System.out.println("Range " + arrayEasy.findRange(arr));
        System.out.println("Nby2Repeated element " + arrayEasy.nby2Repeated(arr1));
        System.out.println("Duplicate Element between 1 and N - "+findDuplicateBetween1toN(arr2, 9));
        sortZeroOne_2(arr3);
        System.out.println("Sort zeros and ones "+Arrays.toString(arr3));
        sortZeroOne_2(arr4);
        System.out.println("Zeros at beginning rest all at end. Order is important "+Arrays.toString(arr4));
        sortWholeNumbers_1(arr5);
        System.out.println("Sort whole numbers - "+Arrays.toString(arr5));
    }

    public int findMean(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public int findMedian(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }

    public int findMode(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        int max = 1;
        int maxKey = 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (value > max) {
                max = value;
                maxKey = key;
            }
        }
        return maxKey;
    }

    public int findRange(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 1] - arr[0];
    }

    public int nby2Repeated(int[] arr) {
        int confidence = 0;
        int candidate = 0;
        for (int i = 0; i < arr.length; i++) {
            if (confidence == 0) {
                candidate = arr[i];
            }
            if (candidate == arr[i]) {
                confidence++;
            } else {
                confidence--;
            }
        }
        return candidate;
    }

    public int findDuplicateBetween1toN(int[] arr, int n) {
        int sum = 0;
        int actualSum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }
        
        sum = ( n * (n+1)) / 2;

        for (int i = 0; i < arr.length; i++) {
            actualSum += arr[i];
        }
        return actualSum-sum;
    }
    
    public void sortZeroOne_1(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == 1) {
                for (int j=i+1;j<arr.length;j++) {
                    if (arr[j] == 0) {
                        arr[i] = 0;
                        arr[j] = 1;
                        break;
                    }
                }
            }
        }
    }
    
    public void sortZeroOne_2(int[] arr) {
        int cur = arr.length - 1;
        for (int i = arr.length-1; i>=0; i--) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[cur];
                arr[cur] = temp;
                cur--;
            }
        }
    }
    
    public void sortWholeNumbers(int[] arr) {
        int j = -1;
        int k = arr.length;
        for (int i = 0; i < arr.length && i<k; i++) {
            if (arr[i] < 0) {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else if (arr[i] > 0) {
                k--;
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                i--;
            }
        }
    }
    
    public void sortWholeNumbers_1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            System.out.println(Arrays.toString(arr));
            while (left < right && arr[left] < 0) {
                left++;
            }

            while (left <= right && arr[right] > 0) {
                right--;
            }
            
            if (left<=right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
}
