package ru.skypro;

// ======== Курсовая работа  ========
public class Main {

    public static void main(String[] args) {
        EmployeeBook book =  new EmployeeBook();
        book.main();

        book.printAllEmplInform();
        int costs = book.calcCostsPerMonth();
        System.out.println("Сумма затрат на зарплаты составляет " + costs + " руб./мес.");
        int idMin = book.getIdOfMinSalary();
        System.out.println(" === Сотрудник с минимальной з/п: ===");
        book.printEmployee(idMin);
        int idMax = book.getIdOfMaxSalary();
        System.out.println(" === Сотрудник с МАКСимальной з/п: ===");
        book.printEmployee(idMax);
        double salaryMiddle = book.calcMiddleSalary();
        System.out.println("*** Средняя зарплата в коллективе " + salaryMiddle + " руб./мес. ***");
        System.out.println("------------------------------------------------------");

        book.printAllNames();

        int indexPercent = 15;
        book.indexAllSalaries(indexPercent);
        System.out.println("Индексируем зарплаты на " + indexPercent + " %");
        System.out.println(" === Печатаем данные сотрудников с индексированными зарплатами ===");
        book.printAllEmplInform();

        int numDepartment = 2;
        System.out.println(" === Сотрудник с минимальной з/п в отделе " + numDepartment + ": ===");
        idMin = book.getIdMinSalDepartment(numDepartment);
        book.printEmployee(idMin);

        System.out.println(" === Сотрудник с МАКСимальной з/п в отделе " + numDepartment + ": ===");
        idMax = book.getIdMaxSalDepartment(numDepartment);
        book.printEmployee(idMax);

        costs = book.calcDepartCostsPerMonth(numDepartment);
        System.out.println("Сумма затрат на зарплаты по " + numDepartment + " отделу составляет " + costs + " руб./мес.");
        double salaryMiddleDep = book.calcMiddleSalaryDep(numDepartment);
        System.out.println("*** Средняя зарплата сотрудников в " + numDepartment + " отделе-"  + salaryMiddleDep + " руб./мес. ***");
        System.out.println("------------------------------------------------------");

        indexPercent = 10;
        numDepartment = 5;
        book.indexDepartSalaries(numDepartment, indexPercent);
        System.out.println("Индексируем зарплаты отдела " + numDepartment + " на " + indexPercent + " %");
        System.out.println(" === Печатаем данные сотрудников отдела с индексированными зарплатами ===");
        book.printDepartEmployees(numDepartment);

        int salary = 77000;
        book.printSalaryLessThan(salary);
        book.printSalaryBiggerThan(salary);

        String name = "Кулебякин Кузьма Паустович";
        int department = 3;
        salary = 154000;
        System.out.println("Добавляем нового сотрудника:");
        book.addNewEmployee(name,department,salary);
        book.printAllEmplInform();

        int deleteEmployeeId = 1;
        System.out.println("--------------  Удаляем сотрудника по id-" + deleteEmployeeId + " ----------");
        book.deleteEmployeeById(deleteEmployeeId);
        book.printAllEmplInform();

        String deleteEmployeeName = "Шарипова Оксана Снежановна";
        System.out.println("--------------  Удаляем сотрудника по Ф.И.О.-" + deleteEmployeeName + " ----------");
        book.deleteEmployeeByName(deleteEmployeeName);
        book.printAllEmplInform();

        salary = 82_000;
        name = "Крылов Олег Николаевич";
        System.out.println("*******   Изменяем сотруднику з/п. Было: ********");
        int id = book.getIdEmployeeByName(name);
        book.printEmployeeShort(id);
        book.changeEmployeeSalary(name,salary);
        System.out.println("*******   СТАЛО:   ********");
        book.printEmployeeShort(id);

        name = "Потапов Евгений Сергеевич";
        department = 3;
        System.out.println("Переводим сотрудника " + name + " в отдел " + department);
        book.changeEmployeeDepartment(name,department);
        book.printEmployee(book.getIdEmployeeByName(name));
        System.out.println("======    Все сотрудники отдела " + department + ":   ======");
        book.printDepartment(department);
        department = 2;
        System.out.println("======    Переводим их в отдел " + department + ":   ======");
        System.out.println("======   Теперь в отделе " + department + " следующие сотрудники:   ======");
        book.changeDepartment(3, department);
        book.printDepartment(department);
        book.printAllDepartments();
    }
}
