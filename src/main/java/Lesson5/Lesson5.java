package Lesson5;

public class Lesson5 {
    public static void main(String[] args) {

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Andrey","engineer","andrey@ya.ru",89503582565L,40000, 32);
        employees[1] = new Employee("Roman","designer","roman@ya.ru",89665208535L,30000, 28);
        employees[2] = new Employee("Dmitry","cleaner","dmitry@ya.ru",89102507524L,20000, 52);
        employees[3] = new Employee("Mihail","director","mihail@ya.ru",89155602016L,60000, 47);
        employees[4] = new Employee("Anton","manager","anton@ya.ru",89194307841L,35000, 31);

        for (Employee employe: employees) {
            if (employe.getAge()>40)
                System.out.println(employe);
        }
    }
}
