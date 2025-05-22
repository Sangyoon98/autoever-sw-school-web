<template>
  <div
    :style="{ backgroundColor: themeStore.color }"
    class="min-h-screen transition-all"
  >
    <router-view />
  </div>
  <Modal />
</template>

<script setup>
import { useThemeStore } from "./stores/theme";
import Modal from "./components/base/Modal.vue";

const themeStore = useThemeStore();
</script>
