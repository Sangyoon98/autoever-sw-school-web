<template>
  <div class="px-8 pb-40 relative">
    <h1 class="text-center text-2xl font-bold text-gray-800">게시판 목록</h1>
    <select
      class="border rounded px-4 py-2 mt-6 mb-4 w-52"
      v-model="selectedCategory"
    >
      <option value="all">전체</option>
      <option
        v-for="category in categories"
        :key="category.categoryId"
        :value="category.categoryId"
      >
        {{ category.categoryName }}
      </option>
    </select>

    <BoardList :boardList="boardList" @detail="goDetail" />

    <button
      @click="goWrite"
      class="fixed bottom-20 right-8 bg-sky-500 hover:bg-sky-600 text-white rounded-full w-14 h-14 text-3xl shadow-lg"
    >
      +
    </button>
  </div>
</template>

<script setup>
import { ref, onMounted, watch } from "vue";
import { useRouter } from "vue-router";
import { useBoardApi } from "../api/board";
import { useCategoryApi } from "../api/category";
import BoardList from "../components/board/BoardList.vue";

const { boardList: fetchBoardList } = useBoardApi();
const { categoryList } = useCategoryApi();
const categories = ref([]);
const boardList = ref([]);
const selectedCategory = ref("all");
const router = useRouter();

onMounted(async () => {
  const res = await categoryList();
  categories.value = res.data;
  await loadBoardList();
});

watch(selectedCategory, async () => {
  await loadBoardList();
});

const loadBoardList = async () => {
  const res = await fetchBoardList();
  boardList.value =
    selectedCategory.value === "all"
      ? res.data
      : res.data.filter(
          (board) => board.categoryId === parseInt(selectedCategory.value)
        );
};

const goDetail = (id) => {
  router.push(`/boardDetail/${id}`);
};

const goWrite = () => {
  router.push("/boardWrite");
};
</script>
