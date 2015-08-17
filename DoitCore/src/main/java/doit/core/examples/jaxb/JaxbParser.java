package doit.core.examples.jaxb;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Anatoly
 */
public class JaxbParser {
    public void saveObject(File file, Object o){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
            javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(o, file);
        } catch (JAXBException e){
            System.out.println("Oooooooops! Something happen wrong :-(");
            System.out.println(e);
            e.printStackTrace();
        }
    }
    
    public Object getObject(File file, Class c){
        Object object = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(c);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            object = jaxbUnmarshaller.unmarshal(file);
        } catch (JAXBException e){
            System.out.println("Oooooooops! Something happen wrong :-(");
            System.out.println(e);
            e.printStackTrace();
        }
        return object;
    }
}
