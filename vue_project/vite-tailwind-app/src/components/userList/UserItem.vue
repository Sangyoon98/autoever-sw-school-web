<template>
  <div class="bg-white shadow-md rounded-lg p-6 mb-4 border border-gray-200">
    <h3 class="text-xl font-semibold text-gray-800 mb-2">
      이름 {{ item.name || "null" }}
    </h3>
    <p class="text-gray-600 mb-1">이메일 {{ item.email || "null" }}</p>
    <p class="text-gray-600 mb-1">비밀번호 {{ item.pwd || "null" }}</p>
  </div>
</template>

<script setup>
const props = defineProps({
  item: {
    pwd: {
      type: String,
      default: "",
    },
    name: {
      type: String,
      default: "",
    },
    email: {
      type: String,
      default: "",
    },
  },
});
</script>
