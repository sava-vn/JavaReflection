package entities;

import annotation.Excel;
import annotation.ExcelColumn;

@Excel(names = "Cat")
public abstract class Cat extends Animal implements Say {
    public static final String SAY = "MEO MEO";
    public static final int NUMBER_OF_LEGS = 4;

    @ExcelColumn(index = 0, title = "Name")
    private String name;


    @ExcelColumn(index = 1, title = "Age")
    private int age;

    public Cat() {
    }
    public Cat(String name){
        this.name = name;
        this.age = 1;
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int getNumberOfLegs() {
        return NUMBER_OF_LEGS;
    }

    @Override
    public String say() {
        return SAY;
    }
}
