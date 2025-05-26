import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import Home from "./pages/Home.jsx";
import About from "./pages/About.jsx";
import Profile from "./pages/Profile.jsx";
import Layout from "./pages/Layout.jsx";
import News from "./pages/News.jsx";

function App() {
    return (
        <Router>
            <Routes>
                <Route element={<Layout/>}>
                    <Route path="/" element={<Home/>}/>
                    <Route path="/about" element={<About/>}/>
                    <Route path="/profiles/:username" element={<Profile/>}/>
                    <Route path="/news" element={<News/>}/>
                    <Route path="/news/:category" element={<News/>}/>
                </Route>
            </Routes>
        </Router>
    );
}

export default App;
