package com.unicorn.designpatterns;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 *     动态代理(JDK) : 代理对象不需要实现接口, 被代理对象需要实现接口
 *     CGlib动态代理 : cglib是第三方工具库, 可以创建代理对象. cglib的原理是继承, cglib通过继承目标类, 创建它的子类, 重写父类的方法, 实现功能的修改
 *                      因为cglib是继承, 并重写方法, 因此要求目标类可被继承, 即目标类和目标方法不是final的
 *                      由此可见, cglib对目标类的要求比较宽松, 只要能继承即可, 不要求目标类实现某个接口, 因此在框架中大量使用cglib动态代理
 * </p>
 * Created on 2021/3/14
 *
 * @author Unicorn
 */
public class DynamicProxyTest {
    public static void main(String[] args) {
        // 1. 创建被代理类
        TeacherDao1 teacherDao = new TeacherDao1();
        teacherDao.setName("张三");
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

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void teach() {
        System.out.println("我叫:" + this.name + ", 被代理对象在teaching...");
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
        // Proxy.newProxyInstance() 的作用是创建代理对象, 它的的返回值就是目标对象的代理对象
        // 参数1:ClassLoader loader : 类加载器, 负责向内存中加载对象, 可以使用反射获取类的类加载器
        // 参数2:Class<?>[] interfaces : 目标类实现的接口, 也可以通过反射获取
        // 参数3:InvocationHandler h : 这个是有我们编写的, 用于实现代理类需要完成的功能
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