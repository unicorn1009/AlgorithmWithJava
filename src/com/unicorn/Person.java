package com.unicorn;

import java.util.Objects;

/**
 * <p>
 * </p>
 * Created on 2021-7-24.
 *
 * @author Unicorn
 */
public class Person {
    private int age;
    private double salary;
    private long time;
    private String name;
    private String department;
    private boolean isAdult;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age
                && Double.compare(person.salary, salary) == 0
                && time == person.time
                && isAdult == person.isAdult
                && Objects.equals(name, person.name)
                && Objects.equals(department, person.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, salary, time, name, department, isAdult);
    }

    public Person(int age, String name, String department, double salary, boolean isAdult) {
        this.age = age;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.isAdult = isAdult;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }
}
