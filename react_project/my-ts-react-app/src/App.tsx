import './App.css'
import StaticTypeComp from "./components/StaticTypeComp.tsx";
import UserComp from "./components/UserComp.tsx";

function App() {
    return (
        <>
            <p>App.js</p>
            <StaticTypeComp/>
            <UserComp user={{ name: "사용자" , age: 19, isAdult: false}}/>
        </>
    )
}

export default App
