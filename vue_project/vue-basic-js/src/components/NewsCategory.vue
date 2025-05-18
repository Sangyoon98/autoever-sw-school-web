<template>
  <div>
    <p @click="() => category('전체')">전체</p>
    <p @click="() => category('정치')">정치</p>
    <p @click="() => category('경제')">경제</p>
    <p @click="() => category('사회')">사회</p>
    <p @click="() => category('문화')">문화</p>
    <p @click="() => category('과학')">과학</p>
  </div>
</template>

<script setup>
const emit = defineEmits(["select-category"]);
const category = (cate) => {
  emit("select-category", cate);
};
</script>

<style scoped>
div {
  display: flex;
  gap: 10px;
}

p {
  padding: 10px 20px;
  background-color: aliceblue;
  cursor: pointer;
}
</style>
