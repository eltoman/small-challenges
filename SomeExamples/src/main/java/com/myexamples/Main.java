package com.myexamples;

public class Main {

    public static void main(String[] args){
        //ExampleStrategy array = new ArraysStream();
        //array.execute();

        ExampleStrategy array = new ArrayStreamReduce();
        array.execute();
    }

}
