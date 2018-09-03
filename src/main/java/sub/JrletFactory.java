package sub;

import jr.Jrlet;

import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

public class JrletFactory {


    private Properties prop;

    public JrletFactory()throws Exception{
        String path ="C:\\webroot\\jrlet.properties";
        prop = new Properties();
        prop.load(new FileInputStream(path));
    }

    public Jrlet get(String line)throws Exception{

        //  /hello /time  /bmi?we....

        int idx = line.indexOf("?");

        String targetURL = idx == -1?line:line.substring(0,idx);
        String className = prop.getProperty(targetURL);
        Object obj = Class.forName(className).newInstance();

        return (Jrlet)obj;
    }

}