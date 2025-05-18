// 자바스크립트는 원시 타입을 제외한 모든 값이 객체
// 객체 리터럴은 중괄호 {}로 생성, 속성과 값의 쌍으로 구성

const person = {
  title: "지구오락실",
  name: "안유진",
  age: 23,
  job: "IVE",
};

console.log(person);

const member = {
  id: "user01",
  pwd: "qwer1234",
  addr: {
    home: "경기도 수원시",
    company: "서울시 금천구",
  },
  name: "채상윤",
  func1: () => {
    console.log("함수 호출입니다.");
  },
};

member.func1();

const members = [
  {
    id: "user01",
    pwd: "qwer1234",
    addr: "경기도 수원시",
    name: "채상윤",
  },
  {
    id: "user02",
    pwd: "asdf1234",
    addr: "서울시 강남구",
    name: "안유진",
  },
  {
    id: "user03",
    pwd: "zxcv1234",
    addr: "부산시 해운대구",
    name: "김민주",
  },
  {
    id: "user04",
    pwd: "qwer1234",
    addr: "대전시 유성구",
    name: "장원영",
  },
  {
    id: "user05",
    pwd: "asdf1234",
    addr: "경기도 성남시",
    name: "이서",
  },
  {
    id: "user06",
    pwd: "zxcv1234",
    addr: "서울시 송파구",
    name: "리세",
  },
];

members.map((member) => {
  console.log("아이디 : " + member.name);
  console.log("비밀번호 : " + member.pwd);
  console.log("주소 : " + member.addr);
  console.log("이름 : " + member.name);
  console.log("===================================");
});
