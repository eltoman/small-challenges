package com.myexamples;

public class Main {

    public static void main(String[] args){
        System.out.println("<<--- LETS PLAY --->>");
        ExampleStrategy array = new ArraysStream();
        array.execute();

        System.out.println("\n\n<<--- New Strategy--->>");
        System.out.println("<<--- Array Stream Reduce --->>");
        ExampleStrategy arrayStreamReduce = new ArrayStreamReduce();
        arrayStreamReduce.execute();

    }

}
