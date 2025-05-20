<template>
  <div
    v-if="modalConfirmStore.show"
    class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50"
  >
    <div class="bg-white p-6 rounded-lg shadow-lg max-w-sm w-full mx-4">
      <h2 class="text-lg font-semibold text-center mb-4">
        {{ modalConfirmStore.title }}
      </h2>
      <p class="mb-4 text-gray-800 text-center break-words">
        {{ modalConfirmStore.message }}
      </p>
      <div class="flex justify-center gap-2">
        <button
          @click="modalConfirmStore.confirmModal"
          class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
        >
          확인
        </button>
        <button
          @click="modalConfirmStore.cancelModal"
          class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
        >
          취소
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useModalConfirmStore } from "../../stores/modalConfirm";
const modalConfirmStore = useModalConfirmStore();
</script>
