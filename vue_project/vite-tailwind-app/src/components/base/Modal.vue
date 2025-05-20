<template>
  <div
    v-if="modalStore.show"
    class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50"
  >
    <div class="bg-white p-6 rounded-lg shadow-lg max-w-sm w-full mx-4">
      <h2 class="text-lg font-semibold text-center mb-4">
        {{ modalStore.title }}
      </h2>
      <p class="mb-4 text-gray-800 text-center break-words">
        {{ modalStore.message }}
      </p>
      <div class="flex justify-center">
        <button
          @click="modalStore.closeModal"
          class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
        >
          닫기
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useModalStore } from "../../stores/modal";
const modalStore = useModalStore();
</script>
