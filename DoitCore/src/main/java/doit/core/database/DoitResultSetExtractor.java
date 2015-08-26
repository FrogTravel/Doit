package doit.core.database;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Almaz on 23.08.2015.
 */
public class DoitResultSetExtractor<T> implements ResultSetExtractor<T>{
    @Override
    public T extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        return null;
    }
}
