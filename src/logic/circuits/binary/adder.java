/*
 * Copyright (c) 2023 Geo-Studios Inc. All rights reserved.
 */

package logic.circuits.binary;

import logic.Config;
import logic.gates;
import logic.converter;
import parser.list;

import java.util.ArrayList;
import java.util.List;

public class adder {

    public static String add(String BinaryA, String BinaryB, int carryIn) {

        List<Integer> bina = list.ReverseInteger(converter.StringListToIntArray(BinaryA.split("")));
        List<Integer> binb = list.ReverseInteger(converter.StringListToIntArray(BinaryB.split("")));

        List<Integer> sumr = new ArrayList<Integer>();

        int carry = carryIn;
        for (int i = 0; i < Config.BitLimit; i++){

            int sump1 = gates.xor(bina.get(i), binb.get(i));
            int sum = gates.xor(sump1, carry);
            carry = gates.or(gates.and(bina.get(i), binb.get(i)), gates.and(sump1, carry));
            sumr.add(sum);

        }

        return converter.IntArrayToString(list.ReverseInteger(sumr));


    }

}
