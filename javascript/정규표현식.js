// test() : 문자열에 패턴이 있는지 검사하고 결과를 true / false 반환
const regExp = /HELLO/;
console.log(regExp.test("Hello World!!!!"));

// exec() : 문자열에서 패턴에 일치하는 첫 번째 결과를 반환
const result = /가장+/.exec("가장 큰 실수는 포기입니다");
console.log(result); // ["가장"]

// match() : 문자열에서 패턴에 일치하는 모든 결과를 배열로 반환
const phone = "010-1234-5678 010-5006-4146 02-7898-33333";
const regNum = phone.match(/\d{3}-\d{4}-\d{4}/g);
console.log(regNum);

// 웹사이트 주소 찾기
const regex = /https?:\/\/[\w\-\.]+/g;
const urls = "http://www.naver.com https://www.google.co.kr httpdsda";
console.log(urls.match(regex));

// 이메일 검사 하기
const regex_email = /^([a-z]+\d*)+(\.?\w+)+@\w+(\.\w{2,3})+$/;
console.log(regex_email.test("example@gmail.com")); // true

// 비밀번호 정규 표현식 : 대문자, 소문자, 숫자, 특수문자 2자, 길이 8자리 이상 16자리 이하
const regex_password =
  /^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*()\-_=+{}\[\]:;"'<>,.?/~`|\\]{2,}).{8,16}$/;
console.log(regex_password.test("P@ssw0rd!!")); // true
console.log(regex_password.test("weakpass")); // false
