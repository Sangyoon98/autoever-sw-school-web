import { BrowserRouter, Route, Routes } from "react-router-dom";
import Chat from "./Chat";
import ChatRoomCreate from "./ChatRoomCreate";
import Chatting from "./Chatting";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          <Route path="/chat" element={<Chat />} />
          <Route path="/chat-create" element={<ChatRoomCreate />} />
          <Route path="/chatting/:roomid" element={<Chatting />} />
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;
