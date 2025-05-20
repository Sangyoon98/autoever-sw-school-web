<template>
  <div
    :style="{ backgroundColor: themeStore.color }"
    class="min-h-screen transition-all"
  >
    <router-view />
  </div>
  <Modal />
  <ModalConfirm />
</template>

<script setup>
import { useThemeStore } from "./stores/theme";
import Modal from "./components/base/Modal.vue";
import ModalConfirm from "./components/base/ModalConfirm.vue";

const themeStore = useThemeStore();
</script>
