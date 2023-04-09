package parser;

import logic.gates;

import java.util.ArrayList;
import java.util.List;

public class list {

    public static List<String> ReverseString(List<String> Tlist){

        List<String> Zlist = new ArrayList<String>();

        for (int i = Tlist.size(); i > -1; i++){

            Zlist.add(Tlist.get(i));

        }

        return Zlist;

    }

    public static List<Integer> ReverseInteger(List<Integer> Tlist){

        List<Integer> Zlist = new ArrayList<Integer>();

        for (int i = Tlist.size()-1; i > -1; i--){

            Zlist.add(Tlist.get(i));

        }

        return Zlist;

    }

    public static List<Integer> InvertInteger(List<Integer> Tlist){

        List<Integer> Zlist = new ArrayList<Integer>();

        for (int i = 0; i < Tlist.size(); i++){

            Zlist.add(gates.not(Tlist.get(i)));

        }

        return Zlist;

    }

}
