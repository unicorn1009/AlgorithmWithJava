package com.unicorn.designpatterns;

/**
 * <p>
 *     静态内部类单例模式
 * </p>
 * Created on 2021/2/15.
 *
 * @author Unicorn
 */
public class InnerClassSingletonTest {
}

class InnerClassSingleton{
    // 此静态内部类只会在第一次调用getInstance()方法时进行加载和初始化
    private static class InnerClassHolder{
        private static InnerClassSingleton instance = new InnerClassSingleton();

    }
    private InnerClassSingleton(){
        // 防止通过反射获取新实例
        if (InnerClassHolder.instance != null){
            throw new RuntimeException("单例模式不允许创建多个实例");
        }
    }
    public static InnerClassSingleton getInstance(){
        return InnerClassHolder.instance;
    }
}