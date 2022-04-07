package ru.skypro;
// +++++++++++++++++++++++  класс -  работник  +++++++++++++++++++++++
public class Employee {

    private int id;
    private String name;
    private int department;
    private int salary;
    private static int idCounter;



    public Employee(String name, int department, int salary) {
        this.id = getIdCounter();
        this.name = name;
        this.department = department;
        this.salary = salary;
        idCounter++;
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

    public int getIdCounter() {
        return idCounter;
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
}