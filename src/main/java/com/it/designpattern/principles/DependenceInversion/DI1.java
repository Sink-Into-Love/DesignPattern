package com.it.designpattern.principles.DependenceInversion;

/**
 * 依赖倒转原则
 */
public class DI1 {

    public static void main(String[] args) {
        Insider insider = new Insider();
        insider.receiveMessages(new ShortMessage());
    }

}

class ShortMessage {

    public String getMessage() {
        return "短信：有卧底，终止交易！！！";
    }

}

/**
 * 获取的对象不应仅限于短信，常规做法为为Person增加相应的接收方法
 * 可使用依赖倒转原则解决
 */
class Insider {
    public void receiveMessages(ShortMessage shortMessage) {
        System.out.println(shortMessage.getMessage());
    }
}