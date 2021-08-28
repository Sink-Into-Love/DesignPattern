package com.it.designpattern.principles.OpenClosed;

/**
 * 开闭原则
 */
public class OC2 {

    public static void main(String[] args) {
        GraphicEditor2 graphicEditor = new GraphicEditor2();
        graphicEditor.drawShape(new Square());
        graphicEditor.drawShape(new Trapezoid());
        //新增方法
        graphicEditor.drawShape(new Parallelogram());
    }
}

/**
 * 绘图使用方
 * 根绝接收Shape对象type的不同绘制不同的图形
 */
class GraphicEditor2 {

    public void drawShape(BaseShape shape) {
        shape.draw();
    }

}

/**
 * 抽象基类
 * 把创建 Shape 类做成抽象类，并提供一个抽象的 draw 方法，让子类去实现即可，
 * 有新的图形种类时，只需要让新的图形类继承 Shape，并实现 draw 方法即可，使用方的代码就不需要修 -> 满足了开闭原则
 */
abstract class BaseShape {
    int type;

    public abstract void draw();
}

/**
 * 原有提供方
 */
class Square extends BaseShape {
    public Square() {
        super.type = 1;
    }

    @Override
    public void draw() {
        System.out.println("正方形");
    }
}

/**
 * 原有提供方
 */
class Trapezoid extends BaseShape {
    public Trapezoid() {
        super.type = 2;
    }

    @Override
    public void draw() {
        System.out.println("梯形");
    }
}

/**
 * 新增一个方法
 */
class Parallelogram extends BaseShape {
    public Parallelogram() {
        super.type = 3;
    }

    @Override
    public void draw() {
        System.out.println("平行四边形");
    }
}