package java_practice;
import java.util.Scanner;

public class File {
    public static void main(String[] args) {

        System.out.println(7/10);
        System.out.println("enter how many subjects do u have" );
        Scanner subjects = new Scanner(System.in);
        int sub = subjects.nextInt();
        float sum=0;

        for(int i=0; i<sub; i++){
            System.out.print("enter subject marks out of 100 :");
            Scanner marks = new Scanner(System.in);
            float mark = marks.nextFloat();
            sum = sum+mark;
        }

        float cgpa = sum/(sub*10);
        System.out.format("your cgpa is : %f",cgpa);

    }

}
