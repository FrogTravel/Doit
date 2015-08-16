package doit.core.entites;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO: Fix encoding bug, please
 * Информация о пользователе
 * @author Anatoly
 */
@XmlRootElement(name = "user")
@XmlType(name="", propOrder={"firstName", "secondName", "email", "password", "projects"})
public class DoitUser {
    /** Имя */
    private String login;
    /** Пароль */
    private String password;
    /** E-mail */
    private String email;

    private String firstName;
    private String secondName;

    private List<DoitAbstractTask> projects;


    /**
     * TODO: encoding fix need there!
     * Установка основной информации о пользователе
     * @param password Пароль
     * @param name Имя
     * @param e_mail E-mail
     */
    public DoitUser(String name, String password, String e_mail) {
        this.login = name;
        this.password = password;
        this.email = e_mail;
        this.projects = new ArrayList<DoitAbstractTask>();
    }


    public DoitUser() {
        this.projects = new ArrayList<DoitAbstractTask>();
    }

    public DoitUser(String login) {
        this.login = login;
        this.projects = new ArrayList<DoitAbstractTask>();
    }

    public void addTask(DoitAbstractTask task){
        this.projects.add(task);
    }
    public List<DoitAbstractTask> getProjects() {
        return projects;
    }


    public String getLogin() {
        return login;
    }

    @XmlAttribute(name = "login")
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }
    @XmlElement (name = "password")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    @XmlElement (name = "email")
    public void setEmail(String email) {
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }
    @XmlElement (name = "firstName")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    @XmlElement (name = "secondName")
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @XmlElementWrapper(name = "projects")
    @XmlElement(name = "project")
    public void setProjects(List<DoitAbstractTask> projects) {
        this.projects = projects;
    }

}
