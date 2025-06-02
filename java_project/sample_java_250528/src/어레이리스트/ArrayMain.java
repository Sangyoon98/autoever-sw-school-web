package 어레이리스트;

import java.util.ArrayList;
import java.util.List;

public class ArrayMain {
    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();
        menuList.add(new Menu("Americano", 2000, "coffee", "커피", true));
        menuList.add(new Menu("Latte", 4500, "coffee", "우유 커피", true));
        menuList.add(new Menu("Moca", 5500, "coffee", "달달한 커피", true));

        for (Menu menu : menuList) {
            System.out.println(menu);
        }
    }
}
