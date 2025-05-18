<template>
  <div class="card">
    <h3>이름 {{ item.name || "null" }}</h3>
    <p>이메일 {{ item.email || "null" }}</p>
    <p>비밀번호 {{ item.pwd || "null" }}</p>
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
