package jr;

import domain.Menu;
import service.MenuService;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Chobablet extends AbstractJrlet{


    @Override
    public void service(String line, OutputStream out) throws Exception {
        out.write(new String("Content-Type: text/html; charset=UTF-8;\r\n\r\n").getBytes());
        System.out.println("Hello Chobab");
        out.write("<h1>&emsp;&emsp;&emsp;영&emsp;&emsp;&emsp;수&emsp;&emsp;&emsp;증</h1>".getBytes());
        out.write("<h1>&emsp;메뉴&emsp;&emsp;&emsp;가격&emsp;수량&emsp;금액</h1>".getBytes());
        out.write("<hr/>".getBytes());


        Map<String, List<String>> paramMap = parse(line);

        System.out.println("-----------------------------");
        System.out.println(paramMap);
        System.out.println("-----------------------------");

        List<String> menus = paramMap.get("menu");


        System.out.println("-------------------");
        System.out.println(MenuService.INSTANCE);
        int totalPrice = 0;

        for (String menuName: menus         ) {

            Menu menu = MenuService.INSTANCE.getMenu(menuName);

            List<String> valueList = paramMap.get(menu.getCode()+"_cnt");

            int countStr = Integer.parseInt(valueList.get(0));
            int price = menu.getPrice();


            if (countStr != 0) {

                out.write(("<h1> " + menu.getName() + "&emsp;&emsp;" + menu.getPrice() + "&emsp;" + countStr + "&emsp;" + (menu.getPrice() * (countStr)) + "</h1>").getBytes());
                totalPrice += price * countStr;
//            out.write(("<img src= "+(menu.getImage()+">")).getBytes());
            }

            }
            out.write("<hr/>".getBytes());

            out.write(("<h1>&emsp;합계&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;" + totalPrice + "</h1>").getBytes());
            out.write(("&emsp;&emsp;&emsp;&emsp;<img src=chobabzoa.gif>").getBytes());
        }


//        System.out.println(menuService.getMenu("w"));


//        int wooni_count = Integer.parseInt(paramMap.get("w_cnt"));
//        int yeono_count = Integer.parseInt(paramMap.get("yeono_count"));
//        int saewoo_count = Integer.parseInt(paramMap.get("saewoo_count"));
//        int domi_count = Integer.parseInt(paramMap.get("domi_count"));
//
//        int wooniResult = 5000 *wooni_count;
//        int yeonoResult = 2000 *yeono_count;
//        int saewooResult = 4000 *saewoo_count;
//        int domiResult = 3000 *domi_count;
//        int totalPrice = wooniResult + yeonoResult + saewooResult + domiResult;
//
//
//        out.write(("<h1>메뉴 수량 금액").getBytes("UTF-8"));
//        out.write(("<h1> 우니초밥 "+ wooni_count + " " + wooniResult+"</h1>").getBytes("UTF-8"));
//        out.write(("<h1> 연어초밥"+ yeono_count + " " + yeonoResult+"</h1>").getBytes());
//        out.write(("<h1> 새우초밥" + saewooResult+"</h1>").getBytes());
//        out.write(("<h1>" + domiResult+"</h1>").getBytes());
//        out.write(("<h1>" + totalPrice+"</h1>").getBytes());



    }

