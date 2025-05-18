const prompt = require("prompt-sync")();
let num = Number(prompt("정수 입력 : "));

/// if, if ~ else, if ~ else if ~ else
// 조건식 사용
if (num > 100) {
  console.log(`${num}은 100보다 커요.`);
} else if (num < 100) {
  console.log(`${num}은 100보다 작아요.`);
} else {
  console.log(`${num}은 100과 같아요.`);
}

// swtich ~ case : 조건값이 와야 함
let day = new Date().getDay();
const dayStr = [
  "일요일",
  "월요일",
  "화요일",
  "수요일",
  "목요일",
  "금요일",
  "토요일",
];
console.log(dayStr[day]);
