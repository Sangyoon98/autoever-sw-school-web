<script setup>
// import { ref } from "vue";
// const message = ref("Vue 3 시작하기");
// const name = ref("");
import DataBinding from "./components/DataBinding.vue";
import ConditionRender from "./components/ConditionRender.vue";
import IterableArray from "./components/IterableArray.vue";
import ClassBinding from "./components/ClassBinding.vue";
import Reactive from "./components/Reactive.vue";
import Computed from "./components/Computed.vue";
import Watch from "./components/Watch.vue";
import Example from "./components/Example.vue";
import TempleteTotal from "./components/TempleteTotal.vue";
import CardView from "./components/CardView.vue";
import UserCard from "./pages/UserCard.vue";
import ChildComponent from "./components/ChildComponent.vue";
import News from "./pages/News.vue";
import EventRef from "./components/EventRef.vue";
import LoginExample from "./pages/LoginExample.vue";
import EventHandle from "./components/EventHandle.vue";
import SelectBox from "./components/SelectBox.vue";
import ArrayRender from "./components/ArrayRender.vue";
import UserList from "./pages/UserList.vue";
// import { ref } from "vue";
// const message = ref("");

// const handleMessage = (payload) => {
//   message.value = payload;
// };
</script>

<template>
  <!-- <h3>App.vue 영역 입니다.</h3> -->
  <!-- <h1>{{ name }}</h1>
  <input v-model="name" placeholder="이름 입력" /> -->
  <!-- <DataBinding /> -->
  <!-- <ConditionRender /> -->
  <!-- <IterableArray /> -->
  <!-- <ClassBinding /> -->
  <!-- <Reactive /> -->
  <!-- <Computed /> -->
  <!-- <Watch /> -->
  <!-- <Example /> -->
  <!-- <TempleteTotal /> -->
  <!-- <CardView
    v-for="member in members"
    :key="member.inputName"
    :name="member.inputName"
    :job="member.inputAge"
    :age="member.inputAddr"
  /> -->
  <!-- <UserCard /> -->
  <!-- <h2>부모 컴포넌트</h2>
  <p>자식에게 받은 메시지: {{ message }}</p>
  <ChildComponent @send-message="handleMessage" /> -->
  <!-- <News /> -->
  <!-- <EventRef /> -->
  <!-- <LoginExample /> -->
  <!-- <EventHandle /> -->
  <!-- <SelectBox /> -->
  <!-- <ArrayRender /> -->
  <UserList />
</template>

<style scoped>
h1 {
  font-size: 24px;
  color: royalblue;
}

input {
  padding: 8px;
  font-size: 18px;
  margin-top: 10px;
}
</style>
