import {Link} from "react-router-dom";

const Home = () => {
    const role = "backend";
    return (
        <div>
            <h1>여기가 홈 입니다.</h1>
            <p>가장 먼저 보여지는 페이지 입니다.</p>
            <Link to="/about">소개 페이지로 이동</Link>
            <ul>
                <li>
                    <Link to="/profiles/frontend">Frontend 프로필로 이동</Link>
                </li>
                <li>
                    <Link to={`/profiles/${role}`}>Backend 프로필로 이동</Link>
                </li>
                <li>
                    <Link to={`/news`}>뉴스 페이지</Link>
                </li>
            </ul>
        </div>
    );
};
export default Home;
