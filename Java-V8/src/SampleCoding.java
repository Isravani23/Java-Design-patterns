import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public  class SampleCoding {
    public static void practice(){
        //Sample coding questions
        String s ="Java Concept";
        String p1 = "RaceCar";
        String p2 = "CarRace";
        Map<Character,Long> flow = s.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("InputChar "+flow);
        String firstNonRepeatedChar = String.valueOf(flow.entrySet().stream().filter(i->i.getValue()==1)
                .map(Map.Entry::getKey).findFirst().get());
        System.out.println("firstNonRepeatedChar--"+firstNonRepeatedChar);
        //Palindrome
        String s1 = Arrays.stream(s.split(" "))
                .map(c->new StringBuilder(c).reverse()).collect(Collectors.joining(" "));
        System.out.println("Reverse each word "+s1);
        boolean isPalindrome = IntStream.range(0,s.length()/2).noneMatch(i->s.charAt(i)!=s.charAt(s.length()-1));
        if(isPalindrome){
            System.out.println(s+"palindrome");
        }else{
            System.out.println(s+"Not a Palindrome");
        }
        //start with digit
        List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        List<String> isDigit = listOfStrings.stream().filter(i->Character.isDigit(i.charAt(0))).toList();
        System.out.println("Is digit "+isDigit);
        //Merge Array
        int[] a1 = {1,2,3,4,56};
        int[] a2 = {3,4,2,1,90};
        int[] c = IntStream.concat(Arrays.stream(a1),Arrays.stream(a2)).distinct().toArray();
        System.out.println("Merged Array"+Arrays.toString(c));
        OptionalInt d = Arrays.stream(a1).max();
        System.out.println(d);
        //Anagrams
        p1 = Stream.of(p1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        p2=  Stream.of(p2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        if (p1.equals(p2))
        {
            System.out.println("Two strings are anagrams");
        }
        else
        {
            System.out.println("Two strings are not anagrams");
        }
        int n =12345;
        int sum = Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();
        System.out.println(sum);
        int second = Arrays.stream(a1).sorted().distinct().skip(a1.length-2)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("Array must have at least two distinct elements"));
        System.out.println(second);
    }
}
