package com.it.designpattern.principles.OpenClosed;

/**
 * 开闭原则
 * 违反了设计模式ocp原则，对扩展开放（提供方） 对修关闭（使用方）
 */
public class OC1 {

    public static void main(String[] args) {
        GraphicEditor1 graphicEditor = new GraphicEditor1();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        //新增方法
        graphicEditor.drawShape(new Triangle());
    }
}

/**
 * 绘图使用方
 * 根绝接收Shape对象type的不同绘制不同的图形
 */
class GraphicEditor1 {

    public void drawShape(Shape shape) {
        if (shape.type == 1) {
            drawRectangle(shape);
        } else if (shape.type == 2) {
            drawCircle(shape);
        } else if (shape.type == 3) {
            drawTriangle(shape);
        }
    }

    public void drawRectangle(Shape rectangle) {
        System.out.println("矩形" + rectangle);
    }

    public void drawCircle(Shape circle) {
        System.out.println("圆形" + circle);
    }

    /**
     * 新增方法
     * @param triangle
     */
    public void drawTriangle(Shape triangle) {
        System.out.println("圆形" + triangle);
    }
}

class Shape {
    int type;
}

/**
 * 原有提供方
 */
class Rectangle extends Shape {
    public Rectangle() {
        super.type = 1;
    }
}

/**
 * 原有提供方
 */
class Circle extends Shape {
    public Circle() {
        super.type = 2;
    }
}

/**
 * 新增一个方法
 */
class Triangle extends Shape {
    public Triangle() {
        super.type = 3;
    }
}