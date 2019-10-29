package com.tengming.cart.data;

public class Buer {
    static int i = 3;
    public static boolean demo() {
        for (int k=0;k<40;k++){
            i--;
            System.out.println(i);
            if (i == -10) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Buer.demo();
    }
}
