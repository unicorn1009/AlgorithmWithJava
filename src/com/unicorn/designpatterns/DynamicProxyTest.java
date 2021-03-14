package com.unicorn.designpatterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 *     动态代理(JDK) : 代理对象不需要实现接口, 被代理对象需要实现接口
 * </p>
 * Created on 2021/3/14
 *
 * @author Unicorn
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        // 1. 创建被代理类
        TeacherDao1 teacherDao = new TeacherDao1();
        // 2. 创建代理工程, 传入被代理类
        ProxyFactory proxyFactory = new ProxyFactory(teacherDao);
        // 3. 从代理工厂中获取代理对象实例, 强转为被代理类
        ITeacherDao1 proxyInstance = (ITeacherDao1)proxyFactory.getProxyInstance();
        // 4. 通过代理类调用方法
        proxyInstance.teach();
    }
}

interface ITeacherDao1{
    void teach();
}

// 被代理对象
class TeacherDao1 implements ITeacherDao1{

    @Override
    public void teach() {
        System.out.println("被代理对象在teaching...");
    }
}

class ProxyFactory{
    // 维护一个目标对象
    private Object target;

    // 构造器, 对target进行初始化
    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxyInstance(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("动态代理开始");
                Object returnValue = method.invoke(target, args);
                System.out.println("动态代理结束");
                return returnValue;
            }
        });
    }
}