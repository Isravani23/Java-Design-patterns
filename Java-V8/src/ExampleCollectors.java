import java.util.*;
import java.util.stream.Collectors;  // For Collectors.toMap(), groupingBy(), etc.


public class ExampleCollectors {

   /* Stream.collect() method, Collector interface and Collectors class. collect() method is a terminal operation in Stream interface.
    Collector is an interface in java.util.stream package.*/
   public static void collectMethods(){
      List<Student> studentList = new ArrayList<Student>();
      studentList.add(new Student("Zevin", 12, "Computer Science", 91.2));
      studentList.add(new Student("Harish", 13, "History", 83.7));
      studentList.add(new Student("Xiano", 14, "Literature", 71.5));
      studentList.add(new Student("Soumya", 15, "Economics", 77.5));
      studentList.add(new Student("Asif", 16, "Mathematics", 89.4));
      studentList.add(new Student("Nihira", 17, "Computer Science", 84.6));
      studentList.add(new Student("Mitshu", 18, "History", 73.5));
      studentList.add(new Student("Vijay", 19, "Mathematics", 92.8));
      studentList.add(new Student("Harry", 20, "History", 71.9));
      //Top 3 performance
      List<Student> top = studentList.stream().sorted(Comparator.comparingDouble(Student::getPercentage).reversed()).limit(3).toList();
      System.out.println("Top 3 performance "+top);
      Set<String> sub = studentList.stream().map(Student::getSubject).collect(Collectors.toSet());
      System.out.println("Subjects "+sub);
      Map<String,Double> map =  studentList.stream().collect(Collectors.toMap(Student::getName,Student::getPercentage));
      System.out.println("Collecting "+map);
      DoubleSummaryStatistics studentStats = studentList.stream().collect(Collectors.summarizingDouble(Student::getPercentage));
      System.out.println("Highest Percentage : "+studentStats.getMax());
      System.out.println("Lowest Percentage : "+studentStats.getMin());
      System.out.println("Average Percentage : "+studentStats.getAverage());
      Map<String,List<Student>> group = studentList.stream().collect(Collectors.groupingBy(Student::getSubject));
      System.out.println("Grouping "+group);
      Map<Boolean,List<Student>> partition = studentList.stream().collect(Collectors.partitioningBy(s->s.getPercentage()>80.0));
      System.out.println("High per---"+partition);
      Map<String, Optional<Double>> high = studentList.stream().collect(Collectors
              .groupingBy(Student::getName,Collectors.mapping(Student::getPercentage,Collectors.maxBy(Double::compare))));
      System.out.println(high);
      Map<String,Long> count = studentList.stream().collect(Collectors.groupingBy(Student::getSubject,Collectors.counting()));
      System.out.println("Frequency----"+count);   }
}
