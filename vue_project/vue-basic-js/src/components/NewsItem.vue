<template>
  <div class="card">
    <img src="../assets/bg2.jpg" alt="" />
    <div class="content">
      <h3>{{ title }}</h3>
      <p>{{ content }}</p>
      <p>{{ date }}</p>
      <p>{{ category }}</p>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  title: String,
  content: String,
  date: String,
  category: String,
});
</script>

<style scoped>
* {
  padding: 0;
  margin: 0;
}

img {
  width: 100px;
  height: 100px;
  background-color: red;
}

.card {
  padding: 10px;
  display: flex;
  align-items: center;
  text-align: left;
  border-bottom: 1px solid #ccc;
  gap: 20px;
}

h3 {
  padding: 0;
}

.content {
  display: flex;
  flex-direction: column;
  gap: 5px;
}
</style>
