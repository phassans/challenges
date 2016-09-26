package com.interview.challenges.maps;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        //myDSDriver();
        mySizeMap();
    }

    private static void mySizeMap() {
        SizeMap smap = new SizeMap();
        for (int i = 0; i < 10; i++) {
            smap.add(i);
        }
        System.out.println(Arrays.toString(smap.arr));
        smap.add(23);
        System.out.println(Arrays.toString(smap.arr));
        
        System.out.println("Search "+smap.search(7));
        
        smap.remove(4);
        System.out.println(Arrays.toString(smap.arr));
    }

    public static void myDSDriver() {

        MyDS ds = new MyDS();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.search(50));
        System.out.println(ds.getRandom());

        MyDS ds1 = new MyDS();
        for (int i = 0; i < 10; i++) {
            ds1.add(i);
        }
        System.out.println(Arrays.toString(ds1.arr.toArray()));
        ds1.add(23);
        System.out.println(Arrays.toString(ds1.arr.toArray()));
    }
}
