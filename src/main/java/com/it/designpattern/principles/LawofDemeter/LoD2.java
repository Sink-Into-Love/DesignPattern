package com.it.designpattern.principles.LawofDemeter;

import java.util.ArrayList;
import java.util.List;

/**
 * 迪米特法则
 */
public class LoD2 {

    public static void main(String[] args) {
        SchoolManager2 schoolManager = new SchoolManager2();
        schoolManager.printAllEmployee(new CollegeManager2());
    }

}

/**
 * 学校总部员工
 */
class Employee2 {
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
class CollegeEmployee2 {
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
class CollegeManager2 {
    public List<CollegeEmployee2> getAllEmployee() {
        List<CollegeEmployee2> list = new ArrayList<CollegeEmployee2>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee2 emp = new CollegeEmployee2();
            emp.setId("学院员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    public void printEmployee() {

        List<CollegeEmployee2> list1 = this.getAllEmployee();
        System.out.println("------------·学院员工------------");
        for (CollegeEmployee2 e : list1) {
            System.out.println(e.getId());
        }
    }
}

/**
 * 管理学院总部员工
 * 改进陌生类CollegeEmployee违反迪米特法则
 */
class SchoolManager2 {
    public List<Employee2> getAllEmployee() {
        List<Employee2> list = new ArrayList<Employee2>();

        for (int i = 0; i < 5; i++) {
            Employee2 emp = new Employee2();
            emp.setId("学校总部员工id= " + i);
            list.add(emp);
        }
        return list;
    }

    void printAllEmployee(CollegeManager2 sub) {

        //不符合迪米特法则
//        List<CollegeEmployee2> list1 = sub.getAllEmployee();
//        System.out.println("------------·学院员工------------");
//        for (CollegeEmployee2 e : list1) {
//            System.out.println(e.getId());
//        }

        //改进陌生类CollegeEmployee违反迪米特法则
        sub.printEmployee();

        List<Employee2> list2 = this.getAllEmployee();
        System.out.println("------------学校总部员工------------");
        for (Employee2 e : list2) {
            System.out.println(e.getId());
        }
    }
}