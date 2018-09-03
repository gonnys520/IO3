import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MessageClient {

    //bad cord
    public static void main(String[] args) throws Exception{

        String i1 ="∧,_,∧\n" +
                "　　(`･ω･´)　 ｎ__\n" +
                "　η ＞　 ⌒＼/ ､_∃\n" +
                "(∃)/ ∧　　＼_/\n" +
                "　＼_/　＼　　丶 씰룩씰룩\n" +
                "　　　　／ 　 ﾉ\n" +
                "　　　／ ／　／\n" +
                "　　 (　(　〈\n" +
                "　　　＼ ＼　＼\n" +
                "　　 　(＿(＿＿) \n";

        Map<String, String> iconMap = new HashMap<>();
        iconMap.put("@i1","\n" +i1 +"\n");

        ServerSocket serverSocket = new ServerSocket(7777);

        System.out.println("CLIENT READY");

        while (true){
            try(
            Socket socket = serverSocket.accept();
            DataInputStream din =
                    new DataInputStream(socket.getInputStream());


            ){
                System.out.println(socket);
                String message = din.readUTF();
                System.out.println(message);

                if(message.contains("\\@i1")){
                    System.out.println(iconMap.get("@i1"));
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        //end while

    }//end main
}//end class
