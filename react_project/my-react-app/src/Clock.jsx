import { useEffect, useState } from "react";

const Clock = () => {
  const [time, setTime] = useState(new Date());

  // setInterval(() => {
  //   setTime(new Date());
  // }, 1000);

  useEffect(() => {
    const interval = setInterval(() => {
      setTime(new Date());
    }, 1000);
    return () => clearInterval(interval);
  });
  return (
    <div>
      <h1>Current Time: {time.toLocaleTimeString()}</h1>
    </div>
  );
};

export default Clock;
