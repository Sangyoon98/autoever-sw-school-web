import axios from "axios";
const HTTP_DOMAIN = "http://localhost:8111";
const SOCKET_URL = "ws://localhost:8111/ws/chat";

const AxiosApi = {
  //   // 로그인
  //   login: async (email, pw) => {
  //     console.log("이메일 : ", email);
  //     console.log("패스워드 : ", pw);
  //     const login = {
  //       email: email,
  //       pwd: pw,
  //     };
  //     return await axios.post(HTTP_DOMAIN + "/auth/login", login);
  //   },
  //   // 가입여부 확인
  //   regCheck: async (email) => {
  //     return await axios.get(HTTP_DOMAIN + `/auth/exists/${email}`);
  //   },
  //   // 회원 가입
  //   signup: async (email, pw, name) => {
  //     console.log("이메일 : ", email);
  //     console.log("패스워드 : ", pw);
  //     console.log("이름 : ", name);
  //     const member = {
  //       email: email,
  //       pwd: pw,
  //       name: name,
  //       imgPath: "",
  //     };
  //     return await axios.post(HTTP_DOMAIN + `/auth/signup`, member);
  //   },
  //   // 전체 회원 조회
  //   memberList: async () => {
  //     return await axios.get(HTTP_DOMAIN + "/member/list");
  //   },
  //   // 개별 회원 조회
  //   memberInfo: async (email) => {
  //     return await axios.get(HTTP_DOMAIN + `/member/${email}`);
  //   },
  // 채팅방 목록 가져 오기
  chatList: async () => {
    return await axios.get(HTTP_DOMAIN + "/chat/list");
  },
  // 채팅방 생성하기
  chatCreate: async (email, name) => {
    console.log(email, name);
    const chat = {
      email: email,
      name: name,
    };
    return await axios.post(HTTP_DOMAIN + "/chat/new", chat);
  },
  // 채팅방 정보 가져오기
  chatDetail: async (roomId) => {
    return await axios.get(HTTP_DOMAIN + `/chat/room/${roomId}`);
  },
};

export default AxiosApi;
