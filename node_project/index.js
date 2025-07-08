// const express = require("express");
// const app = express();
// const port = 3000;

// // JSON Parsing
// app.use(express.json());

// // 서버 실행
// app.listen(port, () => {
//   console.log(`Server is running on http://localhost:${port}`);
// });

// app.get("/", (req, res) => {
//   res.send("안녕하세요. 여기는 Node + Express 서버입니다.");
// });

// // 테스트용 데이터 생성
// let members = [
//   {
//     id: 1,
//     name: "안유진",
//     email: "yujin@ive.com",
//     password: "1234",
//     address: "서울시 강남구",
//   },
//   {
//     id: 2,
//     name: "장원영",
//     email: "wonyoung@ive.com",
//     password: "abcd",
//     address: "서울시 서초구",
//   },
//   {
//     id: 2,
//     name: "이서",
//     email: "is@ive.com",
//     password: "abcd",
//     address: "서울시 강동구",
//   },
// ];

// // 전체 조회
// app.get("/members", (req, res) => {
//   res.json(members);
// });

// // 단건 조회
// app.get("/members/:id", (req, res) => {
//   const member = members.find((m) => m.id === parseInt(req.params.id));
//   if (!member) return res.status(404).send("Member not found");
//   res.json(member);
// });

// // 회원 등록 : POST
// app.post("/members", (req, res) => {
//   const { name, email, password, address } = req.body;
//   const newMember = {
//     id: members.length + 1,
//     name,
//     email,
//     password,
//     address,
//   };
//   // members.push(newMember);  // 파괴적 메서드
//   members = [...members, newMember]; // 비파괴적 메서드, 불변성 원칙 유지, 새 배열로 할당, 주소가 변경됨
//   res.status(201).json(newMember);
// });

const express = require("express");
const app = express();
const port = 3000;

app.use(express.json()); // JSON 바디 파서

// Sequelize ORM 연결
const { Sequelize } = require("sequelize");
const MemberModel = require("./models/member");

const sequelize = new Sequelize("node_memberdb", "root", "1234", {
  host: "localhost",
  dialect: "mysql",
});

const Member = MemberModel(sequelize, Sequelize.DataTypes);

// 테이블 동기화
sequelize
  .sync({ force: false }) // force: true → 테이블 DROP 후 재생성됨
  .then(() => console.log("✅ DB 연결 및 테이블 동기화 완료!"))
  .catch((err) => console.error("❌ DB 연결 실패:", err));

// GET: 회원 목록 조회
app.get("/members", async (req, res) => {
  const members = await Member.findAll();
  res.json(members);
});

// POST: 회원 등록
app.post("/members", async (req, res) => {
  try {
    const newMember = await Member.create(req.body);
    res.status(201).json(newMember);
  } catch (error) {
    res.status(400).json({ error: error.message });
  }
});

// 서버 실행
app.listen(port, () => {
  console.log(`🚀 Server running at http://localhost:${port}`);
});
