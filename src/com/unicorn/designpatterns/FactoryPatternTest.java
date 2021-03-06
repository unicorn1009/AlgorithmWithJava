package com.unicorn.designpatterns;

/**
 * <p>
 *     工厂方法模式
 *     优点: 符合单一职责原则 开闭原则
 * </p>
 * Created on 2021/2/15.
 *
 * @author Unicorn
 */
public class FactoryPatternTest {
    public static void main(String[] args) {
        BMW bmw = new BMWFactory().getCar();
        bmw.run();
        Benz benz = new BenzFactory().getCar();
        benz.run();
    }
}

// 工厂接口
interface CarFactory{
    Car getCar();
}

// 两个工厂类
class BMWFactory implements CarFactory{

    @Override
    public BMW getCar() {
        return new BMW();
    }
}

class BenzFactory implements CarFactory{

    @Override
    public Benz getCar() {
        return new Benz();
    }
}

interface Car{
    void run();
}

class BMW implements Car{

    @Override
    public void run() {
        System.out.println("宝马在路上跑");
    }
}

class Benz implements Car{

    @Override
    public void run() {
        System.out.println("奔驰在路上跑");
    }
}
