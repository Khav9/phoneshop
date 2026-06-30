package com.piseth.java.school.phoneshop_night.utils;

import java.util.List;

public class GeneralUtils {

    // convert list of string to list of integer
    // ["Dara", "Thida", "Seyha"]
    // => [4, 5, 5]

    public static List<Integer> toIntegerList(List<String> list){

        return list.stream()
                .map(s -> s.length())
                .toList();
    }

    public static List<Integer> getEvenNumbers(List<Integer> list){
        return list.stream().filter( x -> x%2 == 0).toList();
    }
}
