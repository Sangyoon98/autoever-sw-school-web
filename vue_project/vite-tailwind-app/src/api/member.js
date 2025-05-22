import axios from "./axiosInstance";

export const useMemberApi = () => {
  const memberList = async () => {
    return await axios.get("/users/list");
  };

  const memberDetail = async (email) => {
    return await axios.get(`/users/detail/${email}`);
  };

  const memberModify = async (email, image, name, pwd) => {
    return await axios.put("/users/modify", { email, image, name, pwd });
  };

  return {
    memberList,
    memberDetail,
    memberModify,
  };
};
