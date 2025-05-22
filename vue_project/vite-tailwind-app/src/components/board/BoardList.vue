<template>
  <ul>
    <BoardListItem
      v-for="board in boardList"
      :key="board.boardId"
      :board="board"
      @click="onClick(board.boardId)"
    />
  </ul>
</template>

<script setup>
import BoardListItem from "./BoardListItem.vue";

const props = defineProps({ boardList: Array });
const emit = defineEmits(["detail"]);
const onClick = (id) => {
  emit("detail", id);
};
</script>
