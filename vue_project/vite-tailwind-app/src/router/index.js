import { createRouter, createWebHistory } from "vue-router";
import Login from "../pages/Login.vue";
import SignUp from "../pages/SignUp.vue";
import Layout from "../HomeLayout.vue";
import UserList from "../pages/UserList.vue";
import ThemeSetting from "../pages/ThemeSetting.vue";
import Home from "../pages/Home.vue";

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
      { path: "/members", name: "User", component: UserList },
      { path: "/theme", name: "Theme", component: ThemeSetting },
    ],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
