import {Link, useNavigate} from "react-router-dom";
import {useContext, useState} from "react";
import {UserContext} from "../store/UserStore.jsx";

const Login = () => {
    const {userId, password} = useContext(UserContext);
    const navigate = useNavigate();

    const [email, setEmail] = useState("");
    const [pw, setPw] = useState("");

    const handleSubmit = () => {
        if (email === userId && pw === password) {
            navigate("/home");
        } else {
            alert("로그인 실패");
        }
    }

    return (
        <div>
            <input type="email" placeholder="이메일" value={email} onChange={(e) => setEmail(e.target.value)}/>
            <input type="password" placeholder="비밀번호" value={pw} onChange={(e) => setPw(e.target.value)}/>
            <button onClick={handleSubmit}>로그인</button>
            <Link to={"/SignIn"}>회원가입</Link>
        </div>
    );
};

export default Login;