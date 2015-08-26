package doit.core.examples.jaxb;

import doit.core.entites.*;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Date;


/**
 * Created by Almaz on 23.08.2015.
 */
public class MarshallerExample {
    @Test
    public void test() {
        DoitUser almaz = new DoitUser("Almaz","my_secret_password",
                "muktaalmaz@yandex.ru", "Almaz", "Murzabekov");

        DoitProject firstProject = new DoitProject("First project");
        firstProject.setDescription("This is description for first project");
        DoitTask firstTaskFP = new DoitTask("First task for first project");
        DoitTask secondTaskFP = new DoitTask("Second task for first project");
        firstTaskFP.setPriority(DoitTaskPriority.PRIORITY_4);
        firstTaskFP.setDescription("This is description for first task");

        DoitAttachment da = new DoitAttachment("Some my attachment", new File("."));
        firstTaskFP.addAttachment(da);
        firstTaskFP.setStartDate(new Date());
        firstTaskFP.setFinishDate(new Date());

        firstProject.addTask(firstTaskFP);
        firstProject.addTask(secondTaskFP);

        DoitProject secondProject = new DoitProject("Second project");
        secondProject.setDescription("This is description for second project");
        DoitTask firstTaskSP = new DoitTask("First task for second project");
        DoitTask secondTaskSP = new DoitTask("Second task for second project");
        secondProject.addTask(firstTaskSP);
        secondProject.addTask(secondTaskSP);


        almaz.getProjects().add(firstProject);
        almaz.getProjects().add(secondProject);

        JaxbParser parser = new JaxbParser();
        parser.saveObject("user.xml", almaz);
        //DoitUser newUser = (DoitUser) parser.getObject(file, DoitUser.class);
    }
}
