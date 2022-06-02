package Lesson5;

public class Employee {
    private String fullName;
    private String position;
    private String email;
    private long phoneNumber;
    private int salary;
    private int age;

    public Employee(String fullName, String position, String email, long phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo(){
        System.out.println(this);
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("ФИО сотрудника: "+ fullName+", должность: "+position+", email: "+email+
                ", номер телефона: "+ phoneNumber+", зарплата: "+salary+", возраст: "+ age);
    }
}
