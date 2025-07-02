<template>
  <div class="p-6 max-w-3xl mx-auto">
    <h1 class="text-3xl font-bold text-center mb-8 text-gray-800">
      🎬 박스오피스 순위
    </h1>

    <div class="space-y-4">
      <div
          v-for="movie in movies"
          :key="movie.movieCd"
          class="p-4 border rounded-lg shadow-sm hover:shadow-md transition duration-200 bg-white"
      >
        <div class="flex items-center justify-between">
          <div class="text-xl font-semibold text-indigo-600">
            {{ movie.rank }}위 - {{ movie.movieNm }}
          </div>
          <div class="text-sm text-gray-500">
            {{ movie.openDt || "개봉일 없음" }}
          </div>
        </div>
        <div class="mt-2 text-sm text-gray-700">
          🎟️ 일일 관객수: {{ Number(movie.audiCnt).toLocaleString() }}명 <br />
          💰 매출액: {{ Number(movie.salesAmt).toLocaleString() }}원
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";

const movies = ref([]);

onMounted(async () => {
  const res = await fetch("http://127.0.0.1:5000/api/boxoffice");
  const data = await res.json();
  console.log("✅ API 응답 확인:", data);
  movies.value = data;
});
</script>

<style scoped>
</style>