package doit.core.examples.jaxb;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Anatoly
 */
public class JaxbParser {
    public static void saveObject(String file, Object o){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
            javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(o, new File(file));
        } catch (JAXBException e){
            System.out.println("Oooooooops! Something happen wrong :-(");
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    public static Object getObject(String file, Class c){
        Object object = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(c);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            object = jaxbUnmarshaller.unmarshal(new File(file));
        } catch (JAXBException e){
            System.out.println("Oooooooops! Something happen wrong :-(");
            System.out.println(e);
            e.printStackTrace();
        }
        return object;
    }
}
