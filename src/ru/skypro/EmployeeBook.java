package ru.skypro;

import jdk.jshell.spi.ExecutionControl;

import java.util.Arrays;

// +++++++++++++++++++++++  класс -  книга работников  +++++++++++++++++++++++
public class EmployeeBook {

    private Employee[] empl;

    private int countNotNull;
    private int countNotNullDep;
    private int numDep; // Число отделов

    public void main() {
        numDep = 5;
        empl = new Employee[10];

        empl[0] = new Employee("Иванов Сергей Александрович", 1, 32500);
        empl[1] = new Employee("Кентавр Рон Уизлевич", 4, 111000);
        empl[2] = new Employee("Сидоров Алексей Владимирович", 1, 58900);
        empl[3] = new Employee("Горева Алла Витальевна", 2, 43150);
        empl[4] = new Employee("Салимова Элла Панфиловна", 2, 64800);
        empl[5] = new Employee("Крылов Олег Николаевич", 5, 78560);
        empl[6] = new Employee("Шарипова Оксана Снежановна", 3, 55555);
        empl[7] = new Employee("Потапов Евгений Сергеевич", 5, 81000);


    }

    // ----------------  базовые методы ----------------------------
// -------------------------------------------------------------
    public void printAllEmplInform() { // печатаем всю информацию о сотрудниках
        for (int i = 0; i < empl.length; i++) {
            //       if (empl[i] != null) {
            System.out.println(empl[i]);
            //        }
        }
    }

    public int calcCostsPerMonth() { // считаем сумму затрат на зарплаты в месяц
        int sum = 0;
        countNotNull = 0;
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] != null) {
                sum += empl[i].getSalary();
                countNotNull++;
            }
        }
        return sum;
    }

    public int getIdOfMinSalary() { // определяем id сотрудника с минимальной з/п
        int idMin = 0;
        int min = empl[0].getSalary();
        for (int i = 1; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getSalary() < min) {
                min = empl[i].getSalary();
                idMin = i;
            }
        }
        return idMin;
    }

    public void printEmployee(int idTemp) { // печатаем информацию о сотруднике
        if (idTemp >= 0 && idTemp < empl.length) {
            System.out.println(empl[idTemp]);
        } else {
            System.out.println("Такого сотрудника нет");
        }
    }

    public int getIdOfMaxSalary() { // определяем id сотрудника с МАКСимальной з/п
        int idMax = 0;
        int max = empl[0].getSalary();
        for (int i = 1; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getSalary() > max) {
                max = empl[i].getSalary();
                idMax = i;
            }
        }
        return idMax;
    }

    public double calcMiddleSalary() { // считаем среднюю з/п
        int sum = calcCostsPerMonth();
        double midSalary = (double) sum / countNotNull;
        return midSalary;
    }

    public void printAllNames() {
        System.out.println("====   Список Ф.И.О. всех сотрудников:   ====");
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] != null) {
                System.out.printf(empl[i].getName() + "\n");
            }
        }
    }

    @Override
    public String toString() {
        return "EmployeeBook{" +
                "empl=" + Arrays.toString(empl) +
                '}';
    }

    // ----------   методы задания повышенной сложности  --------------------------
// --------------------------------------------------------------------------------
    public void indexAllSalaries(int percent) { // увеличиваем все зарплаты на величину percent в %
        int t;
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] != null) {
                t = empl[i].getSalary();
                empl[i].setSalary(t + t * (int) percent / 100);
            }
        }
    }

    private boolean isExistDep(int numDepart) { // проверяем корректность номера отдела
        boolean isEx = false;
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] != null && numDepart == empl[i].getDepartment()) {
                isEx = true;
                return isEx;
            }
        }
        return isEx;


    } // --------------------------------------------------------------


    private int getFirstIdDepart(int numDepart) {// определяем 1-й id сотрудника нужного отдела ---------
        int idMinMax = 0;
        for (int i = idMinMax; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getDepartment() == numDepart) {
                idMinMax = i;
                break;
            }
        }
        return idMinMax;
    }

    public int getIdMinSalDepartment(int numDepart) { // определяем id сотрудника с минимальной з/п в отделе
        if (!isExistDep(numDepart)) {
            System.out.println("Такого отдела нет");
            throw new RuntimeException();
        }

        int idMin = getFirstIdDepart(numDepart);
        int min = empl[idMin].getSalary();

        for (int i = idMin; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getDepartment() == numDepart && empl[i].getSalary() < min) {
                min = empl[i].getSalary();
                idMin = i;
            }
        }
        return idMin;
    }


    public int getIdMaxSalDepartment(int numDepart) { // определяем id сотрудника с МАКСимальной з/п в отделе
        if (!isExistDep(numDepart)) {
            System.out.println("Такого отдела нет");
            throw new RuntimeException();
        }
        int idMax = getFirstIdDepart(numDepart);
        int max = empl[idMax].getSalary();

        for (int i = idMax; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getDepartment() == numDepart && empl[i].getSalary() > max) {
                max = empl[i].getSalary();
                idMax = i;
            }
        }
        return idMax;
    }


    public int calcDepartCostsPerMonth(int numDepart) { // считаем сумму затрат на зарплаты в месяц по отделу
        if (!isExistDep(numDepart)) {
            System.out.println("Такого отдела нет");
            throw new RuntimeException();
        }
        int idFirst = getFirstIdDepart(numDepart);
        int sum = 0;
        countNotNullDep = 0;
        for (int i = idFirst; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getDepartment() == numDepart) {
                sum += empl[i].getSalary();
                countNotNullDep++;
            }
        }
        return sum;
    }


    public double calcMiddleSalaryDep(int numDepart) { // считаем среднюю з/п по отделу
        int sum = calcDepartCostsPerMonth(numDepart);
        double midSalary = (double) sum / countNotNullDep;
        return midSalary;
    }

    public void indexDepartSalaries(int numDepart, int percent) { // индексируем  зарплаты отдела на величину percent в %
        if (!isExistDep(numDepart)) {
            System.out.println("Такого отдела нет");
            throw new RuntimeException();
        }
        int idFirst = getFirstIdDepart(numDepart);
        int t;
        for (int i = idFirst; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getDepartment() == numDepart) {
                t = empl[i].getSalary();
                empl[i].setSalary(t + t * (int) percent / 100);
            }
        }
    }

    public void printDepartEmployees(int numDepart) { // печатаем данные  сотрудников отдела
        if (!isExistDep(numDepart)) {
            System.out.println("Такого отдела нет");
            throw new RuntimeException();
        }
        int idFirst = getFirstIdDepart(numDepart);
        for (int i = idFirst; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getDepartment() == numDepart) {
                System.out.println("id-" + empl[i].getId() + ", " + empl[i].getName() + ", з/п- " + empl[i].getSalary() + " руб./мес.");
            }
        }
    }

    public void printSalaryLessThan(int smallSalary) { // выводим сотрудников с меньшей з/п
        System.out.println("************  Работники с зарплатой меньше, чем " + smallSalary + " руб./мес.  ****  ");
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getSalary() < smallSalary) {
                System.out.println("id-" + empl[i].getId() + ", " + empl[i].getName() + ", з/п- " + empl[i].getSalary() + " руб./мес.");
            }
        }
    }


    public void printSalaryBiggerThan(int bigSalary) { // выводим сотрудников с бОльшей з/п
        System.out.println("************  Работники с зарплатой больше, чем " + bigSalary + " руб./мес.  ****  ");
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getSalary() >= bigSalary) {
                System.out.println("id-" + empl[i].getId() + ", " + empl[i].getName() + ", з/п- " + empl[i].getSalary() + " руб./мес.");
            }
        }
    }
