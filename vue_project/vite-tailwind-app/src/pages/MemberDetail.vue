<template>
  <div class="bg-white shadow-md rounded-lg p-6 mb-4 border border-gray-200">
    <div v-if="!isEditing">
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
      <h3 class="text-xl font-semibold text-gray-800 mb-2">
        이름 {{ item.name || "null" }}
      </h3>
      <p class="text-gray-600 mb-1">이메일 {{ item.email || "null" }}</p>
      <p class="text-gray-600 mb-1">비밀번호 {{ item.pwd || "null" }}</p>
      <button
        v-if="item.email === userStore.email"
        class="mt-4 px-4 py-2 bg-blue-500 text-white rounded hover:bg-blue-600"
        @click="startEdit"
      >
        수정
      </button>
    </div>
    <div v-else>
      <input
        v-model="editItem.name"
        class="border px-2 py-1 rounded mb-2 block"
      />
      <input
        v-model="editItem.email"
        class="border px-2 py-1 rounded mb-2 block"
      />
      <input
        v-model="editItem.pwd"
        class="border px-2 py-1 rounded mb-2 block"
        type="password"
      />

      <div class="p-6 space-y-4">
        <input type="file" @change="handleFileChange" />
        <button
          @click="uploadImage"
          class="bg-blue-500 text-white px-4 py-2 rounded"
        >
          업로드
        </button>
        <div v-if="imageUrl">
          <img :src="imageUrl" alt="uploaded" class="mt-4 max-w-xs" />
        </div>
      </div>

      <div class="flex gap-2 mt-2">
        <button
          @click="saveEdit"
          class="bg-green-500 text-white px-4 py-2 rounded"
        >
          저장
        </button>
        <button
          @click="cancelEdit"
          class="bg-gray-300 text-black px-4 py-2 rounded"
        >
          취소
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted } from "vue";
import { useMemberApi } from "../api/member";
import { useRoute } from "vue-router";
import { useUserStore } from "../stores/user";
import { storage } from "../api/firebase";

const userStore = useUserStore();

const route = useRoute();
const { memberDetail, memberModify } = useMemberApi();

const item = ref({
  email: "",
  name: "",
  image: "",
  pwd: "",
});

const isEditing = ref(false);
const editItem = ref({ ...item.value });

onMounted(async () => {
  const res = await memberDetail(route.params.email);
  item.value = res.data;
  editItem.value = { ...res.data };
});

function startEdit() {
  editItem.value = { ...item.value };
  isEditing.value = true;
}

function cancelEdit() {
  isEditing.value = false;
  editItem.value = { ...item.value };
}

const saveEdit = async () => {
  console.log("saveEdit", editItem.value);
  console.log("saveEdit", imageUrl.value);

  // 이미지 업로드를 안 하면 기존 이미지, 업로드 하면 새 이미지
  const finalImageUrl =
    imageUrl.value || editItem.value.image || item.value.image || "";

  editItem.value.image = finalImageUrl; // editItem에도 직접 넣어줘야 함

  const res = await memberModify(
    editItem.value.email,
    finalImageUrl,
    editItem.value.name,
    editItem.value.pwd
  );

  if (res.data) {
    item.value = { ...editItem.value };
    isEditing.value = false;
  } else {
    console.error("수정 실패");
  }
};

const file = ref(null);
const imageUrl = ref("");

const handleFileChange = (e) => {
  file.value = e.target.files[0];
};

const uploadImage = async () => {
  if (!file.value) {
    alert("파일을 선택하세요.");
    return;
  }

  try {
    const storageRef = storage.ref();
    const fileRef = storageRef.child(file.value.name);

    await fileRef.put(file.value); // ✅ await로 업로드 완료까지 대기
    const url = await fileRef.getDownloadURL(); // ✅ await로 URL 받아오기

    imageUrl.value = url;
    console.log("업로드 성공", url);
  } catch (err) {
    alert("업로드 실패: " + err.message);
  }
};
</script>
