package com.it.designpattern.principles.SingleResponsibility;

/**
 * @author zph
 * 单一职责原则
 * 对类来说的，即一个类应该只负责一项职责。
 * 如类 A 负责两个不同职责：职责 1，职责 2。
 * 当职责 1 需求变更 而改变 A 时，可能造成职责 2 执行错误，所以需要将类 A 的粒度分解为 A1，A2
 */
public class SR2 {

    public static void main(String[] args) {

        new AirVehicle().run("C919");
        new WaterVehicle().run("辽宁号");
        new TrackVehicle().run("磁悬浮列车");
        new LandVehicle().run("F1");
    }
}

/**
 * 遵守单一职责原则
 * 类分解，改动、花销较大
 */
class AirVehicle {

    public void run(String vehicle) {
        System.out.println(vehicle + "在空中上运行");
    }
}

class WaterVehicle {

    public void run(String vehicle) {
        System.out.println(vehicle + "在水中上运行");
    }
}

class TrackVehicle {

    public void run(String vehicle) {
        System.out.println(vehicle + "在轨道上运行");
    }
}

class LandVehicle {

    public void run(String vehicle) {
        System.out.println(vehicle + "在陆地上运行");
    }
}