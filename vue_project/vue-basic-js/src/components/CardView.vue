<template>
  <div class="card">
    <h2>이름: {{ name }}</h2>
    <p>직업: {{ job }}</p>
    <p>나이: {{ age }}</p>
  </div>
</template>

<script setup>
const props = defineProps({
  name: String,
  job: String,
  age: Number,
});
</script>

<style scoped>
.card {
  border: 1px solid #ccc;
  padding: 1rem;
  border-radius: 8px;
}
</style>
