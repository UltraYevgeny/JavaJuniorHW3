import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class App {
    //ObjectMapper - работает с json
    public static final ObjectMapper objectMapper = new ObjectMapper();
    //XmlMapper - работает с xml
    public static final XmlMapper xmlMapper = new XmlMapper();

    public static void main(String[] args) {
        Student student = new Student("Tom", 41, 5.5);

        try {
            //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("studentFile.bin"));
            //oos.writeObject(student);

            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File("studentFile.json"), student);
            //xmlMapper.writeValue(new File("studentFile.xml"), student);


        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
