import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public  class SampleCoding {
    public static void practice(){
        //Sample coding questions
        String s ="Java Concept";
        Map<Character,Long> flow = s.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println("InputChar "+flow);
        String s1 = Arrays.stream(s.split(" "))
                .map(c->new StringBuilder(c).reverse()).collect(Collectors.joining(" "));
        System.out.println("Reverse each word "+s1);
        boolean isPalindrome = IntStream.range(0,s.length()/2).noneMatch(i->s.charAt(i)!=s.charAt(s.length()-1));
        if(isPalindrome){
            System.out.println(s+"palindrome");
        }else{
            System.out.println(s+"Not a Palindrome");
        }
        List<String> listOfStrings = Arrays.asList("One", "2wo", "3hree", "Four", "5ive", "Six");
        List<String> isDigit = listOfStrings.stream().filter(i->Character.isDigit(i.charAt(0))).toList();
        System.out.println("Is digit "+isDigit);
    }
}
