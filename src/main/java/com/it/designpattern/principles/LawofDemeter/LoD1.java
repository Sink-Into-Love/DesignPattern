package com.it.designpattern.principles.LawofDemeter;

import java.util.ArrayList;
import java.util.List;

/**
 * 迪米特法则
 */
public class LoD1 {

    public static void main(String[] args) {
        SchoolManager1 schoolManager = new SchoolManager1();
        schoolManager.printAllEmployee(new CollegeManager1());
    }

}

/**
 * 学校总部员工
 */
class Employee1 {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

/**
 * 学院员工
 */
class CollegeEmployee1 {
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

/**
 * 管理学院员工
 */
class CollegeManager1 {
    public List<CollegeEmployee1> getAllEmployee() {
        List<CollegeEmployee1> list = new ArrayList<CollegeEmployee1>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee1 emp = new CollegeEmployee1();
            emp.setId("学院员工id= " + i);
            list.add(emp);
        }
        return list;
    }
}

/**
 * 管理学院总部员工
 * 违反迪米特法则
 * 成员变量 方法参数 方法返回值 中的类为直接的朋友：
 * Employee CollegeManager
 * 陌生类：
 * CollegeEmployee是局部变量
 */
class SchoolManager1 {
    public List<Employee1> getAllEmployee() {
        List<Employee1> list = new ArrayList<Employee1>();

        for (int i = 0; i < 5; i++) {
            Employee1 emp = new Employee1();
            emp.setId("学校总部员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    void printAllEmployee(CollegeManager1 sub) {

        List<CollegeEmployee1> list1 = sub.getAllEmployee();
        System.out.println("------------·学院员工------------");
        for (CollegeEmployee1 e : list1) {
            System.out.println(e.getId());
        }
        List<Employee1> list2 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee1 e : list2) {
            System.out.println(e.getId());
        }
    }
}