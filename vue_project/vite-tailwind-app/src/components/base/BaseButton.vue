<template>
  <button
    @click="onclick"
    class="w-full p-4 mt-4 bg-blue-500 hover:bg-blue-600 text-white font-bold rounded-full"
  >
    <slot>기본 버튼</slot>
  </button>
</template>

<script setup>
const emit = defineEmits(["click"]);
const onclick = (event) => {
  emit("click", event);
};
</script>
