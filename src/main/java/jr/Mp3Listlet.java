package jr;

import java.io.File;
import java.io.OutputStream;

public class Mp3Listlet extends AbstractJrlet{
    @Override
    public void service(String line, OutputStream out) throws Exception {
        out.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
        System.out.println("Mp3 service");
        out.write("<h1>Mp3 service</h1>".getBytes());

        File mp3Folder = new File("C:\\webroot\\music");

        String[] fileNames = mp3Folder.list();
        out.write("<ul>".getBytes());
        for(String fileName: fileNames){
            out.write(("<li><a href='music/" + fileName+ "' target='songFrame'>" + fileName + "</a></li>").getBytes());
           // out.write(("<li>" + fileName + "</li>").getBytes());
        }
        out.write("</ul>".getBytes());
        out.write(("<iframe name='songFrame'></iframe>").getBytes());
    }
}
