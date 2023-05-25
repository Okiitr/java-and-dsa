package java_practice;
class MyClass{
    int id;
    String name;
    private int salary;

    public void setSalary(int salary) {
        this.salary=salary;
    }

    public int getSalary() {
        return salary;
    }

    public MyClass(int i, String n){
        id =i;
        name=n;
    }
    public void details(){
        System.out.println("your id is : "+ id);
        System.out.println("your name is " + name);
        System.out.println("your salary is "+salary);
    }
}
public class Practice {
    public static void main(String[] args) {
        MyClass obj = new MyClass(411,"oman");
        obj.setSalary(250000);
        System.out.println( obj.getSalary());
        obj.details();

    }
}

