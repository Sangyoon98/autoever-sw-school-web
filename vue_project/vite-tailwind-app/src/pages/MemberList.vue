<template>
  <div class="p-5">
    <MemberListItem
      class="item cursor-pointer"
      v-for="item in items"
      :key="item.name"
      :item="item"
    />
  </div>
</template>

<script setup>
import { onMounted, reactive } from "vue";
import MemberListItem from "../components/member/MemberListItem.vue";
import { useRouter } from "vue-router";
import { useMemberApi } from "../api/member";

const router = useRouter();
const items = reactive([]);
const { memberList } = useMemberApi();

onMounted(async () => {
  try {
    const response = await memberList();
    items.push(...response.data);
  } catch (err) {
    console.error(err);
  }
});
</script>
