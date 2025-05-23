import { useState } from "react";

const Say = () => {
  // const [값을 읽는 변수, 값을 변경하는 함수(랜더링 발생)] = useState(초기값);
  const [message, setMessage] = useState("");
  const [color, setColor] = useState("black");
  return (
    <>
      <button onClick={() => setMessage("안녕하세요!")}>입장</button>
      <button onClick={() => setMessage("안녕히가세요!")}>퇴장</button>
      <h1 style={{ color }}>{message}</h1>
      <button style={{ color: "red" }} onClick={() => setColor("red")}>
        빨간색
      </button>
      <button style={{ color: "green" }} onClick={() => setColor("green")}>
        초록색
      </button>
      <button style={{ color: "blue" }} onClick={() => setColor("blue")}>
        파란색
      </button>
    </>
  );
};

export default Say;
