/*
 * Copyright (c) 2023 Geo-Studios Inc. All rights reserved.
 */

package parser;

import java.util.ArrayList;
import java.util.List;

import logic.converter;

public class binary {

    public static List<List<Integer>> Split(int packageSize, String Binary){

        List<Integer> binL = converter.StringListToIntArray(Binary.split(""));
        List<List<Integer>> pack = new ArrayList<List<Integer>>();
        int lt = 0;
        for (int i = 0; i < binL.size()/packageSize; i++){

            List<Integer> nibble = new ArrayList<Integer>();

            for (int j = 0; j < packageSize; j++){

                nibble.add(binL.get(lt));

                lt++;

            }

            pack.add(nibble);

        }

        return pack;

    }

}
