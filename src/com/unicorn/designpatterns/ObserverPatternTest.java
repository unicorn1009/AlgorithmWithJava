package com.unicorn.designpatterns;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * </p>
 * Created on 2021/2/18.
 *
 * @author Unicorn
 */
public class ObserverPatternTest {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        Subject subject = new Subject();
        subject.addObserver(task1);
        subject.addObserver(task2);
        subject.notifyObservers("yyyy");
        System.out.println("-------------");
        subject.removeObserver(task1);
        subject.notifyObservers("zzzzzzzzz");

    }
}

class Subject{
    List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
        System.out.println("added observer :" + observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
        System.out.println("removed observer :" + observer);

    }

    public void notifyObservers(Object object){
        for (Observer observer : observers) {
            observer.update(object);
        }
    }
}

interface Observer{
    void update(Object object);
}

class Task1 implements Observer{

    @Override
    public void update(Object object) {
        System.out.println("Task1 received : "+ object);
    }
}

class Task2 implements Observer{

    @Override
    public void update(Object object) {
        System.out.println("Task2 received : "+ object);
    }
}