import java.io.*;

public class Student implements Serializable {
    private String name;
    private int age;
    transient double GPA;

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

}

