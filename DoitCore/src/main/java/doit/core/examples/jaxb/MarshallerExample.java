package doit.core.examples.jaxb;

import doit.core.entites.DoitAttachment;
import doit.core.entites.DoitProject;
import doit.core.entites.DoitTask;
import doit.core.entites.DoitUser;
import java.io.File;
import java.util.Date;

/**
 * Created by almu0214 on 12.08.2015.
 *
 * TODO: Description here please!
 */
public class MarshallerExample {
    public static void main(String[] args) {
        DoitUser almaz = new DoitUser("Almaz");
        almaz.setFirstName("Almaz");
        almaz.setSecondName("Murzabekov");
        almaz.setEmail("muktaalmaz@yandex.ru");
        almaz.setPassword("my_secret_password");

        DoitProject firstProject = new DoitProject("First project");
        firstProject.setDescription("This is description for first project");
        DoitTask firstTaskFP = new DoitTask("First task for first project");
        DoitTask secondTaskFP = new DoitTask("Second task for first project");
        firstProject.addTask(firstTaskFP);
        firstProject.addTask(secondTaskFP);

        DoitProject secondProject = new DoitProject("Second project");
        secondProject.setDescription("This is description for second project");
        DoitTask firstTaskSP = new DoitTask("First task for second project");
        DoitTask secondTaskSP = new DoitTask("Second task for second project");
        firstProject.addTask(firstTaskSP);
        firstProject.addTask(secondTaskSP);
        
        firstTaskFP.setImpDeg((short)4);
        firstTaskFP.setDescription("This is description for first task");
        Date d = new Date(500);
        firstTaskFP.setStartDate(d);
        firstTaskFP.setFinishDate(d);
        
        DoitAttachment da = new DoitAttachment();
        da.setName("file.txt");
        
        firstTaskFP.addAttachment(da);

        almaz.addTask(firstProject);
        almaz.addTask(secondProject);

        JaxbParser parser = new JaxbParser();
        
        parser.saveObject(almaz);
        parser.saveObject(firstTaskFP);
        parser.saveObject(firstProject);
        parser.saveObject(da);
        
    }
}
