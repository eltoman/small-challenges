package com.myexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayStreamReduce implements ExampleStrategy{

    @Override
    public void execute() {
        System.out.println("--- Array Stream Reduce testing ---");
        System.out.println("--- Initial Array: fibonacci ---");
        List<Integer> array = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 5, 8, 13, 21));
        array.forEach(System.out::println);

        System.out.println("--- sum fibonacci  0-21 ---");
        System.out.println(array.stream().reduce(0, (subtotal, element) -> subtotal + element));

        System.out.println("--- sum even numbers from fibonacci  0-21 ---");
        System.out.println(array.stream().filter(x -> x % 2 == 0)
                .reduce(0, (subtotal, element) -> subtotal + element));
    }
}
