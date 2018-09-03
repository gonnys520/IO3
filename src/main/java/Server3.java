import sub.Discomfort;
import sub.RequestParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class Server3 {

    //bad code
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(7777);

        while (true) {


            try (
                    Socket socket = serverSocket.accept();
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();
                    Scanner inScanner = new Scanner(inputStream);
            ) {
                System.out.println(socket);
                String firstLine = inScanner.nextLine();
                System.out.println(firstLine);

                String[] arr = firstLine.split(" ");
                String target = arr[1];

                outputStream.write(new String("HTTP/1.1 200 OK\r\n").getBytes());
                outputStream.write(new String("Cache-Control: private\r\n").getBytes());
//                outputStream.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());

                // if: 아무것도 없이 /로만 끝날 때
                if (target.equals("/")) {
                    System.out.println("skip");

                    // else if : .html로 끝날 때
                } else if (target.endsWith(".html")) { //endsWith은 .html로 끝나면! 이라는 뜻
                    System.out.println("input page service");
                    outputStream.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());
//                    outputStream.write("<h1>input page service</h1>".getBytes());

                    // "C:\\zzz\\"폴더에서 target 배열에 담긴 문자열을 1번째부터 끝까지 담는다(substring은 index값부터 끝의 문자열을 리턴함)
                    File targetFile = new File("C:\\zzz\\" + target.substring(1));
                    FileInputStream fin = new FileInputStream(targetFile);
                    System.out.println(fin);

                    // 위에서 가져온 파일데이터를 읽어낸다.
                    byte[] buffer = new byte[1024 * 8];

                    while (true) {
                        int count = fin.read(buffer);
                        if (count == -1) {
                            break;
                        }
                        outputStream.write(buffer, 0, count);

                    }
                    fin.close();

                    //URL의 끝이 /bmi일경우
                } else if (target.startsWith("/bmi")) { //startsWhit은 /bmi가 시작된다면! 이라는 뜻
                    System.out.println("bmi service");

                    // 웹페이지에 bmi service를 출력
                    outputStream.write("<h1>bmi service</h1>".getBytes());
                    outputStream.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());

                    //RequestParse class(url뒷부분을 세부적으로 나눈거)를 적용한다. 파싱한 후 전달.
                    Map<String, String> paramMap = RequestParser.parse(target);

                    double height = Double.parseDouble(paramMap.get("height"));
                    double weight = Double.parseDouble(paramMap.get("weight"));
                    int bmi = (int) (Math.round(weight / (height * height)));

                    outputStream.write(("<h1>" + paramMap.get("height") + "</h1>").getBytes());
                    outputStream.write(("<h1>" + paramMap.get("weight") + "</h1>").getBytes());
                    outputStream.write(("<hr/>").getBytes());
                    outputStream.write(("<h2>" + bmi + "</h2>").getBytes());


                } else if (target.endsWith(".jpg")) {
                    System.out.println("input page service");
                    outputStream.write(new String("Content-Type: image/jpeg;\r\n\r\n").getBytes());
//                    outputStream.write("<h1>input page service</h1>".getBytes());

                    File targetFile = new File("C:\\zzz\\" + target.substring(1));
                    FileInputStream fin = new FileInputStream(targetFile);

                    System.out.println(fin);

                    byte[] buffer = new byte[1024 * 8];

                    while (true) {
                        int count = fin.read(buffer);
                        if (count == -1) {
                            break;
                        }
                        outputStream.write(buffer, 0, count);

                    }
                    fin.close();
                } else if (target.startsWith("/discomfort")) {
                    System.out.println("discomfort service");

                    outputStream.write("<h1>discomfort service</h1>".getBytes());
                    outputStream.write(new String("Content-Type: text/html;\r\n\r\n").getBytes());


                    Map<String, String> paramMap = Discomfort.parse(target);

                    double temp = Double.parseDouble(paramMap.get("temp"));
                    double humidity = Double.parseDouble(paramMap.get("humidity"));
                    double discomport = (Math.round(((0.81* temp +0.01 * humidity)*((0.99 * temp -14.3)+46.3))));

                    outputStream.write(("<h1>" + paramMap.get("temp") + "</h1>").getBytes());
                    outputStream.write(("<h1>" + paramMap.get("humidity") + "</h1>").getBytes());
                    outputStream.write(("<hr/>").getBytes());
                    outputStream.write(("<h2>" + discomport + "</h2>").getBytes());

                    }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }//end catch
        }//end while
    }
}