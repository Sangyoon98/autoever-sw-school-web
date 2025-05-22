<template>
  <CateTemplate>
    <CateInsert @insert="onInsert" />
    <CateList :cates="categories" @remove="onRemove" />
  </CateTemplate>
</template>

<script setup>
import { ref, onMounted } from "vue";
import CateInsert from "../components/category/CateInsert.vue";
import CateList from "../components/category/CateList.vue";
import CateTemplate from "../components/category/CateTemplate.vue";
import { useBoardApi } from "../api/board";
const { cateList, cateInsert, cateDelete } = useBoardApi();
import { useUserStore } from "../stores/user";
import { useModalStore } from "../stores/modal"; // ✅ 모달 store import
const userStore = useUserStore();
const categories = ref([]);
const selectedCategoryId = ref(null);
const modal = useModalStore();

const loadCategory = async () => {
  const res = await cateList();
  categories.value = res.data;
};

onMounted(loadCategory);

const onInsert = async (text) => {
  try {
    const res = await cateInsert(userStore.email, text);
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
    const res = await cateDelete(selectedCategoryId.value);
    if (res.data) await loadCategory();
  } catch (error) {
    modal.open({
      title: "오류",
      message: "카테고리 삭제에 실패했습니다.",
    });
  }
};
</script>
