package doit.core.database;

import doit.core.configuration.DoitConfigurationManager;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Almaz on 21.08.2015.
 */
public class DatabaseHelper {
    private static Logger LOG = Logger.getLogger(DatabaseHelper.class);
    private static Connection fileBasedModeConnection;

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
}
