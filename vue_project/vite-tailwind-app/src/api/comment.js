import axios from "./axiosInstance";

export const useCommentApi = () => {
  // Comment Delete
  const commentDelete = async (id) => {
    return await axios.delete(`/api/comment/delete/${id}`);
  };

  // Comment List
  const commentList = async (id) => {
    return await axios.get(`/api/comment/list/${id}`);
  };

  // Comment Modify
  const commentModify = async (boardId, commentId, content, email) => {
    return await axios.put("/api/comment/modify", {
      boardId,
      commentId,
      content,
      email,
    });
  };

  // Comment Register
  const commentRegister = async (email, boardId, content) => {
    return await axios.post("/api/comment/new", { email, boardId, content });
  };

  // Comment Search
  const commentSearch = async (keyword) => {
    return await axios.get("/api/comment/search", { keyword });
  };

  return {
    commentDelete,
    commentList,
    commentModify,
    commentRegister,
    commentSearch,
  };
};
