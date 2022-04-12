package ru.skypro;

import java.util.Objects;

// +++++++++++++++++++++++  класс -  работник  +++++++++++++++++++++++
public class Employee {

    private int id;
    private String name;
    private int department;
    private int salary;
    private static int idCounter;



    public Employee(String name, int department, int salary) {
        this.id = ++idCounter;
        this.name = name;
        this.department = department;
        this.salary = salary;

    }
// -------------------------- Геттеры  --------------------------
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }


// -------------------------- Сеттеры  --------------------------
    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
// -------------------------- Метод toString  --------------------------

    @Override
    public String toString() {
        return "id-" + id + ", Ф.И.О.: " + name + ", отдел-" + department + ", з/п- " + salary + " руб./мес.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}