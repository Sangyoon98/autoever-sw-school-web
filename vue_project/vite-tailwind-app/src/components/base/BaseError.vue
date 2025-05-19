<template>
  <p :class="error ? 'text-red-500 px-5 py-1' : 'hidden'">
    <slot>에러 메시지</slot>
  </p>
</template>

<script setup>
defineProps({
  error: {
    type: Boolean,
    default: false,
  },
});
</script>
