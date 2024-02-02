package testCases;

import java.util.HashMap;
import java.util.Map;

public class fafa {
    public static void main(String[] args) {
        int[] l1 = {1,2,3};
        int[] l2 = {3,5,6};
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for(int i:l1){
            num1.append(i);
        }
        for(int i:l2){
            num2.append(i);
        }
        num1.reverse();
        num2.reverse();
        int res = Integer.valueOf(String.valueOf(num1)) + Integer.valueOf(String.valueOf(num2));

    }
}

