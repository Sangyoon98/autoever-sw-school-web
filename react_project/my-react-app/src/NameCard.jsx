import { useState } from "react";
// 이름, 직책, 회사명, 회사주소, 이메일, 전화번호를 입력 받아 제출 버튼을 누르면 한번에 출력하기

const NameCard = () => {
  const [nameCard, setNameCard] = useState({
    name: "",
    position: "",
    company: "",
    addr: "",
    email: "",
    phone: "",
  });

  const [submit, setSubmit] = useState(false);
  const onChange = (key, value) => {
    setNameCard({ ...nameCard, [key]: value });
  };

  return (
    <div>
      <h2 className="font-bold text-xl p-5">이름 카드 만들기</h2>
      <div className="flex flex-col mx-auto gap-2 max-w-md">
        <input
          className="border-2 border-gray-300 rounded-md p-2"
          type="text"
          placeholder="이름"
          value={nameCard.name}
          onChange={(e) => onChange("name", e.target.value)}
        />
        <input
          className="border-2 border-gray-300 rounded-md p-2"
          type="text"
          placeholder="직책"
          value={nameCard.position}
          onChange={(e) => onChange("position", e.target.value)}
        />
        <input
          className="border-2 border-gray-300 rounded-md p-2"
          type="text"
          placeholder="회사명"
          value={nameCard.company}
          onChange={(e) => onChange("company", e.target.value)}
        />
        <input
          className="border-2 border-gray-300 rounded-md p-2"
          type="text"
          placeholder="회사주소"
          value={nameCard.addr}
          onChange={(e) => onChange("addr", e.target.value)}
        />
        <input
          className="border-2 border-gray-300 rounded-md p-2"
          type="text"
          placeholder="이메일"
          value={nameCard.email}
          onChange={(e) => onChange("email", e.target.value)}
        />
        <input
          className="border-2 border-gray-300 rounded-md p-2"
          type="text"
          placeholder="전화번호"
          value={nameCard.phone}
          onChange={(e) => onChange("phone", e.target.value)}
        />
        <button
          className="font-bold mt-4"
          onClick={() => {
            setSubmit(true);
            console.log(nameCard);
          }}
        >
          제출하기
        </button>
      </div>
      {submit && (
        <div className="border-2 border-gray-300 rounded-md p-2 mt-4">
          <p>이름 : {nameCard.name}</p>
          <p>직책 : {nameCard.position}</p>
          <p>회사명 : {nameCard.company}</p>
          <p>회사주소 : {nameCard.addr}</p>
          <p>이메일 : {nameCard.email}</p>
          <p>전화번호 : {nameCard.phone}</p>
        </div>
      )}
    </div>
  );
};

export default NameCard;
