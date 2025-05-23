import "./App.css";
import Members from "./Members";
import Say from "./Say";
import EventInput from "./EventInput";
import TableMap from "./TableMap";
import NameCard from "./NameCard";
import Info from "./info";
import Clock from "./Clock";
import Counter from "./Counter";
import Average from "./Average";

function App() {
  return (
    <>
      <h2 className="font-bold">App.js 입니다.</h2>
      {/* <Members name="안유진" age={23} addr="대전" isAdult={true} />
      <Members name="장원영" age={22} addr="서울" isAdult={true} />
      <Members name="이서" age={19} addr="인천" isAdult={false} />
      <Members /> */}
      {/* <Say /> */}
      {/* <EventInput />s */}
      {/* <TableMap /> */}
      {/* <NameCard /> */}
      {/* <Info /> */}
      {/* <Clock /> */}
      {/* <Counter /> */}
      <Average />
    </>
  );
}

export default App;
