package com.it.designpattern.principles.DependenceInversion;

/**
 * 依赖倒转原则
 * 方法一 接口传递
 */
public class DI2 {

    public static void main(String[] args) {
        Undercover undercover = new Undercover();
        undercover.receiveMessages(new Telegram());
        undercover.receiveMessages(new WeChat());
        undercover.receiveMessages(new WhatsApp());
    }

}

/**
 * 定义接口
 */
interface MessageService {
    public String getMessage();
}

class Telegram implements MessageService {
    @Override
    public String getMessage() {
        return "Telegram：有内鬼，终止交易！！！";
    }
}

class WeChat implements MessageService {
    @Override
    public String getMessage() {
        return "WeChat：有内鬼，终止交易！！！";
    }
}

class WhatsApp implements MessageService {
    @Override
    public String getMessage() {
        return "WhatsApp：有内鬼，终止交易！！！";
    }
}

class Undercover {
    public void receiveMessages(MessageService service) {
        System.out.println(service.getMessage());
    }
}
