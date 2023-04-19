package com.company;

class Employee{
    int id;
    String name;
    private int salary;
    public void setSalary(int salary){this.salary=salary;}
    public int getSalary(){
        return salary;
    }
    public Employee(int i,String n){
        id =i;
        name = n;
    }
    public void details(){
        System.out.println("your id is : "+ id);
        System.out.println("your name is " + name);
        System.out.println("your salary is "+salary);
    }

}
public class BASIC {
    public static void main(String[] args) {
        Employee oman = new Employee(411, "Oman kumar");
        oman.setSalary(750000);
        System.out.println(oman.getSalary());
        oman.details();
    }
}

