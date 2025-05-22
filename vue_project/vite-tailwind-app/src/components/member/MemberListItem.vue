<template>
  <div
    class="flex gap-5 bg-white shadow-md rounded-lg p-6 mb-4 border border-gray-200"
    @click="memberDetail"
  >
    <img
      v-if="item.image || item.imageUrl"
      :src="item.image || item.imageUrl"
      alt="프로필 이미지"
      class="w-24 h-24 rounded-full object-cover"
    />
    <div
      v-else
      class="w-24 h-24 rounded-full bg-gray-200 flex items-center justify-center text-gray-500"
    >
      No Image
    </div>
    <div class="flex flex-col">
      <h3 class="text-xl font-semibold text-gray-800 mb-2">
        이름 {{ item.name || "null" }}
      </h3>
      <p class="text-gray-600 mb-1">이메일 {{ item.email || "null" }}</p>
      <p class="text-gray-600 mb-1">비밀번호 {{ item.pwd || "null" }}</p>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from "vue-router";

const props = defineProps({
  item: {
    pwd: {
      type: String,
      default: "",
    },
    name: {
      type: String,
      default: "",
    },
    email: {
      type: String,
      default: "",
    },
    image: {
      type: String,
      default: "",
    },
  },
});

const router = useRouter();

const memberDetail = () => {
  router.push({
    name: "MemberDetail",
    params: {
      email: props.item.email,
    },
  });
};
</script>
