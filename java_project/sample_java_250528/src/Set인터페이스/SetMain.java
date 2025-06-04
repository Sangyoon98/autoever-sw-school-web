package Set인터페이스;

import java.util.HashSet;

public class SetMain {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("곰돌이");
        set.add("안유진");
        set.add("정상기");
        set.add("장원영");
        set.add(new String("정상기")); // hashCode(), equals() 둘다 오버라이딩 되어 있음

        System.out.println(set);

        HashSet<Member> hashSet = new HashSet<>();
        hashSet.add(new Member(1001, "유나"));
        hashSet.add(new Member(1002, "채원"));
        hashSet.add(new Member(1002, "지수"));
        hashSet.add(new Member(1003, "카리나"));
        hashSet.add(new Member(1004, "카리나"));
        for (Member e : hashSet) e.showMember();
    }
}

class Member {
    int id;
    String name;

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member member) return this.id == member.id;
        return false;
    }

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void showMember() {
        System.out.println("아이디 : " + id);
        System.out.println("이름 : " + name);
    }
}
