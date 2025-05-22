<template>
  <div class="overflow-y-auto max-h-96">
    <CategoryItem
      v-for="cate in cates"
      :key="cate.categoryId"
      :cate="cate"
      @remove="onRemove"
    />
  </div>
</template>

<script setup>
import CategoryItem from "./CategoryItem.vue";

defineProps({ cates: Array });
const emit = defineEmits(["remove"]);
const onRemove = (id) => emit("remove", id);
</script>
