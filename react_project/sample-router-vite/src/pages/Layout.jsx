import {Outlet} from "react-router-dom";

const Layout = () => {
    return (
        <div style={{display: "flex", flexDirection: "column", height: "100vh"}}>
            <header style={{ background: "lightgray", padding: 16, fontSize: 24 }}>
                Header
            </header>
            <main style={{flex: 1}}>
                <Outlet />
            </main>
            <footer style={{ background: "lightgray", padding: 16, fontSize: 24 }}>여기는 푸터입니다.</footer>
        </div>
    )
};

export default Layout;