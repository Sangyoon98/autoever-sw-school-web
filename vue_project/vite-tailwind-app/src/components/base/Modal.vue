<!-- src/components/base/Modal.vue -->
<template>
  <div
    v-if="modal.isOpen"
    class="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center z-50"
  >
    <div class="bg-white p-6 rounded shadow-md w-full max-w-sm text-center">
      <h2 class="text-lg font-bold mb-2">{{ modal.title }}</h2>
      <p class="mb-4">{{ modal.message }}</p>
      <div class="flex justify-center gap-4">
        <button
          @click="modal.confirm"
          class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600"
        >
          확인
        </button>
        <button
          v-if="modal.hasCancel"
          @click="modal.close"
          class="bg-gray-300 text-gray-700 px-4 py-2 rounded hover:bg-gray-400"
        >
          취소
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useModalStore } from "../../stores/modal";

const modal = useModalStore();
</script>
