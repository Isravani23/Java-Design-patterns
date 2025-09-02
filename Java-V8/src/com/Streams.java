package com;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    /*Streams can be defined as a sequences of elements from a source
     which support data processing operations. You can treat streams as operations on data.
     java.util.stream.Stream interface is the center of Java 8 Streams API*/

    // Selection Operations
    public static void selectOperation(){
        List<String> names = Arrays.asList("David","Jhon","Ntika","Brijesh","Sam","Ntika");
        List<String> filter = names.stream().filter((String t)->t.length()>5).toList();
        System.out.println("condition base"+filter);
        List<String> distinct = names.stream().distinct().toList();
        System.out.println("Unique names" +distinct);
        List<String> limit = names.stream().limit(3).toList();
        System.out.println("select first names"+limit);
        List<String> skip = names.stream().skip(2).toList();
        System.out.println("Skip the name "+skip);
        List<Integer> map = names.stream().map(String::length).toList();
        System.out.println("length of each name"+map);

        //Sorting Operations
        List<String> naturalSort = names.stream().sorted().toList();
        System.out.println("Natural Sorting Order"+naturalSort);
    }
}
