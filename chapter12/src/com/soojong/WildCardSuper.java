package com.soojong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 681 페이지
 *
 * 제네릭 와일드 카드 super 예시 코드
 */
public class WildCardSuper {

    public static void run(){
        FruitBox<Apple> appleBox = new FruitBox<>();
        FruitBox<Grape> grapeBox = new FruitBox<>();

        appleBox.add(new Apple("GreenApple",300));
        appleBox.add(new Apple("GreenApple",100));
        appleBox.add(new Apple("GreenApple",200));

        grapeBox.add(new Grape("GreenGrape",400));
        grapeBox.add(new Grape("GreenGrape",300));
        grapeBox.add(new Grape("GreenGrape",200));

        Collections.sort(appleBox.getList(), new AppleComp());
        Collections.sort(grapeBox.getList(),new GrapeComp());
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);

        Collections.sort(appleBox.getList(), new FruitComp());
        Collections.sort(grapeBox.getList(),new FruitComp());
        System.out.println("appleBox = " + appleBox);
        System.out.println("grapeBox = " + grapeBox);


    }
}

class Fruit {
    String name;
    int weight;

    public Fruit(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String toString() {
        return name+"("+weight+")";
    }
}

class Apple extends Fruit{
    Apple(String name,int weight){
        super(name,weight);
    }
}

class Grape extends Fruit{
    Grape(String name,int weight){
        super(name,weight);
    }
}

class AppleComp implements Comparator<Apple> {

    @Override
    public int compare(Apple t1, Apple t2) {
        return t2.weight - t1.weight;
    }
}

class GrapeComp implements Comparator<Grape> {

    @Override
    public int compare(Grape t1, Grape t2) {
        return t2.weight - t1.weight;
    }
}

class FruitComp implements Comparator<Fruit> {

    @Override
    public int compare(Fruit t1, Fruit t2) {
        return t1.weight - t2.weight;
    }
}

class FruitBox<T extends Fruit> extends Box<T>{}

class Box<T>{
    ArrayList<T> list = new ArrayList<T>();

    void add(T item){ list.add(item);}
    T get(int i){return list.get(i);}
    ArrayList<T> getList() {return list;}
    int size(){return list.size();}
    public String toString(){return list.toString();}
}

