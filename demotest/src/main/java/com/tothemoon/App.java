package com.tothemoon;


import java.util.ArrayList;
import java.util.List;

public class App<T> {
    private T t;

    public App(T t) {
        this.t = t;
    }

    public T get() {
        return t;
    }

    public static void printList(List<?> list) {
        for (Object elem : list) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Using T
        App<String> example1 = new App<>("Hello");
        System.out.println("Value: " + example1.get());

        App<Integer> example2 = new App<>(123);
        System.out.println("Value: " + example2.get());

        // Using ?
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        List<String> stringList = new ArrayList<>();
        stringList.add("A");
        stringList.add("B");
        stringList.add("C");

        System.out.println("Printing integer list:");
        printList(integerList);

        System.out.println("Printing string list:");
        printList(stringList);
    }
}
