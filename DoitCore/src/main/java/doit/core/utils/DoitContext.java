package doit.core.utils;

import doit.core.entites.DoitProject;
import doit.core.entites.DoitTask;
import doit.core.entites.DoitUser;
import doit.core.examples.jaxb.JaxbParser;
import doit.core.examples.jaxb.UsersList;
import doit.core.exceptions.DoitAuthorizationException;
import doit.core.exceptions.DoitException;
import java.io.FileNotFoundException;

/**
 * Created by Almaz on 16.08.2015.
 */
public class DoitContext {
    private UsersList users;

    private DoitContext(){
        this.users = new UsersList();
        
        try {
            this.loadAll();
        } catch (FileNotFoundException e) {
            System.out.println(e);
            System.out.println("Created new file");
            this.saveAll();
        }
    }

    private static class DoitContextHandler{
        public static final DoitContext DOIT_CONTEXT = new DoitContext();
    }

    public static DoitContext getInstance(){
        return DoitContextHandler.DOIT_CONTEXT;
    }

    /***
     * TODO:
     *  В будущем это все заменится на обращение к базе
     *  или к другому источнику данных.
     *
     *  Сейчас это подпертый-костыль, поскольку база еще не готова
     *
     * @param login
     * @param pass
     * @return
     * @throws doit.core.exceptions.DoitAuthorizationException
     */
    @Deprecated
    public DoitUser authorize(String login, String pass)throws DoitAuthorizationException{
        DoitUser user = authorizeNoThrow(login, pass);
        if(user != null)
            return user;

        throw new DoitAuthorizationException("Authorization failed. Invalid login or password");
    }
    
    private DoitUser authorizeNoThrow(String login, String password){
        for (DoitUser user: users.getUserList())
            if(user.getLogin().equals(login) &&
                    user.getPassword().equals(password))
                return user;
        return null;
    }
    
    /***
     * TODO:
     *      Подперый костыль :-(
     * @param userName
     * @param pass
     * @return
     * @throws doit.core.exceptions.DoitException
     */
    @Deprecated
    public DoitUser register(String userName, String pass) throws DoitException{
        for (DoitUser user: users.getUserList())
            if(user.getLogin().equals(userName))
                throw new DoitException("Registration failed. User is already exists");
        this.users.getUserList().add(new DoitUser(userName, pass));
        return authorize(userName, pass);
    }

    /***
     * TODO: Исправить костыль :-)
     * @param user
     * @param projectName
     * @return
     * @throws DoitException
     */
    @Deprecated
    public DoitProject createProject(DoitUser user, String projectName) throws DoitException{
        DoitUser actualUser = authorizeNoThrow(user.getLogin(), user.getPassword());

        if (actualUser != null){
            if (getProject(actualUser, projectName) == null){
                DoitProject project = new DoitProject(projectName);
                actualUser.getProjects().add(project);
                return project;
            }
            else throw new DoitException("Project already exists");
        }
        throw new DoitException("User is not authorized!");
    }
    
    public void deleteProject(DoitUser user, String projectName) throws DoitException{
        DoitUser actualUser = authorizeNoThrow(user.getLogin(), user.getPassword());
        
        if (actualUser != null){
            DoitProject project = getProject(actualUser, projectName);
            if (project != null)
                actualUser.getProjects().remove(project);
            else throw new DoitException("Project does not exists");
        }
        else
            throw new DoitException("User is not authorized!");
    }
    
    public DoitProject getProject(DoitUser user, String projectName) throws DoitException{
        DoitUser actualUser = authorizeNoThrow(user.getLogin(), user.getPassword());
        
        if (actualUser != null){
            for (DoitProject pr : user.getProjects())
                if (pr.getName().equals(projectName))
                    return pr;
            return null;
        }
        throw new DoitException("User is not authorized!");
    }
    
    public DoitTask getTask(DoitUser user, DoitProject project, String taskName) throws DoitException{
        DoitUser actualUser = authorizeNoThrow(user.getLogin(), user.getPassword());
        
        if (actualUser != null){
            for (DoitTask t : project.getProjectTasks()){
                if (t.getName().equals(taskName))
                    return t;
            }
            return null;
        }
        throw new DoitException("User is not authorized!");
    }
    
    public DoitTask createTask(DoitUser user, DoitProject project, String taskName) throws DoitException{
        DoitUser actualUser = authorizeNoThrow(user.getLogin(), user.getPassword());

        if(actualUser != null){
            if (project != null){
                if (getTask(actualUser, project, taskName) == null){
                    DoitTask task = new DoitTask(taskName);
                    project.addTask(task);
                    return task;
                }
                else throw new DoitException("Task already exists");
            }
            else throw new DoitException("Project does not exists");
        }
        throw new DoitException("User is not authorized!");
    }
    
    public void removeTask(DoitUser user, String projectName, String taskName) throws DoitException{
        DoitUser actualUser = authorizeNoThrow(user.getLogin(), user.getPassword());

        if(actualUser != null){
            DoitProject project = getProject(actualUser, projectName);
            if (project != null){
                DoitTask task = getTask(actualUser, project, taskName);
                if (task != null){
                    project.removeTask(task);
                }
                else throw new DoitException("Task does not exists");
            }
            else throw new DoitException("Project does not exists");
        }
        else
            throw new DoitException("User is not authorized!");
    }
    
    public void saveAll(){
        JaxbParser.saveObject("users.xml", users);
    }
    
    public void loadAll() throws FileNotFoundException{
        users = (UsersList) JaxbParser.getObject("users.xml", UsersList.class);
    }
}
