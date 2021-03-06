package com.unicorn.designpatterns;

/**
 * <p>
 *     原型模式
 *     解决对象克隆问题
 * </p>
 * Created on 2021/2/18.
 *
 * @author Unicorn
 */
public class PrototypePatternTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheep = new Sheep(11.2, "red", 4, new Sheep(22.2, "white", 2, null));
        Sheep clone = sheep.clone();
        System.out.println(sheep);
        System.out.println(clone);

    }
}

class Sheep implements Cloneable{
    public Double weight;
    public String color;
    public Integer age;
    public Sheep child;

    public Sheep(Double weight, String color, Integer age, Sheep child) {
        this.weight = weight;
        this.color = color;
        this.age = age;
        this.child = child;
    }

    // 浅拷贝， 如果有可变引用类型的属性， 则拷贝后指向的是同一个
//    @Override
//    protected Sheep clone() throws CloneNotSupportedException {
//        return ((Sheep) super.clone());
//    }

    // 深拷贝
    @Override
    protected Sheep clone() throws CloneNotSupportedException {
        Sheep clone = ((Sheep) super.clone());
        if (clone.getChild() != null)
            clone.setChild(clone.getChild().clone());
        return clone;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", child=" + child +
                '}' + '[' + hashCode() + ']';
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Sheep getChild() {
        return child;
    }

    public void setChild(Sheep child) {
        this.child = child;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}