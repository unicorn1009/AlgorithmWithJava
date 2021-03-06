package com.unicorn.designpatterns;

/**
 * <p>
 *     懒汉式单例模式
 * </p>
 * Created on 2021/2/14.
 *
 * @author Unicorn
 */
public class LazySingletonTest {

}

class LazySingleton{
    private static volatile LazySingleton instance;
    private LazySingleton(){}

    public static LazySingleton getInstance() {
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null)
                    instance = new LazySingleton();
            }
        }
        return instance;
    }
}
