package com.it.designpattern.principles.LiskovSubstitution;

/**
 * 里氏替换原则
 */
public class LS1 {

    public static void main(String[] args) {
        A1 a = new A1();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));
        System.out.println("-----------------------");
        B1 b = new B1();
        //这里本意是求出 11-3  1-8
        System.out.println("11-3=" + b.func1(11, 3));
        System.out.println("1-8=" + b.func1(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
    }
}

/**
 * A类
 */
class A1 {

    /**
     * 返回两个数的差
     */
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

/**
 * B类继承了 A
 * 增加了一个新功能：完成两个数相加,然后和 9 求和
 */
class B1 extends A1 {

    /**
     * 假设，重写了A类的方法,导致原有功能错误
     */
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }
}