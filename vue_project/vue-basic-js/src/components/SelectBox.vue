<!-- <template>
  <select v-model="fruit">
    <option disabled value="">과일을 선택하세요</option>
    <option value="apple">사과</option>
    <option value="banana">바나나</option>
    <option value="mango">망고</option>
  </select>
  <h3>선택된 과일: {{ fruit }}</h3>
</template>

<script setup>
import { ref } from "vue";

const fruit = ref("");
</script> -->

<!-- <template>
  <label><input type="radio" value="apple" v-model="selected" /> 사과</label>
  <label><input type="radio" value="orange" v-model="selected" /> 오렌지</label>
  <label><input type="radio" value="mango" v-model="selected" /> 망고</label>
  <p>선택된 과일: {{ selected }}</p>
</template>

<script setup>
import { ref } from "vue";
const selected = ref("apple");
</script> -->

<template>
  <label><input type="checkbox" value="apple" v-model="selected" /> 사과</label>
  <label
    ><input type="checkbox" value="orange" v-model="selected" /> 오렌지</label
  >
  <label><input type="checkbox" value="mango" v-model="selected" /> 망고</label>
  <p>선택된 과일: {{ selected.join(", ") }}</p>
</template>

<script setup>
import { ref } from "vue";
const selected = ref(["apple"]);
</script>
