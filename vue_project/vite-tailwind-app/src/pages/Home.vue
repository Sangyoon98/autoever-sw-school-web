<template>
  <div class="min-h-screen bg-transparent flex items-center justify-center p-4">
    <div class="grid grid-cols-2 gap-4 w-full max-w-4xl">
      <button
        class="bg-transparent border border-white text-white font-semibold py-6 rounded-lg"
        @click="navigateTo('/members')"
      >
        회원리스트
      </button>
      <button
        class="bg-transparent border border-white text-white font-semibold py-6 rounded-lg"
        @click="navigateTo('/boards')"
      >
        게시판
      </button>
      <button
        class="bg-transparent border border-white text-white font-semibold py-6 rounded-lg"
        @click="navigateTo('/category')"
      >
        카테고리
      </button>
      <button
        class="bg-transparent border border-white text-white font-semibold py-6 rounded-lg"
        @click="navigateTo('/theme')"
      >
        테마 설정
      </button>
      <button
        class="bg-transparent border border-white text-white font-semibold py-6 rounded-lg"
        @click="navigateTo('/Upload')"
      >
        업로드
      </button>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";

const router = useRouter();

const navigateTo = (path) => {
  router.push(path);
};
</script>
