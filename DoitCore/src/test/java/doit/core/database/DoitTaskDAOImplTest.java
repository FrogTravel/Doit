package doit.core.database;

import doit.core.dao.DoitTaskDAO;
import doit.core.dao.DoitTaskDAOImpl;
import doit.core.entites.DoitUser;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Almaz on 25.08.2015.
 */
public class DoitTaskDAOImplTest {
    private DataSource dataSource;
    private DoitTaskDAO taskDAO;
    private DoitUser currentUser;

    @BeforeTest
    private void setUp() throws Exception{
        this.dataSource = DatabaseHelper.getDataSource();
        this.taskDAO = new DoitTaskDAOImpl(dataSource);

        insertFakeUser();
    }

    private void insertFakeUser() throws Exception{
        String insert = "INSERT INTO USERS (LOGIN, PASSWORD, EMAIL, FIRST_NAME, LAST_NAME, REGISTRATION_DATE, BIRTH_DAY)" +
                "VALUES('FAKE_USER', 'LOGIN', 'PASSWORD', 'EMAIL', 'FAKE', 'USER', {ts '2015-08-26 01:24:52.69'}," +
                "{ts '1993-02-19 12:34:56.78'})";

        Statement statement = dataSource.getConnection().createStatement();
        statement.executeUpdate(insert);

        String select = "SELECT USER_ID FROM USERS WHERE LOGIN = 'FAKE_USER'";
        ResultSet resultSet = statement.executeQuery(select);

        Assert.assertTrue(resultSet.isBeforeFirst());

        resultSet.next();
        String userId = resultSet.getString("USER_ID");
        currentUser = new DoitUser(Integer.parseInt(userId));
    }

    @Test
    public void test1() throws Exception{


    }

    @AfterTest
    public void setDown() throws Exception{
        String delete = "DELETE FROM USERS WHERE LOGIN = 'FAKE_USER'";

        Statement statement = dataSource.getConnection().createStatement();
        statement.executeUpdate(delete);

        String select = "SELECT USER_ID FROM USERS WHERE LOGIN = 'FAKE_USER'";
        ResultSet resultSet = statement.executeQuery(select);

        Assert.assertTrue(!resultSet.isBeforeFirst());
    }

}
