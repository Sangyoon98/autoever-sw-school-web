<template>
  <input v-model="inputText" @keydown.enter="addUser" />
  <button @click="addUser">추가</button>
  <ul>
    <li
      v-for="user in users"
      :key="user.id"
      @dblclick="() => removeTodo(user.id)"
    >
      {{ user.toDo }}
    </li>
  </ul>
</template>

<script setup>
import { ref, watch } from "vue";

const stored = localStorage.getItem("users");
const users = ref(
  stored
    ? JSON.parse(stored)
    : [
        { id: 1, toDo: "Vue 학습 시작" },
        { id: 2, toDo: "Composition API 익히기" },
      ]
);

const inputText = ref("");
const nextId = ref(3);

const addUser = () => {
  if (!inputText.value.trim()) return;
  users.value.push({ id: nextId.value++, toDo: inputText.value });
  inputText.value = "";
};

const removeTodo = (id) => {
  users.value = users.value.filter((user) => user.id !== id);
};

watch(
  users,
  (newVal) => {
    localStorage.setItem("users", JSON.stringify(newVal));
  },
  { deep: true }
);
</script>
