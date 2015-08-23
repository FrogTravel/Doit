package doit.core.dao;

import doit.core.entites.DoitTask;
import doit.core.entites.DoitTaskPriority;
import doit.core.entites.DoitTaskStatus;
import doit.core.entites.DoitUser;
import doit.core.exceptions.DoitDatabaseException;

import java.util.List;

/**
 * Created by Almaz on 23.08.2015.
 */
public interface DoitTaskDAO {
    public void insert(DoitTask task, DoitUser user) throws DoitDatabaseException;

    public DoitTask findById(int id) throws DoitDatabaseException;
    public DoitTask findByName(String name) throws DoitDatabaseException;
    public List<DoitTask> findByUser(DoitUser user) throws DoitDatabaseException;

    public DoitTask delete(DoitTask task);

    public DoitTask updateStatus(DoitTask task, DoitTaskStatus status);
    public DoitTask updatePriority(DoitTask task, DoitTaskPriority priority);
    public DoitTask updateTask(DoitTask task, String columnName, String newValue);
    public DoitTask update(DoitTask oldTask, DoitTask newTask);
}
