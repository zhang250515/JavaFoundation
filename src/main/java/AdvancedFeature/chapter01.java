package AdvancedFeature;

import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by ZhangQ on 2017/12/17.
 */
public class chapter01 {
    volatile Integer a = 2;
    @Test
    public void testRegex(){
        String content = "I am kent. And u?";
        List<String> list = Arrays.asList(content.split("//PL+"));
        System.out.println(list);
        List<String> list1 = new LinkedList<>();
        list1.add("I");
        list1.add("am");
        list1.add("kent");
        long num = list1.stream().filter(w->w.length()>2).count();
        System.out.println(num);
    }

    @Test
    public void testNIO() throws IOException{
        String contents = new String(Files.readAllBytes(
                Paths.get(System.getProperty("user.dir"),"src/main/resources","test.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        System.out.println(words);
        Long count = words.parallelStream().filter(w->w.length()>3).count();
        System.out.println(count);
        /*FileSystem f = FileSystems.getDefault();
        Path path = f.getPath(System.getProperty("user.dir"),"src/main/resources","test.txt");
        BufferedReader reader = Files.newBufferedReader(path,StandardCharsets.UTF_8);
        while (reader.ready())
            System.out.println(reader.readLine());*/
        Stream<String> pp = Pattern.compile("\\PL+").splitAsStream(contents);
        pp.filter(p -> p.length()>3).forEach(System.out::println);
    }

    @Test
    public void testStream() throws IOException{
        String contents = new String(Files.readAllBytes(
                Paths.get(System.getProperty("user.dir"),"src/main/resources","test.txt")), StandardCharsets.UTF_8);
        Stream<BigInteger> num = Stream.iterate(BigInteger.ZERO,n->n.add(BigInteger.ONE));
        Stream<BigInteger> m = num.limit(10);
        List<BigInteger> l = new LinkedList<>();
        m.forEach(l::add);
        System.out.println(l);
        show("words",Stream.of(contents.split("\\PL+")));
        Stream<String> echo = Stream.generate(()->"echos");
        show("echo",echo);
        Stream<Double> nums = Stream.generate(Math::random);
        show("nums",nums);
    }

    public static <T> void show(String title, Stream<T> stream)
 {
         final int SIZE = 10;
         List<T> firstElements = stream
         .limit(SIZE + 1)
         .collect(Collectors.toList());
         System.out.print(title + ": ");
         for (int i = 0; i < firstElements.size(); i++)
             {
             if (i > 0) System.out.print(", ");
             if (i < SIZE) System.out.print(firstElements.get(i));
             else System.out.print("...");
             }
         System.out.println();
 }

 @Test
    public void testShow(){
        List<String> words = new LinkedList<>();
        words.add("A");
        words.add("B");
        words.add("C");
        /*Stream<String> toLow = words.stream().map(String::toLowerCase);
        toLow.iterator().forEachRemaining(System.out::println);
        System.out.println("0123".substring(0,1));
        System.out.println(Integer.max(1,6));*/
        Optional<String> max = words.stream().max(String::compareToIgnoreCase);
        System.out.println(max.orElse(""));
    }

    @Test
    public void testOptional(){
        List<String> list = new LinkedList<>();
        Optional<String> op = Stream.generate(()->"null").findFirst();
        op.ifPresent(list::add);
        list.forEach(System.out::print);
        String a = "123";
    }
}
