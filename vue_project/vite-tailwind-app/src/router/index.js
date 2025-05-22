import { createRouter, createWebHistory } from "vue-router";
import Login from "../pages/Login.vue";
import SignUp from "../pages/SignUp.vue";
import Layout from "../HomeLayout.vue";
import ThemeSetting from "../pages/ThemeSetting.vue";
import Home from "../pages/Home.vue";
import ImageUploader from "../pages/ImageUploader.vue";
import Category from "../pages/Category.vue";
import Board from "../pages/Board.vue";
import BoardDetailPage from "../pages/BoardDetailPage.vue";
import BoardWrite from "../pages/BoardWrite.vue";
import MemberList from "../pages/MemberList.vue";
import MemberDetail from "../pages/MemberDetail.vue";

const routes = [
  { path: "/", name: "Login", component: Login },
  { path: "/signup", name: "Signup", component: SignUp },
  // { path: "/theme", name: "Theme", component: ThemeSetting },

  {
    path: "/home",
    name: "HomeLayout",
    component: Layout,
    children: [
      { path: "", name: "Home", component: Home },
      { path: "/members", name: "User", component: MemberList },
      {
        path: "/membersDetail/:email",
        name: "MemberDetail",
        component: MemberDetail,
      },
      { path: "/boards", name: "Boards", component: Board },
      {
        path: "/boardDetail/:id",
        name: "BoardDetail",
        component: BoardDetailPage,
      },
      {
        path: "/boardWrite",
        name: "BoardWrite",
        component: BoardWrite,
      },
      { path: "/category", name: "Category", component: Category },
      { path: "/theme", name: "Theme", component: ThemeSetting },
      { path: "/upload", name: "Upload", component: ImageUploader },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
