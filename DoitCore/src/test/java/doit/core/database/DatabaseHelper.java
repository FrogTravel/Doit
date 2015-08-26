package doit.core.database;

import doit.core.configuration.DoitConfigurationManager;
import org.apache.log4j.Logger;
import org.h2.jdbcx.JdbcDataSource;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Almaz on 21.08.2015.
 */
public class DatabaseHelper {
    private static Logger LOG = Logger.getLogger(DatabaseHelper.class);
    private static Connection fileBasedModeConnection;
    private static JdbcDataSource dataSource;


    public static Connection getFileBasedDatabaseConnection() throws Exception{
        if(fileBasedModeConnection == null) {
            String home = System.getProperty("user.dir");
            String fileName = DoitConfigurationManager.DATABASE_FILE_NAME;
            LOG.debug(home);

            Class.forName("org.h2.Driver").newInstance();
            fileBasedModeConnection = DriverManager.getConnection("jdbc:h2:file:"+home+fileName);
        }
        return fileBasedModeConnection;
    }
    public static DataSource getDataSource(){
        if(dataSource == null){
            dataSource = new JdbcDataSource();
            dataSource.setURL(DoitConfigurationManager.DATABASE_URL);
            dataSource.setUser(DoitConfigurationManager.DATABASE_USER_NAME);
            dataSource.setPassword(DoitConfigurationManager.DATABASE_USER_PASS);
        }
        return dataSource;
    }
}
