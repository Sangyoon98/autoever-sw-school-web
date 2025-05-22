<template>
  <CategoryTemplate>
    <CategoryInsert @insert="onInsert" />
    <CategoryList :cates="categories" @remove="onRemove" />
  </CategoryTemplate>
</template>

<script setup>
import { ref, onMounted } from "vue";
import CategoryTemplate from "../components/category/CategoryTemplate.vue";
import { useCategoryApi } from "../api/category";
import { useUserStore } from "../stores/user";
import { useModalStore } from "../stores/modal"; // ✅ 모달 store import
import CategoryInsert from "../components/category/CategoryInsert.vue";
import CategoryList from "../components/category/CategoryList.vue";

const { categoryList, categoryRegister, categoryDelete } = useCategoryApi();
const userStore = useUserStore();
const categories = ref([]);
const selectedCategoryId = ref(null);
const modal = useModalStore();

const loadCategory = async () => {
  const res = await categoryList();
  categories.value = res.data;
};

onMounted(loadCategory);

const onInsert = async (text) => {
  try {
    const res = await categoryRegister(userStore.email, text);
    if (res.data) await loadCategory();
    console.log("카테고리 리스트:", res.data);
  } catch (error) {
    modal.open({
      title: "오류",
      message: "카테고리 추가에 실패했습니다.",
    });
  }
};

const onRemove = (id) => {
  selectedCategoryId.value = id;
  modal.open({
    title: "오류",
    message: "카테고리를 정말 삭제하시겠습니까?",
    hasCancel: true,
    onConfirm: confirmModal,
  });
};

const confirmModal = async () => {
  try {
    const res = await categoryDelete(selectedCategoryId.value);
    if (res.data) await loadCategory();
  } catch (error) {
    modal.open({
      title: "오류",
      message: "카테고리 삭제에 실패했습니다.",
    });
  }
};
</script>
