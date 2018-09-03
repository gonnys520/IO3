package jr;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract  class AbstractJrlet implements Jrlet{

    public Map<String, List<String>> parse(String str)throws Exception{
        //?
        int idx = str.indexOf("?");
        //System.out.println(idx);
        String query = str.substring(idx + 1);
        //System.out.println(query);
        //&
        String[] midArr = query.split("&");

        if(midArr.length == 0){
            midArr = new String[]{query};
        }
        //System.out.println(Arrays.toString(midArr));
        //=
        Map<String, List<String>> paramMap = new HashMap<>();

        for(int i = 0; i < midArr.length; i++){
            String param = midArr[i];
            String[] paramArr = param.split("=");

            List<String> list = paramMap.get(paramArr[0]);

            if(list == null){
                list = new ArrayList<String>();
                paramMap.put(paramArr[0], list);
            }
            list.add(paramArr[1]);

        }
        return paramMap;
    }
}