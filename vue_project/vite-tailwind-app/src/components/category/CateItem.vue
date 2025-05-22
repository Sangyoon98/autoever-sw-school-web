<template>
  <div
    class="flex justify-between items-center px-4 py-2 border-b hover:bg-gray-100"
  >
    <div class="text-gray-700">{{ cate.categoryName }}</div>
    <button
      @click="$emit('remove', cate.categoryId)"
      class="text-red-500 hover:text-red-600"
    >
      ❌
    </button>
  </div>
</template>

<script setup>
defineProps({ cate: Object });
</script>
