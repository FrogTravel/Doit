package doit.core.database;

import doit.core.configuration.DoitConfigurationManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Almaz on 21.08.2015.
 */
public class DatabaseCreateDBStructureTest {
    private Logger LOG = Logger.getLogger(DatabaseCreateDBStructureTest.class);
    private Connection connection;
    private Statement statement;
    private List<String> tables = Arrays.asList("USERS", "TASKS", "ATTACHMENTS", "HISTORY");

    @BeforeTest
    private void setUp() throws Exception {
        connection = DatabaseHelper.getDataSource().getConnection();
        statement = connection.createStatement();
    }

    public int getNumberRows(ResultSet resultSet) throws Exception{
        int size = 0;
        resultSet.last();
        size = resultSet.getRow();
        resultSet.beforeFirst();

        return size;
    }

    private List<File> getDbScripts() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("scripts/");

        return Arrays.asList(new File(resource.getFile()).listFiles());
    }

    @Test
    public void testCreateTableStructure() throws Exception {
        List<File> dbScripts = getDbScripts();
        for (File dbScript : dbScripts) {
            String sql = FileUtils.readFileToString(dbScript);
            statement.executeUpdate(sql);
        }

        statement = connection.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = statement.executeQuery("show tables");

        Assert.assertEquals(getNumberRows(rs), DoitConfigurationManager.DATABASE_TABLE_COUNT);

        while (rs.next()){
            String tableName = rs.getString("TABLE_NAME");

            Assert.assertTrue(tables.contains(tableName));
        }
    }

    @Test
    public void testExistTablesInDB() throws Exception {
        ResultSet rs = statement.executeQuery("show tables");

        Assert.assertTrue(rs.isBeforeFirst());

        Assert.assertEquals(getNumberRows(rs), DoitConfigurationManager.DATABASE_TABLE_COUNT);

        while (rs.next()){
            String tableName = rs.getString("TABLE_NAME");

            Assert.assertTrue(tables.contains(tableName));
        }
    }
}
