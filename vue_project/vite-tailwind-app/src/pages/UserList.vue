<template>
  <div class="p-5">
    <UserItem
      class="item"
      v-for="item in items"
      :key="item.name"
      :item="item"
    />
  </div>
</template>

<script setup>
import { onMounted, reactive } from "vue";
import UserItem from "../components/userList/UserItem.vue";
import axios from "axios";
import { useRouter } from "vue-router";
const router = useRouter();

const items = reactive([]);

onMounted(async () => {
  try {
    const response = await axios.get("http://222.117.237.119:8111/users/list");
    items.push(...response.data);
  } catch (err) {
    console.error(err);
  }
});
</script>
