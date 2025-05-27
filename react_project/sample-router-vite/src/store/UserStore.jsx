import {createContext, useEffect, useState} from "react";

export const UserContext = createContext(null);

const UserStore = (props) => {
    const [userId, setUserId] = useState(localStorage.getItem("userId") || "");
    const [password, setPassword] = useState(localStorage.getItem("password") || "");
    const [name, setName] = useState(localStorage.getItem("name") || "");

    useEffect(() => {
        localStorage.setItem("userId", userId);
        localStorage.setItem("password", password);
        localStorage.setItem("name", name);
    }, [userId, password, name]);

    return(
        <UserContext.Provider value={{
            userId,
            setUserId,
            password,
            setPassword,
            name,
            setName,
        }}>
            {props.children}
        </UserContext.Provider>
    );
};

export default UserStore;
