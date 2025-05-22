import axios from "./axiosInstance";

export const useMemberApi = () => {
  // Member Delete
  const memberDelete = async (email) => {
    return await axios.get(`/users/delete/${email}`);
  };

  // Member Detail
  const memberDetail = async (email) => {
    return await axios.get(`/users/detail/${email}`);
  };

  // Member List
  const memberList = async () => {
    return await axios.get("/users/list");
  };

  // Member Modify
  const memberModify = async (email, image, name, pwd) => {
    return await axios.put("/users/modify", { email, image, name, pwd });
  };

  return {
    memberDelete,
    memberDetail,
    memberList,
    memberModify,
  };
};
