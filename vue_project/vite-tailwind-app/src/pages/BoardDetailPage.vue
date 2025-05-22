<template>
  <div class="max-w-2xl mx-auto p-6 bg-white rounded shadow">
    <h1 class="text-2xl font-bold text-center mb-6">{{ board.title }}</h1>
    <p class="text-sm text-right text-gray-600 mb-4">
      작성자: {{ board.email }}
    </p>
    <img v-if="board.img" :src="board.img" class="w-full h-auto mb-4 rounded" />
    <p class="text-gray-800 leading-relaxed whitespace-pre-line">
      {{ board.content }}
    </p>
  </div>

  <CommentList />
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import { useBoardApi } from "../api/board";
import CommentList from "../components/comment/CommentList.vue";

const { boardDetail } = useBoardApi();
const board = ref({});
const route = useRoute();

onMounted(async () => {
  const res = await boardDetail(route.params.id);
  board.value = res.data;
});
</script>
