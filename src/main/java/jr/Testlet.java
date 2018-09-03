package jr;

import java.io.OutputStream;


public class Testlet  extends  AbstractJrlet{


    @Override
    public void service(String line, OutputStream out) throws Exception {

        System.out.println("Testlet running  ");

        //out.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
        System.out.println("Test service");

        out.write(new String("HTTP/1.1 301 MovedPermanently\r\n").getBytes());
        out.write("Location: /b.html\r\n".getBytes());
    }
}