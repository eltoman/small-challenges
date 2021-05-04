package com.myexamples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysStream implements ExampleStrategy{

    public ArraysStream() {
    }

    @Override
    public void execute() {
        System.out.println("--- Array Stream testing ---");

        int factor = 3;
        System.out.println(String.format("--- Print all multiple of %d  from 0 TO 100 ---", factor));
        Arrays.stream(IntStream.range(0, 100).toArray())
                .filter(x -> x % factor ==0)
                .forEach(System.out::println);

        System.out.println("\n--- Initial Array: Cities ---");
        List<String> array = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata", "Córdoba", "São Paulo"));
        array.forEach(System.out::println);

        System.out.println("--- Print Without Duplicated itens ---");
        array.stream().distinct().forEach(System.out::println);

        System.out.println("--- Print cities that contains 'P' ---");
        array.stream().filter(y -> y.toUpperCase().contains("P")).collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("--- Count cities that contains 'P' ---");
        System.out.println(array.stream().filter(y -> y.toUpperCase().contains("P")).count());
    }
}
