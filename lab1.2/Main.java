package com.company;

import java.sql.Time;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        StudentMarks x = new StudentMarks();
        System.out.println(x.task1().toString());   // Task1
        x.task2Show();                              // Task2
        System.out.println(x.task3().toString());   // Task3
        System.out.println(x.task4().toString());   // Task4
        System.out.println(x.task5().toString());   // Task5

        TimeDT t1 = new TimeDT(23, 59, 59);
        TimeDT t2 = new TimeDT(6, 0, 15);
        TimeDT t3 = new TimeDT(15, 22, 14);
        TimeDT t4 = new TimeDT(3, 45, 13);
        TimeDT t5 = new TimeDT(new Date());
        TimeDT t6 = new TimeDT();
        TimeDT t7 = new TimeDT(0, 0, 1);
        TimeDT timeDT = new TimeDT();
        System.out.println(t1.toString());
        System.out.println(t2.toString());
        System.out.println(t3.toString());
        System.out.println(t4.toString());
        System.out.println(t5.toString());
        System.out.println(t6.toString());
        System.out.println(t7.toString());

        System.out.println("Operations: ");
        System.out.println(t1.summation(t2));       //t1 + t2
        System.out.println(t3.summation(t5));       //t2 + t3
        System.out.println(TimeDT.retSum(t5, t4));  //t2 + t4
        System.out.println(t6.negation(t7));        //t7 - t5
        System.out.println(TimeDT.retNeg(t5, t3));  //t6 - t1
    }
}
