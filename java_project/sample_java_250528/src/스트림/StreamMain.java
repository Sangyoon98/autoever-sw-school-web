package 스트림;

// Java 8에서 도입, 배열, 컬렉션 등의 자료를 반복문 없이 람다식을 이용해 간결하고 일관된 방식으로 처리
// 일관된 연산 : 자료의 대상과 관계 없이 동일한 연산 수행
// 내부 반복 : 내부 반복을 사용하여 작업 수행
// 원본 데이터 불변
// 지연 연산 : 중간 연산은 지연(lazy)되어 최종 연산이 호출될 때 수행
// 병렬 처리 지원

import java.util.ArrayList;
import java.util.List;

public class StreamMain {
    public static void main(String[] args) {
        List<TravelCustomer> customerList = new ArrayList<>();
        customerList.add(new TravelCustomer("안유진", 23, 1000));
        customerList.add(new TravelCustomer("장원영", 22, 2000));
        customerList.add(new TravelCustomer("이서", 19, 2500));
        customerList.add(new TravelCustomer("레이", 19, 1800));

        System.out.println("고객 명단 순서대로 출력");
        customerList.stream()
                .map(TravelCustomer::getName)
                .forEach(System.out::println);

        int total = customerList.stream()
                .mapToInt(TravelCustomer::getPrice)
                .sum();
        System.out.println("총 여행 비용 : " + total);

        System.out.println("== 20세 이상 명단 출력 ==");
        customerList.stream()
                .filter(c -> c.getAge() >= 20)
                .map(TravelCustomer::getName)
                .sorted()
                .forEach(System.out::println);
    }
}

class TravelCustomer {
    private String name;
    private int age;
    private int price;

    public TravelCustomer(String name, int age, int price) {
        this.name = name;
        this.age = age;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPrice() {
        return price;
    }
}