package doit.core.dao;

import doit.core.entites.DoitTask;
import doit.core.entites.DoitTaskPriority;
import doit.core.entites.DoitTaskStatus;
import doit.core.entites.DoitUser;
import doit.core.exceptions.DoitDatabaseException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Almaz on 23.08.2015.
 */
public class DoitTaskDAOImpl implements DoitTaskDAO {
    private DataSource dataSource;
    private SimpleDateFormat dateFormat;

    public DoitTaskDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.dateFormat = new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
    }

    public DoitTaskDAOImpl(DataSource dataSource, SimpleDateFormat dateFormat) {
        this.dataSource = dataSource;
        this.dateFormat = dateFormat;
    }

    @Override
    public void insert(DoitTask task, DoitUser user) throws DoitDatabaseException{
        String sql = "INSERT INTO TASKS (" +
                "PROJECT_ID, " +
                "USER_ID, " +
                "NAME," +
                "DESCRIPTION" +
                "PRIORITY" +
                "STATUS" +
                "ATTACHMENT" +
                "START_DATE" +
                "END_DATE" +
                "TASK_TYPE)" +
            "VALUES (" +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try {
            NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(dataSource);
            Map<String, String> namedParameters = new HashMap<>();
            namedParameters.put("PROJECT_ID", "1");
            namedParameters.put("USER_ID", "1");
            namedParameters.put("NAME", task.getName());
            namedParameters.put("DESCRIPTION", task.getDescription());
            namedParameters.put("PRIORITY", task.getPriority().name());
            namedParameters.put("STATUS", task.getStatus().name());
            namedParameters.put("ATTACHMENT", task.getStatus().name());
            namedParameters.put("START_DATE", dateFormat.format(task.getStartDate()));
            namedParameters.put("END_DATE", dateFormat.format(task.getFinishDate()));
            namedParameters.put("TASK_TYPE", "T");

            template.update(sql, namedParameters);

        }catch (DataAccessException e){
            throw new DoitDatabaseException("Something wrong with DB connection", e);
        }
    }

    // TODO:
    @Override
    public DoitTask findById(int id) {
        throw new UnsupportedOperationException("Operation not supported yet");
    }

    @Override
    public DoitTask findByName(String name) throws DoitDatabaseException {
        return null;
    }

    @Override
    public List<DoitTask> findByUser(DoitUser user) throws DoitDatabaseException {
        return null;
    }

    @Override
    public DoitTask delete(DoitTask task) {
        return null;
    }

    @Override
    public DoitTask updateStatus(DoitTask task, DoitTaskStatus status) {
        return null;
    }

    @Override
    public DoitTask updatePriority(DoitTask task, DoitTaskPriority priority) {
        return null;
    }

    @Override
    public DoitTask updateTask(DoitTask task, String columnName, String newValue) {
        return null;
    }

    @Override
    public DoitTask update(DoitTask oldTask, DoitTask newTask) {
        return null;
    }
}
