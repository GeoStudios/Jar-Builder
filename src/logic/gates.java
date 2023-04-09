/*
 * Copyright (c) 2023 Geo-Studios Inc. All rights reserved.
 */

package logic;

public class gates {

    public static int not(int a){
        if (a == 1) return 0; else return 1;
    }

    public static int buffer(int a){
        return not(not(a));
    }

    public static int and(int a, int b){
        if (a == 1 && b == 1) return 1; else return 0;
    }

    public static int nand(int a, int b){
        return not(and(a, b));
    }

    public static int or(int a, int b){
        return nand(not(a), not(b));
    }

    public static int nor(int a, int b){
        return not(or(a, b));
    }

    public static int xor(int a, int b){
        return or(and(a, not(b)), and(not(a), b));
    }

    public static int xnor(int a, int b){
        return not(xor(a, b));
    }


}
