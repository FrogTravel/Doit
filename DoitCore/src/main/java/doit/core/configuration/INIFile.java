package doit.core.configuration;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author ekaterina
 */
public class INIFile {
    Properties iniProperty = new Properties();

    public INIFile(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(fileName)));

        try{
            String section = "";
            String line;

            while((line = br.readLine()) != null){
                if(line.startsWith(";")) continue;

                if(line.startsWith("[")){
                    section = line.substring(1, line.lastIndexOf("]")).trim();
                    continue;
                }
                addProperty(section,line);
            }
        }finally {
            br.close();
        }
    }

    /**
     *
     * @param section
     * @param line
     */
    private void addProperty(String section, String line) {
        int equalIndex = line.indexOf("=");

        if(equalIndex > 0){
            String name = section + '.' + line.substring(0,equalIndex).trim();
            String value = line.substring(equalIndex + 1).trim();
            iniProperty.put(name, value);
        }
    }

    public String getProperty(String section, String var, String def){
        return iniProperty.getProperty(section + '.' + var, def);
    }


    public int getProperty(String section, String var, int def){
        String sVal = iniProperty.getProperty(section + '.' + var, Integer.toString(def));

        return Integer.decode(sVal).intValue();
    }

    public boolean getProperty(String section, String var, boolean def){
        String sVal = iniProperty.getProperty(section + '.' + var, def ? "True" : "False");

        return sVal.equalsIgnoreCase("Yes") || sVal.equalsIgnoreCase("True");
    }

    public String getProperty(String section, String var){
        return iniProperty.getProperty(section + '.' + var);
    }
}
