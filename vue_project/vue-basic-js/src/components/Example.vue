<template>
  <div>
    <input v-model="name" placeholder="이름 입력" />
    <br />
    <input v-model="age" type="number" placeholder="나이 입력" />
    <p>나이 : {{ isAdult }}</p>
  </div>
</template>

<script setup>
import { ref, computed, onMounted, reactive, watch } from "vue";

onMounted(() => {
  console.log("컴포넌트가 마운트 됨");
});

const name = ref("");
const age = ref(0);
// const member = reactive({
//   name: "",
//   age: 0,
// });

const isAdult = computed(() => {
  if (age.value >= 20) return "성인입니다.";
  else return "성인이 아닙니다.";
});

watch(age, (newAge, oldAge) => {
  console.log(`나이 변경 : ${oldAge} -> ${newAge}`);
});
</script>
