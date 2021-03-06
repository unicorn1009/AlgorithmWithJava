package com.unicorn.designpatterns;

/**
 * <p>
 *     建造者模式
 *     解决的问题 : 假设要装一台电脑, 需要有一系列的步骤, 有一定的顺序, 顺序也不是特别固定, 此时就将装机的过程交给建造者来决定, 把电脑产品本身与建造产品的过程分开来
 * </p>
 * Created on 2021/2/16.
 *
 * @author Unicorn
 */
public class BuilderPatternTest {
    public static void main(String[] args) {
        // 建造者(打工人)
        ComputerBuilder appleComputerBuilder = new AppleComputerBuilder();
        // 指挥者: 决定如何组装产品
        Director director = new Director(appleComputerBuilder);
        Computer appleComputer = director.makeComputer();
        System.out.println(appleComputer);
    }

}

class Computer{
    private String mainBoard;       // 主板
    private String cpu;             // cpu
    private String memory;          // 内存条
    private String hardDisk;        // 硬盘
    private String computerCase;    // 机箱

    public Computer() { }

    public String getMainBoard() {
        return mainBoard;
    }

    public void setMainBoard(String mainBoard) {
        this.mainBoard = mainBoard;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(String hardDisk) {
        this.hardDisk = hardDisk;
    }

    public String getComputerCase() {
        return computerCase;
    }

    public void setComputerCase(String computerCase) {
        this.computerCase = computerCase;
    }
}

// 抽象的建造者, 定义一些需要进行的步骤
abstract class ComputerBuilder{
    abstract void installMainBoard();
    abstract void installCpu();
    abstract void installMemory();
    abstract void installHardDisk();
    abstract void installComputerCase();

    // 该方法也可以直接实现, 也可让子类实现
    abstract Computer build();
}

class AppleComputerBuilder extends ComputerBuilder{

    @Override

    void installMainBoard() {
        System.out.println("给Apple电脑安装主板");
    }

    @Override
    void installCpu() {
        System.out.println("给Apple电脑安装Cpu");
    }

    @Override
    void installMemory() {
        System.out.println("给Apple电脑安装内存");
    }

    @Override
    void installHardDisk() {
        System.out.println("给Apple电脑安装硬盘");
    }

    @Override
    void installComputerCase() {
        System.out.println("给Apple电脑安装机箱");
    }

    @Override
    Computer build() {
        return new Computer();
    }
}

class Director{
    ComputerBuilder computerBuilder;

    // 提供构造器传入ComputerBuilder

    public Director(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    // 指导者指导如何去安装一台电脑
    public Computer makeComputer(){
        // 先装主板, 再装cpu ... 最后装机箱
        computerBuilder.installMainBoard();
        computerBuilder.installCpu();
        computerBuilder.installMemory();
        computerBuilder.installHardDisk();
        computerBuilder.installComputerCase();

        return computerBuilder.build();
    }
}