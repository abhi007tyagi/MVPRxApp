package com.tyagiabhinav.mvprxapp.util;

import org.json.JSONException;

import java.util.List;

/**
 * Created by abhinavtyagi on 13/02/17.
 */

public class ParsingHelper {

    private ParsingHelper(){}

    /**
     *  Get address from json string array
     *
     * @param add
     * @return
     * @throws JSONException
     */
    public static String getAddress(List<String> add) {
        StringBuilder address = new StringBuilder();
        for (int i = 0; i < add.size(); i++) {
            address.append(add.get(i)).append(", ");
        }
        address.deleteCharAt(address.length() - 1);
        return address.toString();
    }
}
