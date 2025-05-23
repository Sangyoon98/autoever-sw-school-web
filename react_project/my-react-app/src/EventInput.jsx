import { useState } from "react";

const EventInput = () => {
  const [message, setMessage] = useState("안녕하세요");
  const changeMsg = (e) => {
    setMessage(e.target.value);
  };
  return (
    <div>
      <h1>이벤트 연습</h1>
      <input
        type="text"
        placeholder="아무거나 입력하세요."
        onChange={(e) => changeMsg(e)} // onChange={changeMsg} 같은 의미
        value={message}
      />
      <h2>입력받은 메시지 : {message}</h2>
    </div>
  );
};

export default EventInput;
