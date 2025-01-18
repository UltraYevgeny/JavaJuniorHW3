import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

/**
 * @author Пинжин Евгений Иванович
 * @apiNote Программа сохраняет (сериализует) и читает экземпляр класса Student
 * @version 1.1
 */
public class App {
    //ObjectMapper - работает с json
    public static final ObjectMapper objectMapper = new ObjectMapper();
    //XmlMapper - работает с xml
    public static final XmlMapper xmlMapper = new XmlMapper();

    public static void main(String[] args) {

        /*
        в файле Student должны быть геттеры - иначе не работает!!!
         */
        Student studentForWrite = new Student("Tom", 41, 5.5);
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("studentFile.bin"));
            oos.writeObject(studentForWrite);
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File("studentFile.json"), studentForWrite);
            xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            xmlMapper.writeValue(new File("studentFile.xml"), studentForWrite);
            System.out.println("файлы созданы.\n");

        } catch (IOException e){
            e.printStackTrace();
        }


        Student studentForRead1 = new Student();
        Student studentForRead2 = new Student();
        Student studentForRead3 = new Student();
        try {
                /*
                    objectMapper.getTypeFactory().constructType(Student.class)
                    указываем какой тип данных хотим получить
                */
            //в файле Student должны быть сеттеры - иначе не работает!!!
                studentForRead1 = objectMapper.readValue(new File("studentFile.json"),
                        objectMapper.constructType(Student.class));

                //bin уже содержит информацию о том какой тип данных хранится в файле (это Student.class)
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("studentFile.bin"));
                studentForRead2 = (Student) ois.readObject();

                studentForRead3 = xmlMapper.readValue(new File("studentFile.xml"),
                        xmlMapper.constructType(Student.class));
        } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }

        System.out.println("считанные файлы: ");
        System.out.println(studentForRead1);
        System.out.println(studentForRead2);
        System.out.println(studentForRead3);

    }
}
