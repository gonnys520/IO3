package sub;

import com.google.gson.Gson;
import domain.Movie;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class DataServer {


    //bad code
    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(7777);

        System.out.println("READY");

        Socket socket = serverSocket.accept();
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        ArrayList<Movie> movieArrayList = new ArrayList<>();

            Movie movie = new Movie();
            movie.setTitle("신과함께-인과연");
            movie.setDirector("김용화");
            movie.setPop(1);
            movie.setScore(3);

            Movie movie1 = new Movie();
            movie1.setTitle("너의결혼식");
            movie1.setDirector("이석근");
            movie1.setPop(2);
            movie1.setScore(3);

            Movie movie2 = new Movie();
            movie2.setTitle("공작");
            movie2.setDirector("윤종빈");
            movie2.setPop(3);
            movie2.setScore(3);

            Movie movie3 = new Movie();
            movie3.setTitle("목격자");
            movie3.setDirector("조규장");
            movie3.setPop(4);
            movie3.setScore(3);

            Movie movie4 = new Movie();
            movie4.setTitle("맘마미아!2");
            movie4.setDirector("올파커");
            movie4.setPop(5);
            movie4.setScore(3);


        movieArrayList.add(movie);
        movieArrayList.add(movie1);
        movieArrayList.add(movie2);
        movieArrayList.add(movie3);
        movieArrayList.add(movie4);

        Gson gson = new Gson();
        String str = gson.toJson(movieArrayList);
        System.out.println(str);
        dos.writeUTF(str);

        dos.close();
        socket.close();
        serverSocket.close();


    }
}

//보내는 사람이 무비 데이터 어레이 리스트로 여러개 담아서 보내고 받는 사람도 어레이 리스트로 받기


