package com.unicorn.designpatterns;

/**
 * <p>
 *     静态代理: 需要定义接口或者父类, 被代理对象和代理对象一起实现相同的接口或者继承相同父类
 *     优点 : 在不修改目标对象的情况下可对对象中的方法进行增强
 *     缺点 : 代理对象和被代理对象都需要实现相同接口或继承相同父类, 因此会产生很多代理类, 且一旦接口增加方法, 目标对象和代理对象均需修改
 * </p>
 * Created on 2021/3/14
 *
 * @author Unicorn
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        // 1. 创建被代理对象
        TeacherDao teacherDao = new TeacherDao();

        // 2. 创建代理对象, 传入被代理对象
        ITeacherDao teacher = new TeacherDaoProxy(teacherDao);

        // 3. 调用代理对象的方法
        teacher.teach();
    }
}

// 代理类和被代理类都需要实现该接口
interface ITeacherDao{
    void teach();
}

// 被代理对象
class TeacherDao implements ITeacherDao{

    @Override
    public void teach() {
        System.out.println("被代理对象在teaching");
    }
}

// 代理对象
class TeacherDaoProxy implements ITeacherDao{

    // 目标对象(被代理对象)
    private ITeacherDao target;

    // 构造器
    public TeacherDaoProxy(ITeacherDao target) {
        this.target = target;
    }

    @Override
    public void teach() {
        System.out.println("执行代理对象的teach方法");
        target.teach();
        System.out.println("代理结束");
    }
}