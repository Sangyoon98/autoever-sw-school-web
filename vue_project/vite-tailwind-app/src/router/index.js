import { createRouter, createWebHistory } from "vue-router";
import Login from "../pages/Login.vue";
import SignUp from "../pages/SignUp.vue";
import Layout from "../HomeLayout.vue";
import UserList from "../pages/UserList.vue";

const routes = [
  { path: "/", name: "Login", component: Login },
  { path: "/signup", name: "Signup", component: SignUp },

  {
    path: "/home",
    name: "Home",
    component: Layout,
    children: [{ path: "", name: "User", component: UserList }],
  },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
