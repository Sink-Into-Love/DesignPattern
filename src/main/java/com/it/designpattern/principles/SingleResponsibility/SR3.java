package com.it.designpattern.principles.SingleResponsibility;

/**
 * @author zph
 * 单一职责原则
 */
public class SR3 {

    public static void main(String[] args) {

        VehicleAll vehicle = new VehicleAll();
        vehicle.runAir("C919");
        vehicle.runWater("辽宁号");
        vehicle.runTrack("磁悬浮列车");
        vehicle.runLand("坦克");
    }
}

/**
 * 遵守单一职责原则
 * 类不遵守原则，方法级别上遵守原则
 */
class VehicleAll {

        public void runAir(String vehicle) {
            System.out.println(vehicle + "在空中上运行");
        }

        public void runWater(String vehicle) {
            System.out.println(vehicle + "在水中上运行");
        }

        public void runTrack(String vehicle) {
            System.out.println(vehicle + "在轨道上运行");
        }

        public void runLand(String vehicle) {
            System.out.println(vehicle + "在陆地上运行");
        }

}