// --------------------------------------------------------------------------------
    // ----------   методы задания сложно-сложно  ---------------------------------
// --------------------------------------------------------------------------------

    public void addNewEmployee(String name, int numDepart, int salary) { // +++++ Добавляем нового сотрудника +++++
        boolean isEmptyCell = false;
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] == null) {
                empl[i] = new Employee(name, numDepart, salary);
                isEmptyCell = true;
                break;
            }
        }
        if (!isEmptyCell) {
            System.out.println("!!!  НЕТ ПУСТОЙ ЯЧЕЙКИ МАССИВА. ЗАПИСАТЬ НОВОГО СОТРУДНИКА НЕВОЗМОЖНО !!!");
        }
    }

    public void deleteEmployeeById(int id) { // ------ Удаляем сотрудника по id ------
        boolean isId = false;
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getId() == id) {
                empl[i] = null;
                isId = true;
                break;
            }
        }
        if (!isId) {
            System.out.println("!!! СОТРУДНИК НЕ НАЙДЕН. УДАЛЕНИЕ НЕВОЗМОЖНО !!!");
        }
    }

    public int getIdEmployeeByName(String name) { // ------ Находим сотрудника по Ф.И.О.
        int id = -1;
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getName() == name) {
                id = i;
                break;
            }
        }
        return id;
    }

    public void deleteEmployeeByName(String name) { // ------ Удаляем сотрудника по Ф.И.О. ------
        int i = getIdEmployeeByName(name);
        if (i == -1) {
            System.out.println("!!! СОТРУДНИК НЕ НАЙДЕН. УДАЛЕНИЕ НЕВОЗМОЖНО !!!");
            return;
        }
        empl[i] = null;
    }

    public void changeEmployeeSalary(String name, int salary) { // Изменяем з/п сотрудника, найдя его по Ф.И.О.
        int i = getIdEmployeeByName(name);
        if (i == -1) {
            System.out.println("!!! СОТРУДНИК НЕ НАЙДЕН !!!");
            return;
        }
        empl[i].setSalary(salary);
    }

    public void changeEmployeeDepartment(String name, int dep) { // Изменяем у сотрудника отдел, найдя его по Ф.И.О.
        int i = getIdEmployeeByName(name);
        if (i == -1) {
            System.out.println("!!! СОТРУДНИК НЕ НАЙДЕН !!!");
            return;
        }
        empl[i].setDepartment(dep);
    }

    public void changeDepartment(int oldDep, int newDep) { // Переводим всех сотрудников одного отдела в другой
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getDepartment()== oldDep) {
                empl[i].setDepartment(newDep);
            }
        }
    }

    public void printEmployeeShort(int idTemp) { // печатаем информацию о сотруднике
        if (idTemp >= 0 && idTemp < empl.length) {
            System.out.println(empl[idTemp].getName() + ", з/п- " + empl[idTemp].getSalary());
        } else {
            System.out.println("Такого сотрудника нет");
        }
    }

    public void printDepartment(int dep) { // печатаем всех сотрудников конкретного отдела
        for (int i = 0; i < empl.length; i++) {
            if (empl[i] != null && empl[i].getDepartment() == dep) {
                System.out.println(empl[i].getName());
            }
        }
    }

    public void printAllDepartments() { // печатаем  сотрудников по отделам
        int num = 1;
        while (num <= numDep) {
            if (isExistDep(num)) {
                System.out.println("++++   Сотрудники отдела " + num + " :   +++++++++++++++");
            }
            for (int i = 0; i < empl.length; i++) {
                if (empl[i] != null && empl[i].getDepartment() == num) {
                    System.out.println(empl[i].getName());
                }
            }
            num++;
        }
    }

}





