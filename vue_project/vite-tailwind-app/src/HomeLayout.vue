<template>
  <div class="flex flex-col min-h-screen">
    <header
      class="sticky flex items-center justify-between top-0 bg-white shadow z-10 p-4 text-center"
    >
      <p class="flex-grow text-left">공통 헤더</p>
      <div>{{ userStore.email }}</div>
    </header>

    <main class="flex-1 p-4 overflow-y-auto">
      <router-view />
    </main>

    <footer
      class="sticky flex items-center justify-between bottom-0 bg-white shadow z-10 p-4"
    >
      푸터
      <div>
        <button
          class="text-center text-blue-500 hover:underline mt-4"
          @click="logout"
        >
          로그아웃
        </button>
      </div>
    </footer>
  </div>
</template>

<script setup>
import { onMounted } from "vue";
import { useRouter } from "vue-router";
import { useUserStore } from "./stores/user";
import { useModalConfirmStore } from "./stores/modalConfirm";
const router = useRouter();
const isLogin = localStorage.getItem("isLogin");
const userStore = useUserStore();
const modalConfirmStore = useModalConfirmStore();

const logout = () => {
  modalConfirmStore.openModal({
    title: "로그아웃",
    message: "로그아웃 하시겠습니까?",
    onConfirm: () => {
      localStorage.setItem("isLogin", "FALSE");
      router.push("/");
    },
  });
};

onMounted(() => {
  if (isLogin !== "TRUE") {
    router.push("/");
  }
});
</script>
