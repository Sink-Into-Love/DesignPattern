package com.it.designpattern.principles.SingleResponsibility;

/**
 * @author zph
 * 单一职责原则
 */
public class SR1 {

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.run("航母");
        vehicle.run("磁悬浮列车");
        vehicle.run("飞机");
        vehicle.run("火箭");
    }
}

/**
 *
 */
class Vehicle {

    public void run(String vehicle) {
        System.out.println(vehicle + "在马路上运行");
    }
}