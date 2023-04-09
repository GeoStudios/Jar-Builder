package logic.circuits.binary;

import logic.Config;
import logic.converter;
import logic.gates;
import parser.list;

import java.util.ArrayList;
import java.util.List;

public class subtractor {

    public static String subtractFromA(String BinaryA, String BinaryB, int carryIn) {

        List<Integer> bina = list.ReverseInteger(converter.StringListToIntArray(BinaryA.split("")));
        List<Integer> binb = list.InvertInteger(list.ReverseInteger(converter.StringListToIntArray(BinaryB.split(""))));

        List<Integer> sumr = new ArrayList<Integer>();

        int carry = carryIn;
        for (int i = 0; i < Config.BitLimit; i++){

            int sump1 = gates.xor(bina.get(i), binb.get(i));
            int sum = gates.xor(sump1, carry);
            carry = gates.or(gates.and(bina.get(i), binb.get(i)), gates.and(sump1, carry));
            sumr.add(sum);

        }

        return adder.add(converter.IntArrayToString(list.ReverseInteger(sumr)), "00000000000000000000000000000001", 0);


    }

    public static String subtractFromB(String BinaryA, String BinaryB, int carryIn) {

        List<Integer> bina = list.ReverseInteger(converter.StringListToIntArray(converter.Negatate(BinaryA).split("")));
        List<Integer> binb = list.ReverseInteger(converter.StringListToIntArray(BinaryB.split("")));

        List<Integer> sumr = new ArrayList<Integer>();

        int carry = carryIn;
        for (int i = 0; i < Config.BitLimit; i++){

            int sump1 = gates.xor(bina.get(i), binb.get(i));
            int sum = gates.xor(sump1, carry);
            carry = gates.or(gates.and(bina.get(i), binb.get(i)), gates.and(sump1, carry));
            sumr.add(sum);

        }

        return adder.add(converter.IntArrayToString(list.ReverseInteger(sumr)), "00000000000000000000000000000001", 0);


    }

}
