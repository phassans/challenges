package com.interview.challenges.maps;

import java.util.HashMap;

public class SizeMap {
    int[] arr;
    HashMap<Integer, Integer> map;
    int size;
    
    SizeMap() {
        arr = new int[10];
        map = new HashMap<Integer, Integer>();
        size = 0;
    }
    
    void add (int x) {
        if (map.get(x) != null) {
            return;
        }
        if (size == 10) {
            arr[0] = x;
            map.put(x, 0);
        } else {
            arr[size] = x;
            map.put(x, size);
            size++;
        }
    }
    
    int search(int x) {
        return map.get(x);
    }
    
    void remove(int x) {
        if (map.get(x) == null) {
            return;
        }
        int index = map.get(x);
        map.remove(x);
        for (int i = index; i < size-1; i++) {
            arr[i] = arr[i+1];
            map.put(arr[i+1], i);
        }
        arr[size-1] = 0;
        size --;
    }
}
