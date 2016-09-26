package com.interview.challenges;

import com.interview.challenges.arrays.ArraysEasy;
import com.interview.challenges.arrays.ArraysMedium;
import com.interview.challenges.basic.Basic;
import com.interview.challenges.strings.Strings;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        //basic.evaluate(basic);

        ArraysEasy arrayEasy = new ArraysEasy();
        //arrayEasy.evaluate(arrayEasy);
        
        ArraysMedium arraysMedium = new ArraysMedium();
        //arraysMedium.evaluate();
        
        
        Strings strObj = new Strings();
        strObj.evaluate();
    }
}
