<template>
  <div class="mt-8">
    <!-- 댓글 작성 폼 -->
    <form @submit.prevent="submitComment" class="mb-6 flex flex-col gap-2">
      <textarea
        v-model="content"
        placeholder="댓글을 입력하세요"
        class="border rounded px-3 py-2 text-sm focus:outline-none focus:ring resize-none"
        rows="3"
        required
      ></textarea>
      <button
        type="submit"
        class="self-end px-5 py-2 rounded bg-blue-600 text-white font-semibold hover:bg-blue-700 transition"
      >
        댓글 등록
      </button>
    </form>
    <!-- 댓글 리스트 -->
    <div
      v-for="comment in comments"
      :key="comment.id"
      class="p-3 border rounded bg-gray-50"
    >
      <div class="text-sm text-gray-700 font-semibold mb-1">
        {{ comment.email }}
      </div>
      <div class="text-gray-900">{{ comment.content }}</div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useRoute } from "vue-router";
import { useCommentApi } from "../../api/comment";
import { useUserStore } from "../../stores/user";

const userStore = useUserStore();

const { commentList, commentRegister } = useCommentApi();
const route = useRoute();
const comments = ref([]);
const content = ref("");

const loadComments = async () => {
  const res = await commentList(route.params.id);
  comments.value = res.data;
};

const submitComment = async () => {
  if (!content.value.trim()) return;
  await commentRegister(userStore.email, route.params.id, content.value);
  content.value = "";
  await loadComments();
};

onMounted(loadComments);
</script>
