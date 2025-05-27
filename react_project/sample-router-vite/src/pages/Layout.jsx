import {Outlet} from "react-router-dom";
import {useContext} from "react";
import {UserContext} from "../store/UserStore.jsx";

const Layout = () => {
    const {userId, name} = useContext(UserContext);

    return (
        <div style={{display: "flex", flexDirection: "column", height: "100vh"}}>
            <header style={{ background: "lightgray", padding: 16, fontSize: 24, display: "flex", justifyContent: "space-between", itemAlign: "center" }}>
                <div>Header</div>
                <div style={{fontSize: 16}}>{name} {userId}</div>
            </header>
            <main style={{flex: 1}}>
                <Outlet />
            </main>
            <footer style={{ background: "lightgray", padding: 16, fontSize: 24 }}>여기는 푸터입니다.</footer>
        </div>
    )
};

export default Layout;