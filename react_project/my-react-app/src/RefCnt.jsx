import { useEffect, useRef, useState } from "react";

const RefCnt = () => {
  const cntRef = useRef(0);
  let cntTest = 100;
  const [flag, setFlag] = useState(false);

  const incrementCnt = () => {
    cntRef.current += 1;
    cntTest += 1;
    setFlag(!flag);
  };

  console.log("refCnt : ", cntRef.current);
  console.log("letCnt : ", cntTest);

  useEffect(() => {
    const interval = setInterval(incrementCnt, 1000);
    return () => clearInterval(interval);
  });

  return (
    <>
      <h3>Counter 연습</h3>
      <p>콘솔에서 값 확인</p>
    </>
  );
};

export default RefCnt;
