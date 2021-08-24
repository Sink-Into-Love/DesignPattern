package com.it.designpattern.principles.InterfaceSegregation;

/**
 * @author zph
 * 接口隔离原则
 * 客户端不应该依赖它不需要的接口，即一个类对另一个类的依赖应该建立在最小的接口上
 */
public class IS2 {

    public static void main(String[] args) {
        /**
         * 接口是为了实现多态
         * Interface1 interface1 = new Interface1Impl()
         * 接口 对象 = new 实现类
         */

        A2 a = new A2();
        B2 b = new B2();
        a.depend1(b);
        a.depend2(b);
        a.depend3(b);

        C2 c = new C2();
        D2 d = new D2();
        c.depend3(d);
        c.depend4(d);
        c.depend5(d);
    }
}

/**
 * 接口Interface1（相当于service）
 */
interface Interface1 {

    void method1();

    void method2();
}

/**
 * 接口Interface2（相当于service）
 */
interface Interface2 {

    void method3();
}

/**
 * 接口Interface3（相当于service）
 */
interface Interface3 {

    void method4();

    void method5();
}

/**
 * 类 A 通过接口 Interface1 Interface2 依赖类 B（相当于controller）
 * 需要method1 method2 method3 的依赖实现
 */
class A2 {

    public void depend1(Interface1 interface1) {
        interface1.method1();
    }

    public void depend2(Interface1 interface1) {
        interface1.method2();
    }

    public void depend3(Interface2 interface2) {
        interface2.method3();
    }
}

/**
 * 接口实现类B（相当于serviceImpl）
 */
class B2 implements Interface1, Interface2 {

    @Override
    public void method1() {
        System.out.println("B实现method1");
    }

    @Override
    public void method2() {
        System.out.println("B实现method2");
    }

    @Override
    public void method3() {
        System.out.println("B实现method3");
    }
}

/**
 * 类 C 通过接口 Interface2 Interface3 依赖类 D（相当于controller）
 * 需要method3 method4 method5 的依赖实现
 */
class C2 {

    public void depend3(Interface2 interface2) {
        interface2.method3();
    }

    public void depend4(Interface3 interface3) {
        interface3.method4();
    }

    public void depend5(Interface3 interface3) {
        interface3.method5();
    }
}

/**
 * 接口实现类D（相当于serviceImpl）
 */
class D2 implements Interface2, Interface3 {

    @Override
    public void method3() {
        System.out.println("D实现method3");
    }

    @Override
    public void method4() {
        System.out.println("D实现method4");
    }

    @Override
    public void method5() {
        System.out.println("D实现method5");
    }
}