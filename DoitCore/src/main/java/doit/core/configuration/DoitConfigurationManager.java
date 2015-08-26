package doit.core.configuration;

import java.io.File;

/**
 * Created by Almaz on 21.08.2015.
 */
public class DoitConfigurationManager {
    public static final String DATABASE_FILE_NAME = "doit-db";
    public static final String DATABASE_URL = "jdbc:h2:file:" + System.getProperty("user.dir") +
            File.separator + DoitConfigurationManager.DATABASE_FILE_NAME;;

    public static final String DATABASE_USER_NAME = "sa";
    public static final String DATABASE_USER_PASS = "";
    public static final int DATABASE_TABLE_COUNT = 4;




}
