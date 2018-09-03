package sub;

import java.util.HashMap;
import java.util.Map;

public class Discomfort {

        public static Map<String, String> parse(String str)throws Exception{
            int idx = str.indexOf("?");
            String query = str.substring(idx + 1);
            String[] midArr = query.split("&");

            if(midArr.length == 0){
                midArr = new String[]{query};
            }

            Map<String, String> paramMap = new HashMap<>();
            for(int i = 0; i < midArr.length; i++){
                String param = midArr[i];
                String[] paramArr = param.split("=");
                paramMap.put(paramArr[0],paramArr[1]);
            }
            return paramMap;
        }


        public static void main(String[] args) throws Exception {
            Map<String, String> paramMap = parse("/discomfort?temp=50&humidity=50");

            System.out.println(paramMap.get("temp"));

            System.out.println(parse("/login?id=aaa"));

        }
    }

