package service;

import domain.Menu;

import java.util.HashMap;
import java.util.Map;

public enum MenuService {

    INSTANCE;

    Map<String, Menu> menuMap;

    MenuService() {

        menuMap = new HashMap<>();
        menuMap.put("w", new Menu("w","우니초밥", 5000, "wooni.jpg"));
        menuMap.put("s", new Menu("s","연어초밥", 2000, "yeono.jpg"));
        menuMap.put("sh", new Menu("sh","새우초밥", 4000, "saewoo.jpg"));
        menuMap.put("r", new Menu("r","도미초밥", 3000, "domi.jpg"));
    }

    public  Menu getMenu(String code)throws Exception{

        return menuMap.get(code);
    }

}
