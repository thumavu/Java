package main.java.co.za.sizwe;

import com.sun.org.apache.xerces.internal.impl.PropertyManager;
import com.sun.org.apache.xerces.internal.impl.XMLStreamReaderImpl;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Mashaller {
    public static JAXBContext jaxbContext;

    public static void main(String[] args) throws JAXBException {
        StudentMarks studentMarks = new StudentMarks();
        studentMarks.setName("Sizwe");
        studentMarks.setSurname("Mavuso");
        studentMarks.setMarks("100%");
        jaxbContext = JAXBContext.newInstance(StudentMarks.class);
        jaxbObjectXML(studentMarks);
        jaxbXMLtoObj();
    }

    private static void jaxbObjectXML(StudentMarks studentMarks) {
        try {
            File file = new File("Marks.xml");
            Marshaller jaxMarshaller =  jaxbContext.createMarshaller();


            jaxMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxMarshaller.marshal(studentMarks,System.out);
            jaxMarshaller.marshal(studentMarks,file);
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void jaxbXMLtoObj() {
        try {
            File file = new File("Marks.xml");
            XMLStreamReader reader = new XMLStreamReaderImpl(new FileInputStream(file), new PropertyManager(PropertyManager.CONTEXT_READER));
            Unmarshaller unmarshaller =  jaxbContext.createUnmarshaller();
            StudentMarks unmarshal = (StudentMarks) unmarshaller.unmarshal(reader);
            System.out.println(unmarshal);

        }
        catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
