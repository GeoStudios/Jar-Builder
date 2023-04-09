/*
 * Copyright (c) 2023 Geo-Studios Inc. All rights reserved.
 */

package logic;

import java.util.ArrayList;
// import java.util.Arrays;
import java.util.List;

import logic.circuits.binary.adder;
import parser.binary;
import parser.hex;
import parser.list;

public class converter {
    public static List<String> StringListToStrArray(String[] list){
        List<String> array = new ArrayList<String>();
        for (int i = 0; i < list.length; i++)
            array.add(list[i]);
        return array;
    }

    public static List<Integer> StringListToIntArray(String[] list){
        List<Integer> array = new ArrayList<Integer>();
        for (int i = 0; i < list.length; i++)
            array.add(Integer.parseInt(list[i]));
        return array;
    }

    public static String StrArrayToString(List<String> array){

        String string = String.format("%s", array).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");

        return string;

    }

    public static String IntArrayToString(List<Integer> array){

        String string = String.format("%s", array).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");

        return string;

    }

    public static String BinaryToHexadecimal(String bin){

        List<List<Integer>> binL = binary.Split(4, bin);
        List<String> hexL = new ArrayList<String>();

        for (int i = 0; i < binL.size(); i++){

            String nibbleString = IntArrayToString(binL.get(i));

            if ( nibbleString.contains("0000")) hexL.add("0");
            if ( nibbleString.contains("0001")) hexL.add("1");
            if ( nibbleString.contains("0010")) hexL.add("2");
            if ( nibbleString.contains("0011")) hexL.add("3");
            if ( nibbleString.contains("0100")) hexL.add("4");
            if ( nibbleString.contains("0101")) hexL.add("5");
            if ( nibbleString.contains("0110")) hexL.add("6");
            if ( nibbleString.contains("0111")) hexL.add("7");
            if ( nibbleString.contains("1000")) hexL.add("8");
            if ( nibbleString.contains("1001")) hexL.add("9");
            if ( nibbleString.contains("1010")) hexL.add("a");
            if ( nibbleString.contains("1011")) hexL.add("b");
            if ( nibbleString.contains("1100")) hexL.add("c");
            if ( nibbleString.contains("1101")) hexL.add("d");
            if ( nibbleString.contains("1110")) hexL.add("e");
            if ( nibbleString.contains("1111")) hexL.add("f");



        }

        return StrArrayToString(hexL);
    }

    public static String HexadecimalToBinary(String hexa){

        List<List<String>> hexL = hex.Split(1, hexa);
        List<String> binL = new ArrayList<String>();

        for (int i = 0; i < hexL.size(); i++){

            String bitString = StrArrayToString(hexL.get(i));

            if ( bitString.contains("0")) binL.add("0000");
            if ( bitString.contains("1")) binL.add("0001");
            if ( bitString.contains("2")) binL.add("0010");
            if ( bitString.contains("3")) binL.add("0011");
            if ( bitString.contains("4")) binL.add("0100");
            if ( bitString.contains("5")) binL.add("0101");
            if ( bitString.contains("6")) binL.add("0110");
            if ( bitString.contains("7")) binL.add("0111");
            if ( bitString.contains("8")) binL.add("1000");
            if ( bitString.contains("9")) binL.add("1001");
            if ( bitString.contains("a")) binL.add("1010");
            if ( bitString.contains("b")) binL.add("1011");
            if ( bitString.contains("c")) binL.add("1100");
            if ( bitString.contains("d")) binL.add("1101");
            if ( bitString.contains("e")) binL.add("1110");
            if ( bitString.contains("f")) binL.add("1111");




        }

        return StrArrayToString(binL);
    }

    public static String Negatate(String A){

        String binAI = adder.add(
                IntArrayToString(
                        list.ReverseInteger(
                                list.InvertInteger(
                                    StringListToIntArray(
                                        A.split("")
                                    )
                                )
                        )
                )
                ,
                "00000000000000000000000000000001"
                ,
                0
        );

        return binAI;

    }

}
