package ArrayList응용예제;

import java.math.BigDecimal;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        Order order = new Order();

        while (flag) {
            System.out.println("\n==== 주문 관리 시스템 ====");
            System.out.println("1. 제품 추가");
            System.out.println("2. 제품 제거");
            System.out.println("3. 제품 목록 보기");
            System.out.println("4. 제품 보기");
            System.out.println("5. 최종 가격 계산 (세금 포함)");
            System.out.println("6. 종료");
            System.out.print("원하는 작업을 선택하세요: ");
            int choice = sc.nextInt();
            sc.nextLine();  // 버퍼 비우기

            switch (choice) {
                case 1:
                    System.out.print("제품 이름 입력: ");
                    String name = sc.next();
                    System.out.print("제품 가격 입력: ");
                    String price = sc.next();
                    order.addItem(new Product(name, price));
                    break;
                case 2:
                    System.out.print("제품 이름 입력: ");
                    String removeName = sc.next();
                    order.removeItem(removeName);
                    break;
                case 3:
                    order.getProducts();
                    break;
                case 4:
                    System.out.print("제품 이름 입력: ");
                    String getName = sc.next();
                    order.getItem(getName);
                    break;
                case 5:
                    System.out.print("세금 입력: ");
                    String tax = sc.next();
                    order.calculateFinalPrice(new BigDecimal(tax));
                case 6:
                    flag = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}
