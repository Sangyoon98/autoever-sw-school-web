package ArrayList응용예제;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Order {
    private final ArrayList<Product> products;
    private BigDecimal total;

    public Order() {
        products = new ArrayList<>();
        total = BigDecimal.ZERO;
    }

    public void addItem(Product product) {
        products.add(product);
        total = total.add(product.getPrice());
        System.out.println("제품이 추가되었습니다.");
    }

    public void getItem(String name) {
        String tempName = "";
        String tempPrice = "";

        for (Product product : products) {
            if (product.getName().equals(name)) {
                tempName = product.getName();
                tempPrice = String.valueOf(product.getPrice());
            }
        }

        System.out.println("이름: " + tempName);
        System.out.println("가격: " + tempPrice);
    }

    public void removeItem(String name) {
        boolean isFind = false;

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                isFind = true;
                products.remove(i);
                total = total.subtract(products.get(i).getPrice());
                break;
            }
        }

        if (isFind) System.out.println("제품이 제거되었습니다.");
        else System.out.println("제품이 제거되지 않았습니다.");
    }

    public void getProducts() {
        if (!products.isEmpty()) {
            for (int i = 0; i < products.size(); i++) {
                System.out.println("[" + (i + 1) + "]");
                System.out.println("이름: " + products.get(i).getName());
                System.out.println("가격: " + products.get(i).getPrice());
            }
        } else System.out.println("제품이 없습니다.");
    }

    public void calculateFinalPrice(BigDecimal taxRate) {
        BigDecimal rate = taxRate.divide(new BigDecimal("100"));
        BigDecimal taxAmount = total.multiply(rate);
        BigDecimal finalPrice = total.add(taxAmount);
        System.out.println("세금: " + taxAmount.setScale(2, RoundingMode.HALF_UP));
        System.out.println("최종 가격: " + finalPrice.setScale(2, RoundingMode.HALF_UP));
    }
}
