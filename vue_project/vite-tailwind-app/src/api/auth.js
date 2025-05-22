import axios from "./axiosInstance";

export const useAuthApi = () => {
  // Member Exists
  const exists = async (email) => {
    return await axios.get(`/auth/exists/${email}`);
  };

  // Login
  const login = async (email, pwd) => {
    return await axios.post("/auth/login", { email, pwd });
  };

  // Signup
  const signup = async (email, pwd, name) => {
    return await axios.post("/auth/signup", { email, pwd, name });
  };

  return {
    exists,
    login,
    signup,
  };
};
