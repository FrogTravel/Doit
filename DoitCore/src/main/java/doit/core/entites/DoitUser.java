package doit.core.entites;


import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Anatoly
 */
@XmlRootElement(name = "user")
@XmlType(name="", propOrder={"firstName", "secondName", "email", "password", "projects"})
public class DoitUser {


    private Integer userId;
    private String login;
    private String password;
    private String email;

    private String firstName;
    private String secondName;

    private List<DoitProject> projects;

    public DoitUser(Integer userId) {
        this.userId = userId;
    }

    public DoitUser(String login, String password, String eMail) {
        this.login = login;
        this.password = password;
        this.email = eMail;
        this.projects = new ArrayList<>();
    }

    public DoitUser(String login, String password) {
        this.login = login;
        this.password = password;
        this.projects = new ArrayList<>();
    }

    public DoitUser(String login, String password, String email, String firstName, String secondName) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.projects = new ArrayList<>();
    }

    public DoitUser() {
        this.projects = new ArrayList<>();
    }

    public DoitUser(String login) {
        this.login = login;
        this.projects = new ArrayList<>();
    }

    public List<DoitProject> getProjects() {
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
    public void setProjects(List<DoitProject> projects) {
        this.projects = projects;
    }

    public Integer getUserId() {
        return userId;
    }
}
