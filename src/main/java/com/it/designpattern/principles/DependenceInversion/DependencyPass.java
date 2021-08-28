package com.it.designpattern.principles.DependenceInversion;

/**
 * 依赖倒转原则
 * 依赖传递三种实现方式
 * 接口传递 构造方法传递 setter方法传递
 */
public class DependencyPass {

    public static void main(String[] args) {
        //方式一
        new OpenAndClose1().open(new TV1());

        //方式二
        new OpenAndClose2(new TV2()).open();

        //方式三
        OpenAndClose3 openAndClose3 = new OpenAndClose3();
        openAndClose3.setTv(new TV3());
        openAndClose3.open();
    }

}

// 方式1： 通过接口传递实现依赖
// 开关的接口
interface IOpenAndClose1 {
    public void open(ITV1 tv1); //抽象方法,接收接口
}

interface ITV1 { //ITV接口
    public void play();
}

class TV1 implements ITV1 {

    @Override
    public void play() {
        System.out.println("方式一play执行");
    }
}

// 实现接口
class OpenAndClose1 implements IOpenAndClose1 {

    @Override
    public void open(ITV1 tv1) {
        tv1.play();
    }
}


// 方式2: 通过构造方法依赖传递
interface IOpenAndClose2 {
    public void open(); //抽象方法
}

interface ITV2 { //ITV接口
    public void play();
}

class TV2 implements ITV2 {

    @Override
    public void play() {
        System.out.println("方式二play执行");
    }
}

class OpenAndClose2 implements IOpenAndClose2 {
    //成员
    public ITV2 tv2;

    //构造器
    public OpenAndClose2(ITV2 tv2) {
        this.tv2 = tv2;
    }

    @Override
    public void open() {
        this.tv2.play();
    }
}

// 方式3 , 通过setter方法传递
interface IOpenAndClose3 {
    public void open(); // 抽象方法

    public void setTv(ITV3 tv3);
}

interface ITV3 { // ITV接口
    public void play();
}

class TV3 implements ITV3 {

    @Override
    public void play() {
        System.out.println("方式三play执行");
    }
}

class OpenAndClose3 implements IOpenAndClose3 {
    private ITV3 tv3;

    @Override
    public void setTv(ITV3 tv3) {
        this.tv3 = tv3;
    }

    @Override
    public void open() {
        this.tv3.play();
    }
}