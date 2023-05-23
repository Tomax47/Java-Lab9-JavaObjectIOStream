import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        Person person = mapper.readValue(new File("D:\\Java Projects\\Lab9-JavaObjectIOStream\\src\\main\\java\\person.json"), Person.class);
        System.out.println("Person's data : \n"+person);

        System.out.println();
        Person newPerson = new Person("Luka Sanches","Kazan, str. Bauman", new Date(20-02-2000),false,0);
        writeReadDate("D:\\Java Projects\\Lab9-JavaObjectIOStream\\src\\main\\java\\person.json",newPerson);

        System.out.println("Actors task\n");
        printOutActors("D:\\Java Projects\\Lab9-JavaObjectIOStream\\src\\main\\java\\actors.json");

        System.out.println("\nSecond task : \n");
        String text = "Hello, Im Tommy the little machine!";
        String textFilePath = "D:\\Java Projects\\Lab9-JavaObjectIOStream\\src\\main\\java\\simpleText.json";
        writeSimpleText(textFilePath,text);
        readSimpleText(textFilePath);

        System.out.println("\nBinary data : \n");
        byte[] binaryData = { 0x48, 0x65, 0x6C, 0x6C, 0x6F };
        String binaryFilePath = "D:\\Java Projects\\Lab9-JavaObjectIOStream\\src\\main\\java\\binaryData.json";
        writeBinaryData(binaryFilePath,binaryData);
        readBinaryData(binaryFilePath);


    }

    public static void writeReadDate(String jsonFilePath, Person person) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {

            objectMapper.writeValue(new File(jsonFilePath),person);

            Person newPerson = objectMapper.readValue(new File(jsonFilePath), Person.class);

            System.out.println("Person's data : \n"+newPerson.toString());

        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void printOutActors(String jsonFilePath) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            List<Person> actors = objectMapper.readValue(new File(jsonFilePath), new TypeReference<List<Person>>() {});

            System.out.println("Actors : \n"+actors);

        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeSimpleText(String jsonFilePath, String text) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            String simpleText = text;
            mapper.writeValue(new File(jsonFilePath),simpleText);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readSimpleText(String jsonFilePath) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String output = mapper.readValue(new File(jsonFilePath),String.class);
            System.out.println("Text : \n"+output);
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeBinaryData(String jsonFilePath, byte[] binaryData) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(new File(jsonFilePath),binaryData);
        } catch (StreamWriteException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readBinaryData(String jsonFilePath) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            byte[] binaryData = mapper.readValue(new File(jsonFilePath),byte[].class);
            for (byte binary : binaryData) {
                System.out.print(binary+" ");
            }
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
