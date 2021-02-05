package jpsave.airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainTestStream {
    public static void main(String[] args) {

        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");

        List<Employee> resultats;
        List<Employee> employees = new ArrayList<Employee>(Arrays.asList(e5, e4, e3, e2, e1, e6, e7, e8, e9, e10));


        resultats = employees.stream()
                .filter(e -> e.age < 30)
                .map(e -> new Employee(e.id, e.age+100, e.sexe, e.prenom, e.nom))
                .peek(e -> e.sexe="?")
                .sorted()
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Nb résultats = " + resultats.stream().count() + "/" + employees.size());
        resultats.forEach(System.out::println);
    }
}

class Employee implements Comparable<Employee> {

    public int id;
    public int age;
    public String sexe;
    public String prenom;
    public String nom;

    public Employee(int id, int age, String sexe, String prenom, String nom) {
        this.id = id;
        this.age = age;
        this.sexe = sexe;
        this.prenom = prenom;
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", age=" + age + ", sexe=" + sexe + ", prenom=" + prenom + ", nom=" + nom + "]";
    }

    @Override
    public int compareTo(Employee e) {
        return this.id - e.id;
    }
}

