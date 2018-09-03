import jr.Hellolet;
import jr.Jrlet;
import jr.Timelet;
import sub.FileSender;
import sub.JrletFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class Server4 {

    //bad code
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(7777);
        final JrletFactory factory = new JrletFactory();

        while(true){

            Socket socket = serverSocket.accept();

            new Thread(() -> {
                System.out.println(socket);
                try(
                        InputStream inputStream = socket.getInputStream();
                        OutputStream outputStream = socket.getOutputStream();
                        Scanner inScanner = new Scanner(inputStream);
                ){

                    String firstLine = inScanner.nextLine();
                    System.out.println(firstLine);

                    String[] arr = firstLine.split(" ");

                    // /input.html /bmi /aaa.jpg
                    String target = arr[1];

                    if(target.contains("favicon")){
                        return;
                    }

                    if(target.contains("test") == false) {
                        outputStream.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                        outputStream.write(new String("Cache-Control: private\r\n").getBytes());
                    }

                    if(target.endsWith(".html") ||
                            target.endsWith(".jpg") ||
                            target.endsWith(".gif") ||
                            target.endsWith(".mp3")||
                            target.endsWith(".mp4")||
                            target.endsWith(".css")||
                            target.endsWith(".js")||
                            target.endsWith(".png")) {

                        System.out.println("정적인 컨텐츠");
                        FileSender sender = new FileSender();
                        sender.sendFile(target, outputStream);
                    }else {

                        Jrlet jrlet = factory.get(target);
                        jrlet.service(target,outputStream);

                    }

                }catch(Exception ee){
                    System.out.println(ee.getMessage());
                }
            }).start();

        }//end while
    }
}