package com.soojong.study.designpattern.proxy;

public class Service implements ServiceInterface{

    @Override
    public void operation() {
        System.out.println("Hello World!! This is real service!!");
    }
}
