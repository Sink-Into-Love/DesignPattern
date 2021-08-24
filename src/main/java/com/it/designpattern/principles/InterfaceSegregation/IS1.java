package com.it.designpattern.principles.InterfaceSegregation;

/**
 * @author zph
 * 违反接口隔离原则
 */
public class IS1 {

}

/**
 * 接口Interface1（相当于service）
 */
interface Interface0 {

    void method1();

    void method2();

    void method3();

    void method4();

    void method5();
}

/**
 * 类 A 通过接口 Interface1 依赖类 B（相当于controller）
 * 需要method1 method2 method3 的依赖实现
 */
class A1 {

    public void depend1(Interface0 interface0) {
        interface0.method1();
    }

    public void depend2(Interface0 interface0) {
        interface0.method2();
    }

    public void depend3(Interface0 interface0) {
        interface0.method3();
    }
}

/**
 * 接口实现类B（相当于serviceImpl）
 */
class B1 implements Interface0 {

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

    @Override
    public void method4() {
        System.out.println("B实现method4");
    }

    @Override
    public void method5() {
        System.out.println("B实现method5");
    }
}

/**
 * 类 C 通过接口 Interface1 依赖类 D（相当于controller）
 * 需要method3 method4 method5 的依赖实现
 */
class C1 {

    public void depend3(Interface0 interface0) {
        interface0.method3();
    }

    public void depend4(Interface0 interface0) {
        interface0.method4();
    }

    public void depend5(Interface0 interface0) {
        interface0.method5();
    }
}

/**
 * 接口实现类D（相当于serviceImpl）
 */
class D1 implements Interface0 {

    @Override
    public void method1() {
        System.out.println("D实现method1");
    }

    @Override
    public void method2() {
        System.out.println("D实现method2");
    }

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