package 인터페이스2;

import java.util.Scanner;

public class CocoaMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NetworkAdapter adapter;

        System.out.println("네트워크 [1] WiFi [2] 5G : ");
        int sel = sc.nextInt();
        adapter = (sel == 1) ? new WiFi() : new FiveG();

        CocoaTalk cocoaTalk = new CocoaTalk("IVE", adapter);
        cocoaTalk.writeMsg("오늘 춥죠?");
        cocoaTalk.send();
    }
}
