import {useContext, useState} from "react";
import {UserContext} from "../store/UserStore.jsx";
import {useNavigate} from "react-router-dom";

const SignIn = () => {
    const {setUserId, setPassword, setName} = useContext(UserContext);
    const navigate = useNavigate()

    const [email, setEmail] = useState("");
    const [pw, setPw] = useState("");
    const [username, setUsername] = useState("");

    const handleSubmit = () => {
        setUserId(email);
        setPassword(pw);
        setName(username);
        navigate("/");
    }

    return (<div>
        <input type="email" placeholder="이메일" value={email} onChange={(e) => setEmail(e.target.value)}/>
        <input type="password" placeholder="비밀번호" value={pw} onChange={(e) => setPw(e.target.value)}/>
        <input type="text" placeholder="이름" value={username} onChange={(e) => setUsername(e.target.value)}/>
        <button onClick={handleSubmit}>로그인</button>
    </div>);
};
export default SignIn;