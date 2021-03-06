package com.unicorn.designpatterns;

/**
 * <p>
 *     简单工厂模式
 *     缺点: 当新增产品时, 需要修改ProductSimpleFactory类的getProduct方法, 添加新的else if 语句, 这就违反了开闭原则(对扩展开放, 对修改封闭)
 * </p>
 * Created on 2021/2/15.
 *
 * @author Unicorn
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        Product A = ProductSimpleFactory.getProduct("ProductA");
        A.produce();
        Product B = ProductSimpleFactory.getProduct("ProductB");
        B.produce();
    }
}

class ProductSimpleFactory{
    public static Product getProduct(String type){
        if ("ProductA".equals(type)){
            return new ProductA();
        }else if ("ProductB".equals(type)){
            return new ProductB();
        }else {
            return null;
        }
    }
}

interface Product{
    public void produce();
}

class ProductA implements Product{

    @Override
    public void produce() {
        System.out.println("A产品被生产出来了");
    }
}

class ProductB implements Product{

    @Override
    public void produce() {
        System.out.println("B产品被生产出来了");
    }
}