import axios from "./axiosInstance";

export const useBoardApi = () => {
  // Board Delete
  const boardDelete = async (id) => {
    return await axios.delete(`/api/board/delete/${id}`);
  };

  // Board Detail
  const boardDetail = async (id) => {
    return await axios.get(`/api/board/detail/${id}`);
  };

  // Board List
  const boardList = async () => {
    return await axios.get("/api/board/list");
  };

  // Board List (Page)
  const boardListPage = async (page) => {
    return await axios.get("/api/board/list/page");
  };

  // Board Modify
  const boardModify = async (id, title, content, categoryId, img) => {
    return await axios.put("/api/board/modify", {
      id,
      title,
      content,
      categoryId,
      img,
    });
  };

  // Board Register
  const boardWrite = async (email, title, categoryId, content, img) => {
    return await axios.post("/api/board/new", {
      title,
      content,
      categoryId,
      email,
      img,
    });
  };

  // Board Search
  const boardSearch = async (keyword) => {
    return await axios.get("/api/board/search"), { keyword };
  };

  return {
    boardDelete,
    boardDetail,
    boardList,
    boardListPage,
    boardModify,
    boardWrite,
    boardSearch,
  };
};
