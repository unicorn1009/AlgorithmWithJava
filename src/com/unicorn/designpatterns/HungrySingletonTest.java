package com.unicorn.designpatterns;

/**
 * <p>
 *     饿汉式单例模式
 *     特点: 天生线程安全(JVM保证)
 * </p>
 * Created on 2021/2/14.
 *
 * @author Unicorn
 */
public class HungrySingletonTest {

}

class HungrySingleton{
    private static HungrySingletonTest instance = new HungrySingletonTest();

    private HungrySingleton(){}

    public static HungrySingletonTest getInstance() {
        return instance;
    }
}
