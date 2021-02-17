package com.company;

import java.util.*;

public class StudentMarks {
    // Список студентів і груп
    private String studentInfo = " Дмитренко Олександр - ІП-84; Матвійчук Андрій - ІВ-83; Лесик Сергій - ІО-82; Ткаченко Ярослав - ІВ-83; Аверкова Анастасія - ІО-83; Соловйов Даніїл - ІО-83; Рахуба Вероніка - ІО-81; Кочерук Давид - ІВ-83; Лихацька Юлія - ІВ-82; Головенець Руслан - ІВ-83; Ющенко Андрій - ІО-82; Мінченко Володимир - ІП-83; Мартинюк Назар - ІО-82; Базова Лідія - ІВ-81; Снігурець Олег - ІВ-81; Роман Олександр - ІО-82; Дудка Максим - ІО-81; Кулініч Віталій - ІВ-81; Жуков Михайло - ІП-83; Грабко Михайло - ІВ-81; Іванов Володимир - ІО-81; Востриков Нікіта - ІО-82; Бондаренко Максим - ІВ-83; Скрипченко Володимир - ІВ-82; Кобук Назар - ІО-81; Дровнін Павло - ІВ-83; Тарасенко Юлія - ІО-82; Дрозд Світлана - ІВ-81; Фещенко Кирил - ІО-82; Крамар Віктор - ІО-83; Іванов Дмитро - ІВ-82";

    private Integer[] marks() {
        Integer[] marks = new Integer[8];
        for (int i = 0; i < marks.length; i++) {
            int value = (int) (Math.random() * (14 + 1));
            marks[i] = value;
        }
        return marks;
    }

    // Завдання 1
    public Map<String, List<String>> task1() {
        String[] arr = studentInfo.split(";");

        ArrayList<String[]> x = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            x.add(arr[i].split(" - "));
        }

        Set<String> groups = new HashSet<>();
        for (String[] test : x) {
            groups.add(test[1]);
        }

        Map<String, List<String>> groupsOfStudents = new HashMap<>();
        for (String group : groups) {
            List<String> studentsList = new ArrayList<>();
            for (String[] students : x) {
                if (group.equals(students[1])) {
                    studentsList.add(students[0]);
                }
            }
            groupsOfStudents.put(group, studentsList);
        }
        return groupsOfStudents;
    }

    // Завдання 2
    public Map<String, Map<String, Integer[]>> task2() {
        Map<String, Map<String, Integer[]>> studentMarks = new HashMap<>();

        for (String group : task1().keySet()) {
            Map<String, Integer[]> markArray = new HashMap<>();
            for (String student : task1().get(group)) {
                markArray.put(student, marks());
            }
            studentMarks.put(group, markArray);
        }
        return studentMarks;
    }

    // Завдання 3
    public Map<String, Map<String, Integer>> task3() {
        Map<String, Map<String, Integer>> studentsSumMark = new HashMap<>();

        for (String group : task2().keySet()) {
            Map<String, Integer> sumForOneStudent = new HashMap<>();
            for (String student : task1().get(group)) {
                sumForOneStudent.put(student, Arrays.stream(marks()).reduce(0, Integer::sum));
            }
            studentsSumMark.put(group, sumForOneStudent);
        }
        return studentsSumMark;
    }

    // Завдання 4
    public Map<String, Double> task4() {
        Map<String, Double> groupAverageMark = new HashMap<>();
        task3().forEach((group, marks) -> {
            double sum = 0;
            for (Integer i : marks.values()) {
                sum += i;
            }
            sum /= marks.size();
            groupAverageMark.put(group, sum);
        });
        return groupAverageMark;
    }

    // Завдання 5
    public Map<String, List<String>> task5() {
        Map<String, List<String>> studentsMarksMoreSixty = new HashMap<>();
        task3().forEach((group, std) -> {
            List<String> values = new ArrayList<>();
            std.forEach((student, marks) -> {
                if (marks >= 60) {
                    values.add(student);
                }
            });
            studentsMarksMoreSixty.put(group, values);
        });
        return studentsMarksMoreSixty;
    }

    // Вивід для завдання 2
    public void task2Show() {
        System.out.print("{");
        task2().forEach((group, students) -> {
            System.out.print(group + "=");
            students.forEach((student, marks) -> {
                System.out.print(student + " ");
                System.out.print("[");
                for (Integer x : marks) {
                    System.out.print(x + " ");
                }
                System.out.print("], ");

            });
        });
        System.out.print("}\n");
    }
}
