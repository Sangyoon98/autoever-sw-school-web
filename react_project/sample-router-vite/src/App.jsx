import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Home from "./pages/Home.jsx";
import About from "./pages/About.jsx";
import Profile from "./pages/Profile.jsx";
import Layout from "./pages/Layout.jsx";
import News from "./pages/News.jsx";
import UserStore from "./store/UserStore.jsx";
import Login from "./pages/Login.jsx";
import SignIn from "./pages/SignIn.jsx";

function App() {
    return (
        <UserStore>
            <Router>
                <Routes>
                    <Route path="/" element={<Login/>}/>
                    <Route path="/signin" element={<SignIn/>}/>
                    <Route element={<Layout/>}>
                        <Route path="/home" element={<Home/>}/>
                        <Route path="/about" element={<About/>}/>
                        <Route path="/profiles/:username" element={<Profile/>}/>
                        <Route path="/news" element={<News/>}/>
                        <Route path="/news/:category" element={<News/>}/>
                    </Route>
                </Routes>
            </Router>
        </UserStore>
    );
}

export default App;
