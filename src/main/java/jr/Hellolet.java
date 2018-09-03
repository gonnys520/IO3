package jr;

import java.io.*;

public class Hellolet extends AbstractJrlet {
    @Override
    public void service(String line, OutputStream out) throws Exception {
        out.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
        System.out.println("Hello service");
        out.write("<h1>Hello service</h1>".getBytes());

    }
}