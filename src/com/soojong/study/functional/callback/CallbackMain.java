package com.soojong.study.functional.callback;

import java.util.function.Consumer;

public class CallbackMain {

    public static void main(String[] args) {

        //hello("John","Montana", null);

        hello("John",null, value -> {
            System.out.println("lastname not provided for " + value);
        });

        System.out.println("============");

        hello2("John",null, () -> {
            System.out.println("lastname not provided");
        });

    }

    static void hello(String firstName, String lastName, Consumer<String> callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.accept(firstName);
        }
    }

    static void hello2(String firstName, String lastName, Runnable callback) {
        System.out.println(firstName);
        if (lastName != null) {
            System.out.println(lastName);
        } else {
            callback.run();
        }
    }


}
