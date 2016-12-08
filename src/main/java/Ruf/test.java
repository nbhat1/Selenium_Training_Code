package Ruf;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

/**
 * Created by neeraj.bhatnagar on 11/28/2016.
 */
public class test {
    static Properties properties;

    @Test
    public static void LoadConfigFile() throws IOException {

        properties = new Properties();
        File file = new File(System.getProperty("user.dir")+"\\config.properties");
        FileReader obj = new FileReader(file);
        properties.load(obj);

        /*File file = new File(System.getProperty("user.dir")+"config.properties");
        FileInputStream fileInput = null;
        fileInput = new FileInputStream(file);
        properties = new Properties();
        properties.load(fileInput);
        System.out.println("-----test File---"+prop.getProperty("URL"));*/
    }

    @Test
    public static String getConfigFileData(String Data) throws IOException {
        LoadConfigFile();
        String data = properties.getProperty(Data);
        System.out.println(data);
        return data;
    }
    @Test
    public void checkUserDirectory(){
        //System.getProperty("user.dir");
        System.out.println(System.getProperty("user.dir"));
    }
}
