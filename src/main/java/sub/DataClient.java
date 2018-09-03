package sub;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import domain.Movie;

import java.io.DataInputStream;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class DataClient {

    //bad code
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("10.10.10.93", 7777);

        DataInputStream din = new DataInputStream(socket.getInputStream());

        String msg = din.readUTF();
        System.out.println(msg);

        Gson gson = new Gson();
        Type listType = new TypeToken<List<Movie>>() { }.getType();
        List<Movie> movieList = gson.fromJson(msg, listType);
        System.out.println(movieList);

        din.close();
        socket.close();

    }
}