<template>
  <div class="container">
    <NewsItem
      class="item"
      v-for="item in news"
      :key="item.title"
      :title="item.title"
      :content="item.content"
      :date="item.date"
      :category="item.category"
    />
  </div>
</template>

<script setup>
import { reactive, onMounted } from "vue";
import NewsItem from "./NewsItem.vue";

const props = defineProps({
  news: {
    type: Array,
    required: true,
  },
});
</script>

<style scoped>
.container {
  width: 500px;
  margin: 40px auto;
}
</style>
