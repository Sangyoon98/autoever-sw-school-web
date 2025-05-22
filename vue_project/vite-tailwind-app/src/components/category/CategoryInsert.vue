<template>
  <form @submit.prevent="onSubmit" class="flex bg-gray-700">
    <input
      v-model="value"
      type="text"
      placeholder="카테고리 입력"
      class="flex-1 px-4 py-2 text-white bg-transparent border-none outline-none placeholder-gray-300"
    />
    <button
      type="submit"
      class="px-4 text-white bg-gray-500 hover:bg-orange-500"
    >
      ➕
    </button>
  </form>
</template>

<script setup>
import { ref } from "vue";

const emit = defineEmits(["insert"]);
const value = ref("");
const onSubmit = () => {
  emit("insert", value.value);
  value.value = "";
};
</script>
