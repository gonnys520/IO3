package jr;

import service.MessageService;

import java.io.OutputStream;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

public class Messagelet extends AbstractJrlet {


    @Override
    public void service(String line, OutputStream out) throws Exception {

        Map<String, List<String>> paraMap = parse(line);

        System.out.println(paraMap);

        String content = paraMap.get("content").get(0);
        String deContent = URLDecoder.decode(content, "UTF-8");
        String deTarget = URLDecoder.decode(paraMap.get("target").get(0), "UTF-8");

        System.out.println(deContent);

        MessageService service = MessageService.INSTANCE;
        service.sendMessage(deTarget, deContent);

        out.write(new String("Content-Type: text/html; charset=UTF-8 \r\n\r\n").getBytes());
        System.out.println("Message service");
        out.write("<h1>메시지 전송 완료</h1>".getBytes("UTF-8"));
    }
}
