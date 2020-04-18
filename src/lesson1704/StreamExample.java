package lesson1704;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5);
        Supplier<Integer> sup=new Supplier<Integer>() {
            @Override
            public Integer get() {
                return null;
            }
        };
        Stream.generate(new Random()::nextInt).limit(10);
        int[] arr=new int[]{1,2,3,4,5,6,7};
        Arrays.stream(arr);
        List qwe45=new Vector();
        //qwe45.stream()
    }
}
