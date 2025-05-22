<template>
  <div class="max-w-2xl mx-auto p-6 bg-white rounded shadow">
    <h1 class="text-center text-2xl font-bold mb-6">글쓰기</h1>
    <label class="block mb-4">
      <span class="text-gray-700">카테고리</span>
      <select
        v-model="selectedCategory"
        class="w-full mt-1 border rounded px-3 py-2"
      >
        <option value="" disabled>카테고리를 선택하세요</option>
        <option
          v-for="category in categories"
          :key="category.categoryId"
          :value="category.categoryId"
        >
          {{ category.categoryName }}
        </option>
      </select>
    </label>
    <label class="block mb-4">
      <span class="text-gray-700">제목</span>
      <input
        v-model="title"
        type="text"
        class="w-full mt-1 border rounded px-3 py-2"
      />
    </label>
    <label class="block mb-4">
      <span class="text-gray-700">내용</span>
      <textarea
        v-model="content"
        rows="5"
        class="w-full mt-1 border rounded px-3 py-2"
      ></textarea>
    </label>
    <label class="block mb-4">
      <span class="text-gray-700">이미지</span>
      <input type="file" @change="onFileChange" class="block mt-1" />
    </label>
    <button
      @click="onUpload"
      class="mb-4 px-4 py-2 bg-green-500 text-white rounded hover:bg-green-600"
    >
      이미지 업로드
    </button>
    <img
      v-if="url"
      :src="url"
      alt="Preview"
      class="w-32 h-32 object-cover rounded mb-4"
    />
    <div class="flex gap-4 justify-center">
      <button
        @click="onSubmit"
        class="px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
      >
        글쓰기
      </button>
      <button
        @click="onCancel"
        class="px-4 py-2 bg-gray-300 text-gray-700 rounded hover:bg-gray-400"
      >
        취소
      </button>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRouter } from "vue-router";
import { useBoardApi } from "../api/board";
import { useCategoryApi } from "../api/category";
import { storage } from "../api/firebase";
import { useUserStore } from "../stores/user";

const { boardWrite } = useBoardApi();
const { categoryList } = useCategoryApi();
const title = ref("");
const content = ref("");
const file = ref(null);
const url = ref("");
const categories = ref([]);
const selectedCategory = ref("");
const userStore = useUserStore();
const router = useRouter();

onMounted(async () => {
  const res = await categoryList();
  categories.value = res.data;
});

const onFileChange = (e) => {
  file.value = e.target.files[0];
};

const onUpload = async () => {
  if (!file.value) return;
  const storageRef = storage.ref();
  const fileRef = storageRef.child(file.value.name);
  await fileRef.put(file.value);
  url.value = await fileRef.getDownloadURL();
};

const onSubmit = async () => {
  const res = await boardWrite(
    userStore.email,
    title.value,
    selectedCategory.value,
    content.value,
    url.value
  );
  console.log(`res : ${res.data}`);
  if (res.data) router.push("/boards");
};

const onCancel = () => {
  router.push("/board");
};
</script>
