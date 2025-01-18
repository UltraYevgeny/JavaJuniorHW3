
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;

import java.io.*;

public class Student implements Serializable {
    private static final long serialVersionUID = 1001;
    private String name;
    private int age;
    //transient - при сериализации в bin файл, это поле не берется
    private transient double GPA;

    public Student(){}

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    @JsonIgnore //анотация нужна что бы это поле не сохранялось в файлы .json и .xml
    public double getGPA() {
        return GPA;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }
}

