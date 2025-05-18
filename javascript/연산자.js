// // 연산자 : 수학적인 계산을 위해 사용되거나, 참과 거짓을 판별할 때 사용
// // 산술연산자 : +, -, *, /, %, **
// // 대입연산자 : =, +=, -=, *=, /=, %=, **=
// // 증감연산자 : ++, --
// // 비교연산자 : ==, ===, !=, !==, <, <=, >, >=
// // 논리연산자 : &&, ||, !
// // 3항연산자
// // 비트연산자
// // 전개연산자
// let a = 10;
// let b = 4;
// console.log(a + b);
// console.log(a - b);
// console.log(a * b);
// console.log(a / b);
// console.log(parseInt(a / b)); // 몫
// console.log(Math.floor(a / b)); // 몫
// console.log(a % b);
// console.log(a ** 3);

// // 대입연산자
// let c = 10;
// console.log((c += 2));
// console.log((c -= 2));
// console.log((c *= 2));
// console.log((c /= 2));
// console.log((c %= 2));

// // 증감연산자
// console.log(++a);
// console.log(a);
// console.log(a++);
// console.log(a);

// // 비교연산자 : ==(값이 같은지 판단), ===(동등 비교 연산자, 값과 타입까지 비교)
// console.log(100 === "100");

// // 삼항연산자 : 참과 거짓을 구분하는 간단한 조건식인데, 연산자 취급 =;
// const age = 18;
// console.log(`당신은 ${age > 19 ? "성인" : "미성년자"}입니다.`);

// // 형변환 : 정해진 타입을 다른 타입으로 변경하는 것
// // 혈면환은 묵시적 형변환과 명시벅 형변환

// const rst = 100 + 3.14;
// console.log(typeof rst);
// console.log(10 + 10 + "10");

// console.log(100 + Number("3.14"));

// // 윤년 계산하기
// // 1. 연도가 4로 나누어 떨어짐
// // 2. 100으로 나누어 떨어지면 윤년이 아님
// // 3. 400으로 나누어지면 윤년
// const prompt = require("prompt-sync")();
// let num = parseInt(prompt("정수 입력: "));

// console.log(
//   (num % 4 == 0 && num % 100 != 0) || num % 400 == 0
//     ? `${num}은 윤년입니다.`
//     : `${num}은 윤년이 아닙니다.`
// );

// 주민등록번호를 입력 받음 : 010222-3164414
// 성별 :
// 나이 :
// 생년월일 :
// 문자열의 인덱싱과 슬라이싱 사용 : slice(시작 인덱스, 종료 인덱스)
// new Date().getFullYear()
// 7번 인덱스가 1, 2이면 19XX년대 출생, 3, 4면 20XX년대 출생, 1, 3이면 남성, 2, 4면 여성

const prompt1 = require("prompt-sync")();
const id = prompt1("주민등록번호 입력: ");

const gender = id[7] == 1 || id[7] == 3 ? "남성" : "여성";
const century = id[7] == 1 || id[7] == 2 ? 19 : 20;
const age1 = new Date().getFullYear() - (century + id.slice(0, 2)) + 1;

console.log(`성별 : ${gender}`);
console.log(`나이 : ${age1}`);
console.log(
  `생년월일 : ${century + id.slice(0, 2)}년 ${id.slice(2, 4)}월 ${id.slice(
    4,
    6
  )}일`
);
