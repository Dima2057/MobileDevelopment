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
        TimeDT t2 = new TimeDT(12, 0, 1);
        TimeDT t3 = new TimeDT(13, 27, 11);
        TimeDT t4 = new TimeDT(1, 15, 29);
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
        System.out.println(TimeDT.summation(t2));
        System.out.println(TimeDT.summation(t5));
        System.out.println(TimeDT.summation(t4));
        System.out.println(timeDT.retSum(t4, t5));
        System.out.println(timeDT.retNeg(t5, t3));
    }
}
