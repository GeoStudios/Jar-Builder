/*
 * Copyright (c) 2023 Geo-Studios Inc. All rights reserved.
 */

package parser;

import java.util.ArrayList;
import java.util.List;

import logic.converter;

public class hex {

    public static List<List<String>> Split(int packageSize, String Binary){

        List<String> binL = converter.StringListToStrArray(Binary.split(""));
        List<List<String>> pack = new ArrayList<List<String>>();
        int lt = 0;
        for (int i = 0; i < binL.size()/packageSize; i++){

            List<String> nibble = new ArrayList<String>();

            for (int j = 0; j < packageSize; j++){

                nibble.add(binL.get(lt));

                lt++;

            }

            pack.add(nibble);

        }

        return pack;

    }

}
