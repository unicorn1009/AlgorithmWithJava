package com.unicorn.designpatterns;

/**
 * <p>
 *     抽象工厂模式
 *     优点: 复合单一职责原则和开闭原则
 * </p>
 * Created on 2021/2/16.
 *
 * @author Unicorn
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        IProduct product = new ProductBB();
        ICharge productCharge = product.getCharge();
        productCharge.charge();
        IShow productShow = product.getShow();
        productShow.show();
    }
}

// 假设产品A B ... 都具有同一类功能
// 定义一批接口
interface ICharge{
    void charge();
}
interface IShow{
    void show();
}
interface IProduct{
    ICharge getCharge();
    IShow getShow();
}

// 产品实现接口
class ProductACharge implements ICharge{

    @Override
    public void charge() {
        System.out.println("产品A在充电");
    }
}
class ProductAShow implements IShow{

    @Override
    public void show() {
        System.out.println("产品A显示信息");
    }
}
class ProductAA implements IProduct{

    @Override
    public ICharge getCharge() {
        return new ProductACharge();
    }

    @Override
    public IShow getShow() {
        return new ProductAShow();
    }
}

// 扩展产品时, 只需要实现一套接口

class ProductBCharge implements ICharge{

    @Override
    public void charge() {
        System.out.println("产品B在充电");
    }
}
class ProductBShow implements IShow{

    @Override
    public void show() {
        System.out.println("产品B显示信息");
    }
}
class ProductBB implements IProduct{

    @Override
    public ICharge getCharge() {
        return new ProductBCharge();
    }

    @Override
    public IShow getShow() {
        return new ProductBShow();
    }
}