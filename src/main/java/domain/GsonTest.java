package domain;

import com.google.gson.Gson;

public class GsonTest {
// https://mvnrepository.com/artifact/com.google.code.gson/gson/2.8.5 -> 이걸 pom.xml에 넣어야함
    public static void main(String[] args) {

        Movie movie = new Movie();
        movie.setTitle("다크나이트");
        movie.setDirector("크리스토퍼놀란");
        movie.setPop(1300);
        movie.setScore(4);

        Gson gson = new Gson();

        String str = gson.toJson(movie);

        System.out.println(str);

    }
}
