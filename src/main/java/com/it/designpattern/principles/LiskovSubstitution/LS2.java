package com.it.designpattern.principles.LiskovSubstitution;

/**
 * 里氏替换原则
 */
public class LS2 {

    public static void main(String[] args) {
        A2 a = new A2();
        System.out.println("11-3=" + a.func1(11, 3));
        System.out.println("1-8=" + a.func1(1, 8));
        System.out.println("-----------------------");
        B2 b = new B2();
        //这里本意是求出 11-3
        System.out.println("11-3=" + b.func3(11, 3));
        System.out.println("1-8=" + b.func3(1, 8));
        System.out.println("11+3+9=" + b.func2(11, 3));
    }
}

/**
 * 对于A类和B类 把更加基础的方法和成员写道Base类中
 */
class Base {

}

/**
 * A类
 */
class A2 extends Base {

    /**
     * 返回两个数的差
     */
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

/**
 * B类
 * 解决B类继承A类耦合问题
 */
class B2 extends Base {

    //如果B类需要使用A类的方法，使用组合关系
    private A2 a = new A2();

    /**
     * A和B互不干扰
     */
    public int func1(int a, int b) {
        return a + b;
    }

    public int func2(int a, int b) {
        return func1(a, b) + 9;
    }

    public int func3(int a, int b) {
        return this.a.func1(a, b);
    }
}