import axios from "./axiosInstance";

export const useCategoryApi = () => {
  // Category Delete
  const categoryDelete = async (categoryId) => {
    return await axios.delete(`/api/category/delete/${categoryId}`);
  };

  // Category List
  const categoryList = async () => {
    return await axios.get("/api/category/list");
  };

  // Category Modify
  const categoryModify = async (email, categoryId, categoryName) => {
    return await axios.put(`/api/category/modify/${categoryId}`, {
      email,
      categoryId,
      categoryName,
    });
  };

  // Category Register
  const categoryRegister = async (email, categoryName) => {
    return await axios.post("/api/category/new", { email, categoryName });
  };

  return {
    categoryDelete,
    categoryList,
    categoryModify,
    categoryRegister,
  };
};
