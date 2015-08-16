package doit.core.examples.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

/**
 *
 * @author Anatoly
 */
public class JaxbParser {
    public void saveObject(Object o){
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(o.getClass());
            javax.xml.bind.Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(o, System.out);
        } catch (JAXBException e){
            System.out.println("Oooooooops! Something happen wrong :-(");
            System.out.println(e);
            e.printStackTrace();
        }
    }
   
}
