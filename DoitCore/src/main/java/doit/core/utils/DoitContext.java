package doit.core.utils;

import doit.core.entites.DoitProject;
import doit.core.entites.DoitUser;
import doit.core.exceptions.DoitAuthorizationException;
import doit.core.exceptions.DoitException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Almaz on 16.08.2015.
 */
public class DoitContext {
    private List<DoitUser> users;

    private DoitContext(){
        this.users = new ArrayList<DoitUser>();

        this.users.add(new DoitUser("demo", "1234"));
        this.users.add(new DoitUser("super", "4321"));
        this.users.add(new DoitUser("hacker", "hacker"));
    }

    private static class DoitContextHandler{
        public static final DoitContext DOIT_CONTEXT = new DoitContext();
    }

    public static DoitContext getInstance(){
        return DoitContextHandler.DOIT_CONTEXT;
    }

    /***
     * TODO:
     *  В будущем это все замениться на обращение к базе
     *  или к другому источнику данных.
     *
     *  Сейчас это подпертый-костыль, поскольку база еще не готова
     *
     * @param login
     * @param pass
     * @return
     */
    @Deprecated
    public DoitUser authorize(String login, String pass)throws DoitAuthorizationException{
        DoitUser user = authorizeNoThrow(login, pass);
        if(user != null)
            return user;

        throw new DoitAuthorizationException("Authorization failed. Invalid login or password");
    }
    private DoitUser authorizeNoThrow(String login, String password){
        for (DoitUser user: users)
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
     */
    @Deprecated
    public DoitUser register(String userName, String pass) throws DoitException{
        this.users.add(new DoitUser(userName, pass));
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

        if(actualUser != null){
            DoitProject project = new DoitProject(projectName);
            actualUser.getProjects().add(project);
            return project;
        }
        throw new DoitException("User is not authorized!");
    }
    public void deleteProject(DoitUser user, String projectName) throws DoitException{
        DoitUser actualUser = authorizeNoThrow(user.getLogin(), user.getPassword());

        if(actualUser != null){
            for (DoitProject pr : actualUser.getProjects()) {
                if(pr.getName().equals(projectName))
                    actualUser.getProjects().remove(pr);
            }
        }
        else
            throw new DoitException("User is not authorized!");
    }
}
