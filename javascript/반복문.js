// // 반복문 : 조건이 참인 동안 반복 수행하는 구문
// // for ; for(초기값; 최종값; 증감값), for .. in(키값 순회), for .. of(iterable 객체 반복)
// // while, do ~ while

// const prompt = require("prompt-sync")();
// let num = Number(prompt("정수 입력 : "));

// // 입력받은 정수 입력 범위의 합을 구하기
// let sum = 0; // 반드시 초기화 해줘야 함
// // while (num) {
// //   sum += num;
// //   num--;
// // }

// for (let i = 1; i <= num; i++) {
//   sum += i;
// }
// console.log(sum);

// // while문 사용 예 : 반복 횟수를 알 수 없는 경우 사용하면 유리
// // 0 ~ 200 사이를 정상 입력으로 간주
// const prompt = require("prompt-sync")();
// let age = 0;
// while (true) {
//   // 무한 반복문, 반드시 탈출 조건이 필요
//   age = Number(prompt("나이를 입력 하세요 : "));
//   if (age >= 0 && age <= 200) break;
//   console.log("나이를 잘못 입력하셨습니다.");
// }
// console.log(`당신의 나이는 ${age}세 입니다.`);

// for문
const cars = ["테슬라 모델 Y", "제네시스 G80", "그랜저", "싼타페", "코나"];
for (let i = 0; i < cars.length; i++) {
  console.log(cars[i]);
}

// for .. of : iteravble 순회 방식
for (let car of cars) {
  car += "0000";
  console.log(car);
}

for (let car of cars) {
  console.log(car);
}
