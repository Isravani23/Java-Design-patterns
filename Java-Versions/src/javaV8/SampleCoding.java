package javaV8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public  class SampleCoding {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(10,20,30,47,82,90,10);
        int max = list.stream().max(Comparator.naturalOrder()).get();
        int min = list.stream().min(Comparator.naturalOrder()).get();
        System.out.println("Max"+max+"----"+"Min"+min);
        List<Integer> odd = list.stream().filter(i->i%2==0).toList();
        List<Integer> even = list.stream().filter(i->i%2!=0).toList();
        System.out.println("Odd"+odd+" "+"Even"+even);
        List<Integer> list1 = list.stream().distinct().toList();
        System.out.println(list1);
        List<Integer> reverse = list.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).toList();
        System.out.println(reverse);
        String inputString = "Java Concept Of The Day";
        Map<Character,Long> map = inputString.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);
        Integer num =145328;
        int i = Arrays.stream(String.valueOf(num).split(" ")).mapToInt(Integer::parseInt).sum();
        System.out.println("Sum=="+i);
        List<String> listOfStrings = Arrays.asList("Java", "Python", "C#", "HTML", "Kotlin", "C++", "COBOL", "C");
        Map<Integer,List<String>> length = listOfStrings.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Grouping len "+length);
        List<String> order = listOfStrings.stream().sorted(Comparator.comparing(String::length)).toList();
        System.out.println(order);
        String revWord = Arrays.stream(inputString.split(" ")).map(w->new StringBuilder(w).reverse()).collect(Collectors.joining());
        System.out.println(revWord);
        String word = listOfStrings.stream().collect(Collectors.joining(" "));
        System.out.println(word);
        String input = "swiss";
        String in = inputString.replaceAll("\\s"," ").toLowerCase();
        Map<String,Long> map1 = Arrays.stream(in.split(""))
                .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,Collectors.counting()));
        String nonRep = map1.entrySet().stream()
                .filter(s->s.getValue()==1).map(Map.Entry::getKey).findFirst().get();
        System.out.println(nonRep);

    }
}
