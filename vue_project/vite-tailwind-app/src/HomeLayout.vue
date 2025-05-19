<template>
  <div class="flex flex-col min-h-screen">
    <header class="sticky top-0 bg-white shadow z-10 p-4 text-center">
      공통 헤더
    </header>

    <main class="flex-1 p-4 overflow-y-auto">
      <router-view />
    </main>

    <footer
      class="sticky flex items-center justify-center bottom-0 bg-white shadow z-10 p-4"
    >
      푸터
      <router-link
        to="/"
        class="text-right flex-grow text-blue-500 hover:underline mt-4"
        @click="logout"
      >
        로그아웃
      </router-link>
    </footer>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useRouter } from "vue-router";
const router = useRouter();
const isLogin = localStorage.getItem("isLogin");

const logout = () => {
  localStorage.setItem("isLogin", "FALSE");
};

onMounted(() => {
  if (isLogin !== "TRUE") {
    router.push("/");
  }
});
</script>
